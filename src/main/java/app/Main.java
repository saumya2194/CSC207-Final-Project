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
                .addEditStudyView()
                .addEditStudyUseCase()
                .addEnterIDView()
//                .addEnterIDViewUseCase()
                .addViewExperimentView()
                .addViewExperimentUseCase()
                .addHomepageUseCase()
                .addLoggedInView()
                .addEditProfileUseCase()
                .build();
        application.pack();
        application.setVisible(true);
//        DBExperimentDataAccessObject lol = new DBExperimentDataAccessObject(new CommonStudyFactory(), new CommonUserFactory());
//        lol.deleteResearchStudy("722333215");

        // uncomment below if fakestudies is needed
//        fakeStudies();
    }
    // do not delete this. it will be needed in case database gets changed.
    private static void generatefakeStudies() {
        DBExperimentDataAccessObject db = new DBExperimentDataAccessObject(new CommonStudyFactory(), new CommonUserFactory());
        db.save(new CommonStudy("jack", "Jack needs people", "details"));
        db.save(new CommonStudy("james", "James needs people 2", "details"));
        db.save(new CommonStudy("jack", "Jack doesn't people", "details"));
        db.save(new CommonStudy("jack", "Jack doesn't people 2", "details"));
    }
}