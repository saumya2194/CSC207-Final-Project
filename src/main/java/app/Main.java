package app;
import data_access.DBExperimentDataAccessObject;
import data_access.DBUserDataAccessObject;
import entity.*;
import org.json.JSONArray;
import org.json.JSONException;
import okhttp3.*;
import org.json.JSONObject;


public class Main {
    public static void main(String[] args) {

        CommonUserFactory userFactory = new CommonUserFactory();
        StudyFactory studyFactory = new CommonStudyFactory();
        User myuser = userFactory.create("Jack", "1234");
        DBUserDataAccessObject tempuser = new DBUserDataAccessObject(userFactory);
        DBExperimentDataAccessObject tempStudy = new DBExperimentDataAccessObject(studyFactory, userFactory);

        // below commented lines are for testing user DAO
//        System.out.println(myuser.getName());
//        System.out.println(myuser.getPassword());
//        User idk = temp.get("user");
//        System.out.println(idk);
//        System.out.println(temp.get("Chillguy").getPassword());
//        temp.setCurrentUsername("Chillguy");


//        CommonStudy newStudy  = new CommonStudy(myuser, "Research Study Title", "rTMS brain stimulation study looking " +
//                "for university students");
         System.out.println(tempStudy.getStudies());
         System.out.println(tempStudy.getStudyObjects());
         System.out.println(tempStudy.retrieveUserStudies("Chillguy"));


        // below commented lines are for testing experiment DAO
        // CommonStudy myStudy = new CommonStudy(myuser, "Looking for participants", "Test details"); // Initialize the study object
//        System.out.println(tempStudy.saveResearchStudy(myStudy)); // POST method for adding research study onto database.

//        System.out.println(tempStudy.getStudies());
//        tempStudy.saveResearchStudy(myStudy);

//        System.out.println(tempStudy.retrieveUserStudies("Chillguy"));
//        System.out.println(tempStudy.retrieveUserStudies("user"));
//        System.out.println(tempStudy.retrieveUserStudies("javkhlan"));
//        tempStudy.deleteResearchStudy("1844332318");
//        System.out.println(tempStudy.getStudies());
        // System.out.println(tempStudy.editResearchStudy(myStudy));

    }
}
