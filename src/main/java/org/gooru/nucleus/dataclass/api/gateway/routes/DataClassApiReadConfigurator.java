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

/**
 * Created by mukul@gooru
 */

class DataClassApiReadConfigurator implements RouteConfigurator {
	
    private static final Logger LOG = LoggerFactory.getLogger("org.gooru.nucleus.dataclass.api.gateway.bootstrap.DataClassApiVerticle");

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        
    	final EventBus eb = vertx.eventBus();
        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;        
        
        //Student Peers In Course        
        router.get(RouteConstants.COURSE_PEERS_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_PEERS)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });

        //Student Peers In Unit        
        router.get(RouteConstants.UNIT_PEERS_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_PEERS)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Student Peers In Lesson        
        router.get(RouteConstants.LESSON_PEERS_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LESSON_PEERS)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId).addHeader(RouteConstants.ID_LESSON, lessonId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });


        //Student Current Location        
        router.get(RouteConstants.CURRENT_LOC_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String userId = routingContext.request().getParam(RouteConstants.UID_USER);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_CURRENT_LOC)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.UID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Course Perf        
        router.get(RouteConstants.COURSE_STUDENT_PERF_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_COURSE_PERF)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Unit Perf
        router.get(RouteConstants.UNIT_STUDENT_PERF_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_UNIT_PERF)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Lesson Perf
        router.get(RouteConstants.LESSON_STUDENT_PERF_GET).handler(routingContext -> {            
        	String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_LESSON_PERF)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId).addHeader(RouteConstants.ID_LESSON, lessonId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Assessment Perf
        router.get(RouteConstants.ASSESSMENT_STUDENTS_PERF_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_ASSESSMENT_PERF)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId).addHeader(RouteConstants.ID_LESSON, lessonId)
                .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Collection End Page Summary
        router.get(RouteConstants.COLLECTION_STUDENT_SUMMARY_GET).handler(routingContext -> {            
        	String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
            String userId = routingContext.request().getParam(RouteConstants.UID_USER);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_COLLECTION_SUMMARY)
                .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.UID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        
        //Assessment End Page Summary
        router.get(RouteConstants.ASSESSMENT_STUDENT_SUMMARY_GET).handler(routingContext -> {            
        	String collectionId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);            
            String userId = routingContext.request().getParam(RouteConstants.UID_USER);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_ASSESSMENT_SUMMARY)
                .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.UID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Get Session Status        
        router.get(RouteConstants.SESSION_STATUS_GET).handler(routingContext -> {            
            String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
            String sessionId = routingContext.request().getParam(RouteConstants.ID_SESSION);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_SESSION_STATUS)
                .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.ID_SESSION, sessionId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });

        //Get User Session for Assessment        
        router.get(RouteConstants.USER_ALL_SESSION_GET_FOR_ASSESSMENT).handler(routingContext -> {            
            String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_USER_ALL_ASSESSMENT_SESSIONS)
                .addHeader(RouteConstants.ID_COLLECTION, collectionId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Get User Session for Collection        
        router.get(RouteConstants.USER_ALL_SESSION_GET_FOR_COLLECTION).handler(routingContext -> {            
            String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_USER_ALL_COLLECTION_SESSIONS)
                .addHeader(RouteConstants.ID_COLLECTION, collectionId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Get Session Taxonomy Report        
        router.get(RouteConstants.SESSION_TAXONOMY_REPORT_GET).handler(routingContext -> {            
            String sessionId = routingContext.request().getParam(RouteConstants.ID_SESSION);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_SESSION_TAXONOMY_REPORT)
                .addHeader(RouteConstants.ID_SESSION, sessionId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
    }
    
}
