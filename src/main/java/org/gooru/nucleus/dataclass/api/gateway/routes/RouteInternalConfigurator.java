
package org.gooru.nucleus.dataclass.api.gateway.routes;

import org.gooru.nucleus.dataclass.api.gateway.constants.ConfigConstants;
import org.gooru.nucleus.dataclass.api.gateway.constants.MessageConstants;
import org.gooru.nucleus.dataclass.api.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.dataclass.api.gateway.constants.RouteConstants;
import org.gooru.nucleus.dataclass.api.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.dataclass.api.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * @author szgooru Created On 04-Apr-2019
 */
public class RouteInternalConfigurator implements RouteConfigurator {
  private final static Logger LOGGER = LoggerFactory.getLogger(RouteInternalConfigurator.class);

  private EventBus eb;
  private long mbusTimeout = 30000L;

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    eb = vertx.eventBus();
    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;

    router.post(RouteConstants.INTERNAL_ALL_CLASSES_PERFORMANCE)
        .handler(this::fetchClassPerformance);
    router.post(RouteConstants.INTERNAL_DCA_CLASS_PERFORMANCE)
        .handler(this::fetchClassDCAPerformance);
  }

  private void fetchClassPerformance(RoutingContext routingContext) {
    DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(
        MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INTERNAL_ALL_STUDENT_CLASSES_PERF);
    eb.send(MessagebusEndpoints.MBEP_DATACLASS_API,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void fetchClassDCAPerformance(RoutingContext routingContext) {
    DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(
        MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INTERNAL_DCA_ALL_CLASSES_PERF);
    eb.send(MessagebusEndpoints.MBEP_DATACLASS_API,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }
}
