package org.gooru.nucleus.dataclass.api.gateway.routes.utils;

import java.util.Map.Entry;

import org.gooru.nucleus.dataclass.api.gateway.constants.MessageConstants;

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
        } else if (routingContext.request().method().name().equals(HttpMethod.GET.name())) {
          httpBody = new JsonObject();
          for (Entry<String, String> entry : routingContext.request().params()) {
            httpBody.put(entry.getKey(), entry.getValue());
          }
        } else {
            httpBody = new JsonObject();
        }
        result.put(MessageConstants.MSG_HTTP_BODY, httpBody);
        result.put(MessageConstants.MSG_KEY_PREFS, (JsonObject) routingContext.get(MessageConstants.MSG_KEY_PREFS));
        result.put(MessageConstants.MSG_USER_ID, (String) routingContext.get(MessageConstants.MSG_USER_ID));
        result.put(MessageConstants.MSG_HEADER_TOKEN, (String) routingContext.get(MessageConstants.MSG_HEADER_TOKEN));
        return result;
    }
}