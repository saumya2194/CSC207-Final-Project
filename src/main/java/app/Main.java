package app;
import data_access.DBExperimentDataAccessObject;
import data_access.DBUserDataAccessObject;
import entity.*;
import org.json.JSONArray;
import org.json.JSONException;
import okhttp3.*;
import org.json.JSONObject;

import javax.swing.*;
import java.util.List;

public class Main {
    //    public static void main(String[] args) {
//        // Initialize necessary factories
//        StudyFactory studyFactory = new CommonStudyFactory();
//        UserFactory userFactory = new CommonUserFactory();
//
//        // Create an instance of the DBExperimentDataAccessObject
//        DBExperimentDataAccessObject dbAccess = new DBExperimentDataAccessObject(studyFactory, userFactory);
//
//        try {
//            // Fetch the list of studies (experiments)
//            List<CommonStudy> experiments = dbAccess.getStudyObjects();
//
//            // Print the list of experiments
//            System.out.println("List of Experiments:");
//            for (CommonStudy experiment : experiments) {
//                System.out.println("Title: " + experiment.getTitle());
//                System.out.println("User: " + experiment.getUser());
//                System.out.println("Details: " + experiment.getDetails());
//                System.out.println("ID: " + experiment.getId());
//                System.out.println("====================================");
//            }
//        } catch (RuntimeException e) {
//            // Handle errors
//            System.err.println("Error occurred: " + e.getMessage());
//        }
//    }
    public static void main(String[] args) {
        AppBuilder temp = new AppBuilder();
        final JFrame application = temp.addSignupView()
                .addHomepageView()
                .addLoginView()
                .addSignupUseCase()
                .addLoginUseCase()
                .addCreateStudyView()
                .addCreateStudyUseCase()
                .addProfileView()
                .addHomepageUseCase()
                .addLoggedInView()
                .addEditProfileUseCase()
                .build();
        application.pack();
        application.setVisible(true);

    }
}