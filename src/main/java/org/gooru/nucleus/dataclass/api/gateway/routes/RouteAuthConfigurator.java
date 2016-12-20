package org.gooru.nucleus.dataclass.api.gateway.routes;

import org.gooru.nucleus.dataclass.api.gateway.constants.ConfigConstants;
import org.gooru.nucleus.dataclass.api.gateway.constants.HttpConstants;
import org.gooru.nucleus.dataclass.api.gateway.constants.MessageConstants;
import org.gooru.nucleus.dataclass.api.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.dataclass.api.gateway.constants.RouteConstants;
import org.gooru.nucleus.dataclass.api.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.reports.api.gateway.responses.auth.AuthPrefsResponseHolderBuilder;
import org.gooru.nucleus.reports.api.gateway.responses.auth.AuthResponseHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.util.StringUtil;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class RouteAuthConfigurator implements RouteConfigurator {

private static final Logger LOG = LoggerFactory.getLogger(RouteAuthConfigurator.class);

@Override
public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    EventBus eBus = vertx.eventBus();
    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);
    router.route(RouteConstants.API_AUTH_ROUTE).handler(routingContext -> {
      String sessionToken = routingContext.request().getHeader(HttpConstants.GOORU_SESSION_TOKEN);
      if (StringUtil.isNullOrEmpty(sessionToken)) {
        sessionToken = routingContext.request().getParam(HttpConstants.HEADER_SESSION_TOKEN);
      }
      LOG.debug("sessionToken : " + sessionToken);
      // If the session token is null or absent, we send an error to
      // client
      if (StringUtil.isNullOrEmpty(sessionToken)) {
        routingContext.response().setStatusCode(HttpConstants.HttpStatus.UNAUTHORIZED.getCode())
                .setStatusMessage(HttpConstants.HttpStatus.UNAUTHORIZED.getMessage()).end();
      } else {
        // If the session token is present, we send it to Message Bus
        // for validation
        DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_TOKEN, sessionToken);
        eBus.send(MessagebusEndpoints.MBEP_AUTH, new RouteRequestUtility().getBodyForMessage(routingContext) , options, reply -> {
          if (reply.succeeded()) {
            AuthResponseHolder responseHolder = new AuthPrefsResponseHolderBuilder(reply.result()).build();
            // Message header would indicate whether the auth
            // was successful or not. In addition, successful
            // auth may have been
            // for anonymous user. We allow only GET request for
            // anonymous user (since we do not support head,
            // trace, options etc so far)
            LOG.debug("isAuthorized : {} ", responseHolder.isAuthorized());
            LOG.debug("isAnonymous : {} ", responseHolder.isAnonymous());
            if (responseHolder.isAnonymous()) {
              routingContext.response().setStatusCode(HttpConstants.HttpStatus.FORBIDDEN.getCode())
                      .setStatusMessage(HttpConstants.HttpStatus.FORBIDDEN.getMessage()).end();
            } else if (responseHolder.isAuthorized()) {
              LOG.debug("User authenticated, Fowarding request to next route.. ");
             // routingContext.request().params().add(RouteConstants.USER_ID, responseHolder.getUserId());
              routingContext.next();
            } else {
              routingContext.response().setStatusCode(HttpConstants.HttpStatus.UNAUTHORIZED.getCode())
                      .setStatusMessage(HttpConstants.HttpStatus.UNAUTHORIZED.getMessage()).end();
            }
          } else {
            LOG.error("Not able to send message", reply.cause());
            routingContext.response().setStatusCode(HttpConstants.HttpStatus.ERROR.getCode()).end();
          }
        });
      }
    });
  }
}
