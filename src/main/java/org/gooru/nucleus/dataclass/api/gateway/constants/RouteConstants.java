package org.gooru.nucleus.dataclass.api.gateway.constants;

/**
 * Created by ashish on 4/12/15.
 * updated by mukul@gooru for Class Reports - Write/Read APIs
 * 
 */
public final class RouteConstants {

	public static final String API_AUTH_ROUTE = "/api/nucleus-insights/*";
    
    // Helper: Entity Id constants
    public static final String ID_RESOURCE = "resourceId";
    public static final String ID_QUESTION = "questionId";
    public static final String ID_ASSESSMENT = "assessmentId";
    public static final String ID_COLLECTION = "collectionId";
    public static final String ID_COURSE = "courseId";
    public static final String ID_UNIT = "unitId";
    public static final String ID_LESSON = "lessonId";
    public static final String ID_CLASS = "classId";
    public static final String ID_TX_SUBJECT = "subjectId";
    public static final String ID_TX_DOMAIN = "domainId";
    public static final String ID_TX_COURSE = "courseId";
    public static final String ID_TX_STANDARD_FRAMEWORK = "standardFrameworkId";
    public static final String ID_TX_CODE_ID_LIST = "idList";
    public static final String ID_COUNTRY = "countryId";
    public static final String ID_USER = "userId";
    public static final String UID_USER = "userUid";
    public static final String ID_EMAIL = "email";
    public static final String CODE_CLASS = "classCode";
    public static final String ID_SESSION = "sessionId";
    public static final String REPORT = "report";

    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";

    // Misc helpers
    private static final String SEP = "/";
    private static final String COLON = ":";    
    private static final String HYPHEN = "-";  
    
    // Helper: Entity name constants
    private static final String ENTITY_TX_SUBJECT = "subjects";
    private static final String ENTITY_RESOURCES = "resources";
    private static final String ENTITY_QUESTIONS = "questions";
    private static final String ENTITY_QUESTION = "question";
    private static final String ENTITY_ASSESSMENTS = "assessments";    
    private static final String ENTITY_ASSESSMENT = "assessment";    
    private static final String ENTITY_ASSESSMENTS_EX = "assessments-external";
    private static final String ENTITY_COLLECTIONS = "collections";    
    private static final String ENTITY_COLLECTION = "collection";
    private static final String ENTITY_CLASSES = "classes";
    private static final String ENTITY_COURSES = "courses";
    private static final String ENTITY_UNITS = "units";
    private static final String ENTITY_LESSONS = "lessons";
    private static final String ENTITY_CLASS = "class";
    private static final String ENTITY_COURSE = "course";
    private static final String ENTITY_UNIT = "unit";
    private static final String ENTITY_LESSON = "lesson";
    private static final String ENTITY_ITEMS = "items";

    // Class Reports - Write/Read APIs
    private static final String LOCATION = "location";
    private static final String CURRENT = "current";
    private static final String PERFORMANCE = "performance";
    private static final String PEERS = "peers";
    private static final String ENTITY_USER = "user";
    private static final String SESSIONS = "sessions";
    private static final String SESSION = "session";
    private static final String CLASSES = "classes";
    private static final String COURSES = "courses";
    private static final String STATUS = "status";
    private static final String GRADE = "grade";
    private static final String USAGE = "usage";
    private static final String TAXONOMY = "taxonomy";
    private static final String STUDY = "study";
    private static final String ACTIVITY = "activity";
    private static final String LEARNER = "learner";
    private static final String RUBRICS = "rubrics";
    private static final String SUMMARY = "summary";
    private static final String ACTIVITIES = "activities";
    private static final String LEARNERS = "learners";
    public static final String COLLECTION_TYPE = "collectionType";
    
    
//    public static final String CLASS_ID = "classId";
//    public static final String COURSE_ID = "courseId";
    public static final String USER_ID = "userId";
    public static final String IS_TEACHER = "isTeacher";
    public static final String IS_STUDENT = "isStudent";
    public static final String USER_ROLE = "userRole";
   
    // Updated API Version
    private static final String API_VERSION = "v2";
    private static final String API_BASE_ROUTE = "/api/nucleus-insights/" + API_VERSION + '/';
    private static final String API_BASE_ROUTE_FOR_SESSION = "/api/nucleus-insights/rest/" + API_VERSION + '/';
    private static final String DCA = "dca";

