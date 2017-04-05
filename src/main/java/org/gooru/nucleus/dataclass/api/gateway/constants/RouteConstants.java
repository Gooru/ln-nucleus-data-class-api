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

    // Helper: Operations
    private static final String OP_ORDER = "order";
    private static final String OP_LOOKUP = "lookups";
    private static final String OP_MEMBER = "members";
    private static final String OP_INVITE = "invites";
    private static final String OP_AUTH = "authorization";
    private static final String OP_DEMOGRAPHICS = "demographics";
    private static final String OP_FOLLOW = "follow";
    private static final String OP_UNFOLLOW = "unfollow";
    private static final String OP_SUBJECT_BUCKET = "subject-buckets";
    private static final String OP_TAXONOMY = "taxonomy";
    private static final String OP_NETWORK = "network";

    // Misc helpers
    private static final String RES_EDUCATIONAL_USE = "educational-use";
    private static final String RES_DOK = "dok";
    private static final String RES_ACCESS_HAZARDS = "access-hazards";
    private static final String RES_READING_LEVELS = "reading-levels";
    private static final String RES_ADS = "ads";
    private static final String RES_MEDIA_FEATURES = "media-features";
    private static final String RES_CEN21SKILLS = "21-century-skills";
    private static final String RES_GRADES = "grades";
    private static final String RES_MOMENTS = "moments";
    private static final String RES_AUDIENCE = "audience";
    private static final String RES_COUNTRIES = "countries";
    private static final String RES_STATES = "states";
    private static final String RES_SCHOOLDISTRICTS = "school-districts";
    private static final String RES_SCHOOLS = "schools";
    private static final String RES_TX_STANDARD_FRAMEWORK = "frameworks";
    private static final String RES_LICENSE = "licenses";
    private static final String RES_APIKEY_CONFIG = "apikey-config";
    private static final String RES_STATS = "stats";
    private static final String SEP = "/";
    private static final String COLON = ":";    
    
    // Updated API Version
    private static final String API_VERSION = "v2";
    private static final String API_BASE_ROUTE = "/api/nucleus-insights/" + API_VERSION + '/';
    private static final String API_BASE_ROUTE_FOR_SESSION = "/api/nucleus-insights/rest/" + API_VERSION + '/';
    
    // Helper: Entity name constants
    private static final String ENTITY_RESOURCES = "resources";
    private static final String ENTITY_QUESTIONS = "questions";
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
    
    
    private static final String ENTITY_COLLABORATORS = "collaborators";
    private static final String ENTITY_TAXONOMY = "taxonomy";
    private static final String ENTITY_TX_SUBJECT = "subjects";
    private static final String ENTITY_TX_COURSE = "courses";
    private static final String ENTITY_TX_DOMAIN = "domains";
    private static final String ENTITY_TX_CODES = "codes";
    private static final String ENTITY_COPIER = "copier";
    private static final String ENTITY_PROFILES = "profiles";

    // Class Reports - Write/Read APIs
    private static final String LOCATION = "location";
    private static final String CURRENT = "current";
    private static final String PERFORMANCE = "performance";
    private static final String PEERS = "peers";
    private static final String ENTITY_USER = "user";
    private static final String SESSIONS = "sessions";
    private static final String SESSION = "session";
    private static final String CLASSES = "classes";
    private static final String STATUS = "status";
    private static final String GRADE = "grade";
    private static final String USAGE = "usage";
    private static final String TAXONOMY = "taxonomy";
    private static final String STUDY = "study";
    private static final String ACTIVITY = "activity";
    private static final String LEARNER = "learner";
    
    public static final String CLASS_ID = "classId";
    public static final String COURSE_ID = "courseId";
    public static final String USER_ID = "userId";
    public static final String IS_TEACHER = "isTeacher";
    public static final String IS_STUDENT = "isStudent";
    public static final String USER_ROLE = "userRole";
    
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
    
    //Get Students Performance In Lesson (getLessonPerformance)
    //{REST_END_POINT}/api/nucleus-insights/v2/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGoouId}/assessment/{assessmentGooruId}/performance
    public static final String ASSESSMENT_STUDENTS_PERF_GET = API_BASE_ROUTE + ENTITY_CLASS + SEP + COLON + ID_CLASS + SEP +
    		ENTITY_COURSE + SEP + COLON + ID_COURSE + SEP + 
    		ENTITY_UNIT + SEP + COLON + ID_UNIT + SEP + 
    		ENTITY_LESSON + SEP + COLON + ID_LESSON + SEP + ENTITY_ASSESSMENT + SEP + COLON + ID_COLLECTION+ SEP + PERFORMANCE;
    
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
    
    //Get Student Performance for multiple Assessment (@Student/Teacher Dashboard, @DCA)    
    public static final String STUDENT_PERF_DAILY_CLASS_ACTIVITY = API_BASE_ROUTE +
            ENTITY_CLASS + SEP + COLON + CLASS_ID + SEP + ACTIVITY;
    
    
  //Get Student Performance for multiple Assessment (@Student/Teacher Dashboard, @DCA)    
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
      
      
      //Get Independent Learner's Performance for all Collections in a Course (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/course/collections/performance
      public static final String LEARNER_PERF_COURSE_COLLECTIONS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COURSE + SEP + ENTITY_COLLECTIONS + SEP + PERFORMANCE;
      
    //Get Independent Learner's Performance for all Collections in a Course (ClassId = null)
      //{REST_END_POINT}/api/nucleus-insights/v2/learner/course/assessments/performance
      public static final String LEARNER_PERF_COURSE_ASSESSMENTS_GET = API_BASE_ROUTE + LEARNER + SEP + ENTITY_COURSE + SEP + ENTITY_ASSESSMENTS + SEP + PERFORMANCE;
      
      //********************************************************************************************************************************

       
    public static final String EP_INTERNAL_BANNER = "/api/internal/v1/banner";
    public static final String EP_INTERNAL_METRICS = "/api/internal/v1/metrics";
    // This is event publisher. It expects full blown event structure which will be relayed to Kafka
    public static final String EP_INTERNAL_EVENT = "/api/internal/v1/events";
    // This is event processor. It provides a JSON Object as request which has two parts.
    // One mandatory part is <event> this is processed as other events from the message bus
    // Second optional part is <context> which can provide additional information like email should be sent or not
    // Note that difference between original message on message bus and this is the presence of op name
    public static final String EP_INTERNAL_EVENT_PROCESSOR = "/api/internal/v1/eventprocessor";

    private RouteConstants() {
        throw new AssertionError();
    }

}
