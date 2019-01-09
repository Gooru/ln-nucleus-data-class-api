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
 * Modified by daniel
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
                .addHeader(RouteConstants.ID_COLLECTION, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });

        //Collection Perf
        router.get(RouteConstants.COLLECTION_STUDENTS_PERF_GET).handler(routingContext -> {            
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
            String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_COLLECTION_PERF)
                .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId).addHeader(RouteConstants.ID_LESSON, lessonId)
                .addHeader(RouteConstants.ID_COLLECTION, collectionId);
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
     
      //Get All Classes Performance       
        router.post(RouteConstants.ALL_CLASSES_PERFORMANCE).handler(routingContext -> {            
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ALL_STUDENT_CLASSES_PERF);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
      //Get Location for All Classes        
        router.post(RouteConstants.STUDENT_LOCATION_ALL_CLASSES).handler(routingContext -> {            
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_LOC_ALL_CLASSES);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        
      /*//Get Student Performance for multiple Collection (@Student/Teacher Dashboard, @DCA)        
        router.post(RouteConstants.STUDENT_PERF_MULTIPLE_COLLECTIONS).handler(routingContext -> {            
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_PERF_MULT_COLLECTION);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });*/
        
        //Student Performance in All Assessments in CUL        
        router.get(RouteConstants.STUDENT_PERF_COURSE_ASSESSMENTS).handler(routingContext -> {            
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_PERF_COURSE_ASSESSMENT);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });

        //Student Performance in All Assessments in CUL        
        router.get(RouteConstants.STUDENT_PERF_COURSE_COLLECTION).handler(routingContext -> {            
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_PERF_COURSE_COLLECTION);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });

      //Learner Course Perf        
        router.get(RouteConstants.COURSE_LEARNER_PERF_GET).handler(routingContext -> {            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INDEPENDENT_LEARNER_COURSE_PERF)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Learner Unit Perf
        router.get(RouteConstants.UNIT_LEARNER_PERF_GET).handler(routingContext -> {            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INDEPENDENT_LEARNER_UNIT_PERF)
                .addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Learner Lesson Perf
        router.get(RouteConstants.LESSON_LEARNER_PERF_GET).handler(routingContext -> {            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INDEPENDENT_LEARNER_LESSON_PERF)
                .addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId).addHeader(RouteConstants.ID_LESSON, lessonId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
        //Learner Assessment Perf
        router.get(RouteConstants.ASSESSMENT_LEARNER_PERF_GET).handler(routingContext -> {            
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INDEPENDENT_LEARNER_ASSESSMENT_PERF)
                .addHeader(RouteConstants.ID_COURSE, courseId)
                .addHeader(RouteConstants.ID_UNIT, unitId).addHeader(RouteConstants.ID_LESSON, lessonId)
                .addHeader(RouteConstants.ID_COLLECTION, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
      //Learner Assessment Perf
        router.get(RouteConstants.INDEPENDENT_ASSESSMENT_LEARNER_PERF_GET).handler(routingContext -> {            
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INDEPENDENT_LEARNER_INDEPENDENT_ASSESSMENT_PERF)
                .addHeader(RouteConstants.ID_COLLECTION, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
        
      //Independent learner courses
      router.get(RouteConstants.GET_INDEPENDENT_LEARNER_COURSES).handler(routingContext -> {
        DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                MessageConstants.MSG_OP_INDEPENDENT_LEARNER_COURSES);
        eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
    //Get Independent Learner's Location for all Courses (ClassId = null)
      router.get(RouteConstants.LEARNER_LOCATION_ALL_COURSES_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_LOCATION_ALL_COURSES);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
      //Get Independent Learner's Location for all Courses, Standalone Assessments, Standalone Collections (ClassId = null)
      router.get(RouteConstants.INDEPENDENT_LEARNER_LOCATION_ALL_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_ALL_LOCATION);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });      
      
      //Get Independent Learner's Location for all Courses, Standalone Assessments, Standalone Collections (ClassId = null)
      router.get(RouteConstants.INDEPENDENT_LEARNER_PERF_ALL_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_ALL_PERFORMANCE);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });      

      
    //Get Independent Learner's Location for all Assessments (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      router.get(RouteConstants.LEARNER_LOCATION_ALL_IND_ASSESSMENTS_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_LOCATION_ALL_IND_ASSESSMENTS);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
    //Get Independent Learner's Location for all Collections (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      router.get(RouteConstants.LEARNER_LOCATION_ALL_IND_COLLECTIONS_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_LOCATION_ALL_IND_COLLECTIONS);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
    //Get Independent Learner's Performance for all Courses (ClassId = null)
      router.get(RouteConstants.LEARNER_PERF_ALL_COURSES_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_PERF_ALL_COURSES);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
    //Get Independent Learner's Performance for Independent Assessments (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      router.get(RouteConstants.LEARNER_PERF_ALL_IND_ASSESSMENTS_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_PERF_ALL_IND_ASSESSMENTS);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
    //Get Independent Learner's Performance for all Courses (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      router.get(RouteConstants.LEARNER_PERF_ALL_IND_COLLECTIONS_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_PERF_ALL_IND_COLLECTIONS);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
      //Get Independent Learner's Performance in Course Collections (ClassId = null)
      router.get(RouteConstants.LEARNER_PERF_COURSE_COLLECTIONS_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_COURSE_ALL_COLLECTIONS_PERF);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
      //Get Independent Learner's Performance in Course Collections (ClassId = null)
      router.get(RouteConstants.LEARNER_PERF_COURSE_ASSESSMENTS_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_COURSE_ALL_ASSESSMENTS_PERF);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
      //GET LIST OF SUBJECTS STUDIED BY THE USER
      router.get(RouteConstants.LEARNER_TAXONOMY_SUBJECTS).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_IND_LEARNER_TAX_SUBJECTS);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
      //Get learner courses
      router.get(RouteConstants.LEARNER_COURSES_GET).handler(routingContext -> {
        DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                MessageConstants.MSG_OP_LEARNER_COURSES);
        eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //Independent Learner Current Location in Course Map        
      router.get(RouteConstants.INDEPENDENT_LEARNER_CURRENT_LOC_GET).handler(routingContext -> {            
          String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
          String userId = routingContext.request().getParam(RouteConstants.ID_USER);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_IND_LEARNER_CURRENT_LOC)
              .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_USER, userId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //Independent Learner Get All Courses Performance       
      router.post(RouteConstants.INDEPENDENT_LEARNER_PERF_ALL_COURSES).handler(routingContext -> {            
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_IND_LEARNER_ALL_COURSES_PERF);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //IL Collection End Page Summary
      router.get(RouteConstants.INDENDEPENDENT_LEARNER_COLLECTION_SUMMARY_GET).handler(routingContext -> {            
      	String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
          String userId = routingContext.request().getParam(RouteConstants.ID_USER);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_IND_LEARNER_COLLECTION_SUMMARY)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.ID_USER, userId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      
      //IL Assessment End Page Summary
      router.get(RouteConstants.INDENDEPENDENT_LEARNER_ASSESSMENT_SUMMARY_GET).handler(routingContext -> {            
      	String collectionId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);            
          String userId = routingContext.request().getParam(RouteConstants.ID_USER);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_IND_LEARNER_ASSESSMENT_SUMMARY)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.ID_USER, userId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });

      //Get IL Session for Assessment        
      router.get(RouteConstants.INDEPENDENT_LEARNER_ALL_SESSION_FOR_ASSESSMENT_GET).handler(routingContext -> {            
          String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_IND_LEARNER_ALL_ASSESSMENT_SESSIONS)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //Get IL Session for Collection        
      router.get(RouteConstants.INDEPENDENT_LEARNER_ALL_SESSION_FOR_COLLECTION_GET).handler(routingContext -> {            
          String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_IND_LEARNER_ALL_COLLECTION_SESSIONS)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //*************** DAILY CLASS ACTIVIY ********************************************************************************

      //Get Student Performance for Daily Class Activity(@Student/Teacher)        
    router.post(RouteConstants.STUDENT_PERF_DAILY_CLASS_ACTIVITY).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_PERF_DAILY_CLASS_ACTIVITY)
              .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
              reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
    });  
    
    //Get Student Performance for Daily (weekly, monthly) Class Activity(@Student/Teacher)        
  router.get(RouteConstants.STUDENT_PERF_DAILY_TIMELY_CLASS_ACTIVITY).handler(routingContext -> {
    String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
    DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENT_PERF_DAILY_TIMELY_CLASS_ACTIVITY)
            .addHeader(RouteConstants.ID_CLASS, classId);
    eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  });  
      //Get Session Taxonomy Report        
      router.get(RouteConstants.DCA_SESSION_TAXONOMY_REPORT_GET).handler(routingContext -> {            
          String sessionId = routingContext.request().getParam(RouteConstants.ID_SESSION);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_SESSION_TAXONOMY_REPORT)
              .addHeader(RouteConstants.ID_SESSION, sessionId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //Collection End Page Summary
      router.get(RouteConstants.DCA_COLLECTION_STUDENT_SUMMARY_GET).handler(routingContext -> {            
      	String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
          String userId = routingContext.request().getParam(RouteConstants.ID_USER);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_STUDENT_COLLECTION_SUMMARY)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.UID_USER, userId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });      
      
      //Assessment End Page Summary
      router.get(RouteConstants.DCA_ASSESSMENT_STUDENT_SUMMARY_GET).handler(routingContext -> {            
      	String collectionId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);            
          String userId = routingContext.request().getParam(RouteConstants.ID_USER);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_STUDENT_ASSESSMENT_SUMMARY)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.UID_USER, userId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //DCA Assessment Performance (Teacher)
      router.get(RouteConstants.DCA_ASSESSMENT_STUDENTS_PERF_GET).handler(routingContext -> {            
          String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          String assessmentId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_STUDENT_ASSESSMENT_PERF)
              .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COLLECTION, assessmentId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });

      //DCA Collection Performance (Teacher)
      router.get(RouteConstants.DCA_COLLECTION_STUDENTS_PERF_GET).handler(routingContext -> {            
          String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_STUDENT_COLLECTION_PERF)
              .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COLLECTION, collectionId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //DCA Get User Session for Assessment        
      router.get(RouteConstants.DCA_USER_ALL_SESSIONS_GET_FOR_ASSESSMENT).handler(routingContext -> {            
          String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);            
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_STUDENT_ASSESSMENT_ALL_SESSIONS)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //DCA: Teacher View: Get Class Performance       
      router.get(RouteConstants.DCA_CLASS_PERFORMANCE).handler(routingContext -> {            
    	  String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_CLASS_PERF)
              .addHeader(RouteConstants.ID_CLASS, classId);;
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });

      router.get(RouteConstants.DCA_CLASS_SUMMARY_MONTHLY).handler(routingContext -> {
          String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                  .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_CLASS_SUMMARY_MONTHLY)
                  .addHeader(RouteConstants.ID_CLASS, classId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });

      router.get(RouteConstants.DCA_CLASS_SUMMARY_FOR_MONTH).handler(routingContext -> {
          String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                  .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_CLASS_SUMMARY_FOR_MONTH)
                  .addHeader(RouteConstants.ID_CLASS, classId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });

      router.get(RouteConstants.DCA_CLASS_USER_SUMMARY_FOR_MONTH).handler(routingContext -> {
          String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
          String collectionType = routingContext.request().getParam(RouteConstants.COLLECTION_TYPE);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                  .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_DCA_CLASS_USER_SUMMARY_FOR_MONTH)
                  .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COLLECTION, collectionId)
                  .addHeader(RouteConstants.COLLECTION_TYPE, collectionType);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });

      //*************** RUBRICS GRADING********************************************************************************
      
      //Get Questions pending grading
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/questions
      router.get(RouteConstants.RUBRICS_QUESTIONS_TO_GRADE_GET).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_RUBRICS_QUESTIONS_TO_GRADE);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext), options,
                  reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
      
      //Get list of Students for a Question to be graded
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/questions/{question_id}/students        
      router.get(RouteConstants.RUBRIC_QUESTION_TO_GRADE_LIST_STUDENTS_GET).handler(routingContext -> {            
          String question_id = routingContext.request().getParam(RouteConstants.QUE_ID);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RUBRIC_QUESTIONS_STUDENTS_LIST)
              .addHeader(RouteConstants.QUE_ID, question_id);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });

      //Get Answer for Rubric Grading
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/questions/{question_id}/students/{student_id}/answers
      router.get(RouteConstants.RUBRIC_QUESTION_STUDENT_ANSWERS_GET).handler(routingContext -> {            
          String question_id = routingContext.request().getParam(RouteConstants.QUE_ID);
          String student_id = routingContext.request().getParam(RouteConstants.STUDENT_ID);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RUBRIC_QUESTIONS_STUDENT_ANSWERS)
              .addHeader(RouteConstants.QUE_ID, question_id).addHeader(RouteConstants.STUDENT_ID, student_id);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //Get Rubric Grading Summary for Question
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/class/{classId}/course/{courseId}/collection/
      //{collectionId}/question/{question_id}/summary
      router.get(RouteConstants.RUBRIC_QUESTION_GRADE_SUMMARY_GET).handler(routingContext -> {  
          String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
          String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
          String question_id = routingContext.request().getParam(RouteConstants.QUE_ID);          
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RUBRIC_QUESTIONS_GRADE_SUMMARY)
              .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId).addHeader(RouteConstants.QUE_ID, question_id);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
    //***************************************************************************************************************************

      //Data Reports for NU
      //{REST_END_POINT}/api/nucleus-insights/v3/student/performance
      router.get(RouteConstants.DATA_REPORTS_FOR_STUDENT).handler(routingContext -> {            
        String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
        String userId = routingContext.request().getParam(RouteConstants.ID_USER);
        //DATE FORMAT "YYYY-MM-DD"
        String startDate = routingContext.request().getParam(RouteConstants.START_DATE);
        String endDate = routingContext.request().getParam(RouteConstants.END_DATE);
        DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NU_DATA_REPORT)
            .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_USER, userId)
            .addHeader(RouteConstants.START_DATE, startDate).addHeader(RouteConstants.END_DATE, endDate);
        eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
            options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
    }); 
      
   
      //Get NU Courses Competency Completion       
      //{REST_END_POINT}/api/nucleus-insights/v3/courses/competency-completion
      router.post(RouteConstants.NU_COURSES_COMPETENCY_COMPLETION).handler(routingContext -> {            
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NU_COURSES_COMPETENCY_COMPLETION);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      //********************************************************************************************************************************      
      //TEACHER VIEW: Air Traffic Control Dashboard (ATC): All Students Performance Vs Completion Graph       
      router.get(RouteConstants.STUDENTS_PERFORMANCE_VS_COMPLETION).handler(routingContext -> {            
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENTS_PERF_VS_COMPLETION);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });

      router.get(RouteConstants.STUDENTS_COURSE_ALL_ITEMS_PERF).handler(routingContext -> {  
          String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENTS_COURSE_ALL_ITEMS_PERF)
              .addHeader(RouteConstants.ID_CLASS, classId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
      router.get(RouteConstants.INDEPENDENT_LEARNER_COURSE_ALL_ITEMS_PERF).handler(routingContext -> {  
          String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_INDEPENDENT_LEARNER_COURSE_ALL_ITEMS_PERF)
              .addHeader(RouteConstants.ID_COURSE, courseId);
          eb.send(MessagebusEndpoints.MBEP_DATACLASS_API, new RouteRequestUtility().getBodyForMessage(routingContext),
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
      });
      
    }
    
}