    private static final String API_VERSION_III = "v3";
    private static final String API_BASE_ROUTE_III = "/api/nucleus-insights/" + API_VERSION_III + '/';

    //Rubrics
//    private static final String RUBRIC_GRADING_API_VERSION = "v2";
//    private static final String RUBRIC_GRADING_API_BASE_ROUTE = "/api/rubric-grading/" + RUBRIC_GRADING_API_VERSION + SEP;
      
    public static final String QUE_ID = "question_id";
    public static final String STUDENT_ID = "student_id";
    
    private static final String ENTITY_STUDENTS = "students";
    private static final String ENTITY_ANSWERS = "answers";    
    private static final String ENTITY_STUDENT = "student";
    private static final String COMPLETION = "completion";
    private static final String COMPETENCY = "competency";
    
    private static final String ATC = "atc";
    private static final String PERF_VS_COMP = "pvc";

    //GetStudentPeersinCourse (getCoursePeers)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/peers
    public static final String COURSE_PEERS_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + PEERS;
    
    //GetStudentPeersinUnit (getUnitPeers)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/peers
    public static final String UNIT_PEERS_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + PEERS;
    
    //GetStudentPeersinLesson (getLessonPeers)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGooruId}/peers
    public static final String LESSON_PEERS_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
    		ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + PEERS;
    
    //GetCurrentLocation (getUserCurrentLocationInLesson)
    //{REST_END_POINT}//api/nucleus-insights/v2/class/{classGooruId}/user/{userUid}/current/location
    public static final String CURRENT_LOC_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_USER + SEP + COLON + UID_USER + SEP + 
    		CURRENT + SEP + LOCATION;   		   
    
    
    // Get Student Course Performance (getCoursePeformance)    
    // {REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/performance
    public static final String COURSE_STUDENT_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		PERFORMANCE;
    
    
    //Get Student Performance In Unit (getUnitPeformance)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/performance
    public static final String UNIT_STUDENT_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + PERFORMANCE;
    
    //Get Students Performance In Assessment (getAssessmentPerformance)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/
    //{lessonGoouId}/assessment/{assessmentGooruId}/performance
    public static final String ASSESSMENT_STUDENTS_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
    		ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION+ SEP + PERFORMANCE;
    
    //Get Students Performance In Lesson (getCollectionPerformance)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/
    //{lessonGoouId}/assessment/{collectionGooruId}/performance
    public static final String COLLECTION_STUDENTS_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
    		ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION+ SEP + PERFORMANCE;
    
  //Get Student Performance In Assessment (getAssessmentPerformance)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGoouId}/performance
    public static final String LESSON_STUDENT_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
        ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
        ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
        ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + PERFORMANCE;
    
    //Get Student Performance In Collection/Assessment (getCollectionPeformance)
    //{REST_END_POINT}/api/nucleus-insights/v2/{collectionType}/{contentGooruId}/user/{userUid}
    public static final String COLLECTION_STUDENT_SUMMARY_GET = API_BASE_ROUTE + ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION + SEP +
    		ENTITY_USER + SEP + COLON + UID_USER;
    
    public static final String ASSESSMENT_STUDENT_SUMMARY_GET = API_BASE_ROUTE + ENTITY_ASSESSMENT + SEP + COLON + ID_ASSESSMENT + SEP +
    		ENTITY_USER + SEP + COLON + UID_USER;
    
    //Get Session Status (getSessionStatus)
    //{REST_END_POINT}/insights/api/rest/v2/collection/{contentGooruId}/session/{sessionId}/status
    public static final String SESSION_STATUS_GET = API_BASE_ROUTE_FOR_SESSION + ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION + SEP +
    		SESSION + SEP + COLON + ID_SESSION + SEP + STATUS;

    //GET ALL USER SESSIONS
    //{REST_END_POINT}/insights/api/rest/v2/{collectionType}/{contentGooruId}/sessions    
    public static final String USER_ALL_SESSION_GET_FOR_ASSESSMENT = API_BASE_ROUTE + ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION + SEP +
    		SESSIONS;
    
    public static final String USER_ALL_SESSION_GET_FOR_COLLECTION = API_BASE_ROUTE + ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION + SEP +
    		SESSIONS;
    
