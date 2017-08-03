package org.gooru.nucleus.dataclass.api.gateway.routes.utils;

import java.util.Map.Entry;

import org.gooru.nucleus.dataclass.api.gateway.constants.HttpConstants;
import org.gooru.nucleus.dataclass.api.gateway.constants.MessageConstants;

import com.hazelcast.util.StringUtil;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by ashish on 30/12/15.
 */
public class RouteRequestUtility {

    /*
     * If the incoming request is POST or PUT, it is expected to have a payload
     * of JSON which is returned. In case of GET request, any query parameters
     * will be used to create a JSON body. Note that only query string is used
     * and not path matchers. In case of no query parameters send out empty Json
     * object, but don't send null
     */
    public JsonObject getBodyForMessage(RoutingContext routingContext) {
        JsonObject httpBody, result = new JsonObject();
        if (routingContext.request().method().name().equals(HttpMethod.POST.name())
            || routingContext.request().method().name().equals(HttpMethod.PUT.name())) {
            httpBody = routingContext.getBodyAsJson();
            for (Entry<String, String> entry : routingContext.request().params()) {
              httpBody.put(entry.getKey(), entry.getValue());
            }
        } else if (routingContext.request().method().name().equals(HttpMethod.GET.name())) {
          httpBody = new JsonObject();
          for (Entry<String, String> entry : routingContext.request().params()) {
            httpBody.put(entry.getKey(), entry.getValue());
          }
        } else {
            httpBody = new JsonObject();
        }
        result.put(MessageConstants.MSG_HTTP_BODY, httpBody);
        String authorization = routingContext.request().getHeader(HttpConstants.HEADER_AUTH);
        String sessionToken = authorization != null ? authorization.substring(HttpConstants.TOKEN.length()).trim() : null;
        if (StringUtil.isNullOrEmpty(sessionToken)) {
          sessionToken = routingContext.request().getHeader(HttpConstants.GOORU_SESSION_TOKEN);
          if (StringUtil.isNullOrEmpty(sessionToken)) {
            sessionToken = routingContext.request().getParam(HttpConstants.HEADER_SESSION_TOKEN);
          }
        }
        result.put(MessageConstants.MSG_HEADER_TOKEN, sessionToken);
        return result;
    }
}