    //Get All Students Performance In Collection/Assessment
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGooruId}/
    //{collectionType}/{contentGooruId}/performance    
    public static final String ALL_STUDENT_ASSESSMENT_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
    		ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + 
    		ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION + SEP + PERFORMANCE;
    
    public static final String ALL_STUDENT_COLLECTION_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
    		ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + 
    		ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION + SEP + PERFORMANCE;
    
    
    //Get Teacher Given Grade for Student
    //{REST_END_POINT}/api/nucleus-insights/v2/user/{userUid}/grade    
    public static final String STUDENT_GRADE_BY_TEACHER_GET = API_BASE_ROUTE + ENTITY_USER + SEP + COLON + UID_USER + SEP + GRADE;

    //Get Student Session wise taxonomy report (getSessionTaxonomyReport)
    //{REST_END_POINT}/api/nucleus-insights/v2/session/{sessionId}/taxonomy/usage
    public static final String SESSION_TAXONOMY_REPORT_GET = API_BASE_ROUTE +
        SESSION + SEP + COLON + ID_SESSION + SEP + TAXONOMY + SEP + USAGE;
    
    //Get Student Performance for All Classes
    //{REST_END_POINT}/api/nucleus-insights/v2/classes/performance
    public static final String ALL_CLASSES_PERFORMANCE = API_BASE_ROUTE +
            CLASSES + SEP + PERFORMANCE;
    
    //Get Student Current Location for All Classes
    public static final String STUDENT_LOCATION_ALL_CLASSES = API_BASE_ROUTE +
            CLASSES + SEP + LOCATION;
          
    //REMOVE    
    public static final String STUDENT_PERF_MULTIPLE_COLLECTIONS = API_BASE_ROUTE +
            ENTITY_COLLECTION + SEP + PERFORMANCE;
    
    public static final String STUDENT_PERF_COURSE_ASSESSMENTS = API_BASE_ROUTE +
    		STUDY + SEP + ENTITY_ASSESSMENT + SEP + PERFORMANCE;

    public static final String STUDENT_PERF_COURSE_COLLECTION = API_BASE_ROUTE +
            STUDY + SEP + ENTITY_COLLECTION + SEP + PERFORMANCE;

    // Get Learner Course Performance (getCoursePeformance)    
    // {REST_END_POINT}/api/nucleus-insights/v2/course/{courseGooruId}/learner/performance
    public static final String COURSE_LEARNER_PERF_GET = API_BASE_ROUTE +
        ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + LEARNER + SEP +
        PERFORMANCE;
    
    //Get Learner Performance In Unit (getUnitPeformance)
    //{REST_END_POINT}/api/nucleus-insights/v2/course/{courseGooruId}/unit/{unitGooruId}/learner/performance
    public static final String UNIT_LEARNER_PERF_GET = API_BASE_ROUTE +
        ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
        ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + LEARNER + SEP + PERFORMANCE;
    
    
    //Get Learner Performance In Assessment (getAssessmentPerformance)
      //{REST_END_POINT}/api/nucleus-insights/v2/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGoouId}/learner/performance
      public static final String LESSON_LEARNER_PERF_GET = API_BASE_ROUTE +
          ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
          ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
          ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + LEARNER + SEP + PERFORMANCE;
      
      //Get Learner Performance In Lesson (getLessonPerformance)
      //{REST_END_POINT}/api/nucleus-insights/v2/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGoouId}/assessment/{assessmentGooruId}/learner/performance
      public static final String ASSESSMENT_LEARNER_PERF_GET = API_BASE_ROUTE +
          ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
          ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
          ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION + SEP + LEARNER + SEP + PERFORMANCE;
      
      //Get Learner Performance In Lesson (getLessonPerformance)
      //{REST_END_POINT}/api/nucleus-insights/v2//assessment/{assessmentGooruId}/learner/performance
      public static final String INDEPENDENT_ASSESSMENT_LEARNER_PERF_GET = API_BASE_ROUTE + ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION + SEP + LEARNER + SEP + PERFORMANCE;
      
      //Get independent learner courses...
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/courses
      public static final String GET_INDEPENDENT_LEARNER_COURSES = API_BASE_ROUTE +  LEARNER + SEP + ENTITY_COURSES;
      
      //Get Independent Learner Performance In Collection/Assessment (getCollectionPeformance)
      //{REST_END_POINT}/api/nucleus-insights/v2/{collectionType}/{contentGooruId}/learner/{userId}
      public static final String INDENDEPENDENT_LEARNER_COLLECTION_SUMMARY_GET = API_BASE_ROUTE + ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION + SEP +
      		LEARNER + SEP + COLON + ID_USER;
      
      public static final String INDENDEPENDENT_LEARNER_ASSESSMENT_SUMMARY_GET = API_BASE_ROUTE + ENTITY_ASSESSMENT + SEP + COLON + ID_ASSESSMENT + SEP +
      		LEARNER + SEP + COLON + ID_USER;
      
      //GET ALL USER SESSIONS
      //{REST_END_POINT}/insights/api/v2/learner/{collectionType}/{contentGooruId}/sessions    
      public static final String INDEPENDENT_LEARNER_ALL_SESSION_FOR_ASSESSMENT_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION 
      		  + SEP + SESSIONS;
      
      public static final String INDEPENDENT_LEARNER_ALL_SESSION_FOR_COLLECTION_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION
    		  + SEP + SESSIONS;
            
      //*************************************************************************************************************************************************
      //Redundant - REMOVE
      //Get Independent Learner's Location for all Courses (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/courses/location
      public static final String LEARNER_LOCATION_ALL_COURSES_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COURSES + SEP + LOCATION;
      
      //Get Independent Learner's Location for all Assessments (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/assessments/location
      public static final String LEARNER_LOCATION_ALL_IND_ASSESSMENTS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_ASSESSMENTS + SEP + LOCATION;
      
      //Get Independent Learner's Location for all Collections (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/collections/location
      public static final String LEARNER_LOCATION_ALL_IND_COLLECTIONS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COLLECTIONS + SEP + LOCATION;
      
      //Get Independent Learner's Performance for all Courses (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/courses/performance
      public static final String LEARNER_PERF_ALL_COURSES_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COURSES + SEP + PERFORMANCE;
      
      //Get Independent Learner's Performance for all Assessments (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/assessments/performance
      public static final String LEARNER_PERF_ALL_IND_ASSESSMENTS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_ASSESSMENTS + SEP + PERFORMANCE;
      
      //Get Independent Learner's Performance for all Collections (ClassId = null, CourseId = null, UnitId = null, LessonId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/collections/performance
      public static final String LEARNER_PERF_ALL_IND_COLLECTIONS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COLLECTIONS + SEP + PERFORMANCE;
      
      //*********************************************************************************************************************************************
      
      //Get Independent Learner's Performance for all Collections in a Course (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/course/collections/performance
      public static final String LEARNER_PERF_COURSE_COLLECTIONS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COURSE + SEP + ENTITY_COLLECTIONS + SEP + PERFORMANCE;
      
    //Get Independent Learner's Performance for all Collections in a Course (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/course/assessments/performance
      public static final String LEARNER_PERF_COURSE_ASSESSMENTS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COURSE + SEP + ENTITY_ASSESSMENTS + SEP + PERFORMANCE;
      
      //GET LIST OF SUBJECTS STUDIED BY THE USER
      public static final String LEARNER_TAXONOMY_SUBJECTS = API_BASE_ROUTE + LEARNER + SEP + TAXONOMY + SEP + ENTITY_TX_SUBJECT;      

    //Get learner courses...
      //{REST_END_POINT}/api/nucleus-insights/v2/user/courses
      public static final String LEARNER_COURSES_GET = API_BASE_ROUTE +  ENTITY_USER + SEP + ENTITY_COURSES;
      
      //Get Independent Learner's Location for all Courses, Standalone Assessments, standalone Collections (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/location
      public static final String INDEPENDENT_LEARNER_LOCATION_ALL_GET = API_BASE_ROUTE + LEARNER + SEP + LOCATION;

      //Get Independent Learner's Performance for all Courses Standalone Assessments, standalone Collections (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/performance
      public static final String INDEPENDENT_LEARNER_PERF_ALL_GET = API_BASE_ROUTE + LEARNER + SEP + PERFORMANCE;
      
      //***********************************************************************************************

      //Get Independent Learner Performance for All Courses
      //{REST_END_POINT}/api/nucleus-insights/v2/courses/learner/performance
      public static final String INDEPENDENT_LEARNER_PERF_ALL_COURSES = API_BASE_ROUTE +
              ENTITY_COURSES + SEP + LEARNER + SEP + PERFORMANCE;
      
      //Get Independent Learner Current Location in Course
      //{REST_END_POINT}//api/nucleus-insights/v2/course/{courseId}/user/{userId}/learner/current/location
      public static final String INDEPENDENT_LEARNER_CURRENT_LOC_GET = API_BASE_ROUTE + ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP +
      		ENTITY_USER + SEP + COLON + ID_USER + SEP + LEARNER + SEP +
      		CURRENT + SEP + LOCATION;   		   

   
      
      //*************** DAILY CLASS ACTIVITY ********************************************************************************
      
      //Get Student Performance for multiple Assessment (@Student/Teacher Dashboard, @DCA)    
      public static final String STUDENT_PERF_DAILY_CLASS_ACTIVITY = API_BASE_ROUTE +
              ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP + ACTIVITY;
      
      //Get Student Performance for multiple Assessment (@Teacher Dashboard, @DCA)    
      //{REST_END_POINT}/api/nucleus-insights/v2/dca/class/{classId}/report
      //dimension could be weekly, monthly
      public static final String STUDENT_PERF_DAILY_TIMELY_CLASS_ACTIVITY = API_BASE_ROUTE +
              DCA + SEP + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP  + REPORT;
      
      //Get Student Session wise taxonomy report (getSessionTaxonomyReport)
      //{REST_END_POINT}/api/nucleus-insights/v2/dca/session/{sessionId}/taxonomy/usage
      public static final String DCA_SESSION_TAXONOMY_REPORT_GET = API_BASE_ROUTE + DCA + SEP +
          SESSION + SEP + COLON + ID_SESSION + SEP + TAXONOMY + SEP + USAGE;

      //Get Student Performance In Collection/Assessment (getCollectionPeformance)
      //{REST_END_POINT}/api/nucleus-insights/v2/dca/{collectionType}/{contentGooruId}/user/{userUid}
      public static final String DCA_COLLECTION_STUDENT_SUMMARY_GET = API_BASE_ROUTE + DCA + SEP + ENTITY_COLLECTION + SEP + 
    		  COLON + ID_COLLECTION + SEP + ENTITY_USER + SEP + COLON + ID_USER;
      
      public static final String DCA_ASSESSMENT_STUDENT_SUMMARY_GET = API_BASE_ROUTE + DCA + SEP + ENTITY_ASSESSMENT + SEP + COLON + ID_ASSESSMENT + SEP +
      		ENTITY_USER + SEP + COLON + ID_USER;

    	//Get Students Performance In an Assessment (Teacher View)
	    //{REST_END_POINT}/api/nucleus-insights/v2/dca/class/{classGooruId}/assessment/{assessmentGooruId}/performance
      public static final String DCA_ASSESSMENT_STUDENTS_PERF_GET = API_BASE_ROUTE + DCA + SEP + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
	    		ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION + SEP + PERFORMANCE;
      
      //Get Students Performance In an Assessment (Teacher View)
	  //{REST_END_POINT}/api/nucleus-insights/v2/dca/class/{classGooruId}/collection/{collectionGooruId}/performance
      public static final String DCA_COLLECTION_STUDENTS_PERF_GET = API_BASE_ROUTE + DCA + SEP + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
	    		ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION + SEP + PERFORMANCE;
    
      //GET ALL USER SESSIONS
      //{REST_END_POINT}/insights/api/rest/v2/{collectionType}/{contentGooruId}/sessions    
      public static final String DCA_USER_ALL_SESSIONS_GET_FOR_ASSESSMENT = API_BASE_ROUTE + DCA + SEP + ENTITY_ASSESSMENT + SEP + COLON + 
    		  ID_COLLECTION + SEP + SESSIONS;

      //Get Student Performance in a Class
      //{REST_END_POINT}/api/nucleus-insights/v2/dca/class/:classId/performance
      public static final String DCA_CLASS_PERFORMANCE = API_BASE_ROUTE + DCA + SEP +
              ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP + PERFORMANCE;
      
    //{REST_END_POINT}/api/nucleus-insights/v2/dca/class/:classId/summary
      public static final String DCA_CLASS_SUMMARY_MONTHLY = API_BASE_ROUTE +
          DCA + SEP + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP + SUMMARY;
      
      //{REST_END_POINT}/api/nucleus-insights/v2/dca/class/:classId/activities/summary
      public static final String DCA_CLASS_SUMMARY_FOR_MONTH = API_BASE_ROUTE +
          DCA + SEP + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP  + ACTIVITIES + SEP + SUMMARY;
      
      //{REST_END_POINT}/api/nucleus-insights/v2/dca/class/:classId/:collectionType/:collectionId/learners/summary
      public static final String DCA_CLASS_USER_SUMMARY_FOR_MONTH = API_BASE_ROUTE +
          DCA + SEP + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP + COLON + COLLECTION_TYPE + SEP +
          COLON + ID_COLLECTION + SEP + LEARNERS + SEP + SUMMARY;
      //*************** RUBRICS GRADING********************************************************************************
      
      //Get Questions pending grading
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/questions
      public static final String RUBRICS_QUESTIONS_TO_GRADE_GET = API_BASE_ROUTE + RUBRICS + SEP + ENTITY_QUESTIONS;
      
      //Get list of Students for a Question to be graded
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/questions/{question_id}/students
      public static final String RUBRIC_QUESTION_TO_GRADE_LIST_STUDENTS_GET = API_BASE_ROUTE + RUBRICS + SEP + 
    		  ENTITY_QUESTIONS + SEP + COLON + QUE_ID + SEP + ENTITY_STUDENTS;
      
      //Get Answer for Rubric Grading
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/questions/{question_id}/students/{student_id}/answers
      public static final String RUBRIC_QUESTION_STUDENT_ANSWERS_GET = API_BASE_ROUTE + RUBRICS + SEP + ENTITY_QUESTIONS
    		  + SEP + COLON + QUE_ID + SEP + ENTITY_STUDENTS + SEP + COLON + STUDENT_ID + SEP + ENTITY_ANSWERS;

      //Get Rubric Grading Summary for Question
      //{REST_END_POINT}/api/nucleus-insights/v2/rubrics/class/{classId}/course/{courseId}/collection/
      //{collectionId}/question/{question_id}/summary
      public static final String RUBRIC_QUESTION_GRADE_SUMMARY_GET = API_BASE_ROUTE + RUBRICS + SEP + ENTITY_CLASS + 
    		  SEP + COLON + ID_CLASS + SEP + ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		  ENTITY_COLLECTION + SEP + COLON + ID_COLLECTION + SEP + ENTITY_QUESTION +
    		  SEP + COLON + QUE_ID + SEP + SUMMARY;


      //*************** RUBRICS GRADING********************************************************************************

      //Data Reports for NU
      //{REST_END_POINT}/api/nucleus-insights/v3/student/performance
      public static final String DATA_REPORTS_FOR_STUDENT = API_BASE_ROUTE_III + ENTITY_STUDENT + SEP + PERFORMANCE;

      //Courses Competency Completion
      //{REST_END_POINT}/api/nucleus-insights/v3/courses/competency-completion
      public static final String NU_COURSES_COMPETENCY_COMPLETION = API_BASE_ROUTE_III + COURSES + SEP + COMPETENCY + HYPHEN + COMPLETION;

      //********************************************************************************************************************************      
      //TEACHER VIEW: Air Traffic Control Dashboard (ATC): All Students Performance Vs Completion Graph
      //{REST_END_POINT}/api/nucleus-insights/v2/atc/pvc
      public static final String STUDENTS_PERFORMANCE_VS_COMPLETION = API_BASE_ROUTE +
              ATC + SEP + PERF_VS_COMP;

      //{REST_END_POINT}/api/nucleus-insights/v2/class/{classId}/items/performance
      public static final String STUDENTS_COURSE_ALL_ITEMS_PERF = API_BASE_ROUTE +
           ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP + ENTITY_ITEMS + SEP + PERFORMANCE;
      
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/course/{courseId}/items/performance
      public static final String INDEPENDENT_LEARNER_COURSE_ALL_ITEMS_PERF = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + ENTITY_ITEMS + SEP + PERFORMANCE;

    private RouteConstants() {
        throw new AssertionError();
    }

}
