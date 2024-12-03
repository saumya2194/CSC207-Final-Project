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
//            // Fetch all studies
//            List<CommonStudy> studies = dbAccess.getStudyObjects();
//            dbAccess.deleteResearchStudy(String.valueOf(722333215));
//            // Print all studies
//            System.out.println("All Research Studies:");
//            for (CommonStudy study : studies) {
//                System.out.println("Title: " + study.getTitle());
//                System.out.println("User: " + study.getUser());
//                System.out.println("Details: " + study.getDetails());
//                System.out.println("ID: " + study.getId());
//                System.out.println("====================================");
//            }
//        } catch (RuntimeException e) {
//            System.err.println("Error occurred: " + e.getMessage());
//        }
//    }
//
    public static void main(String[] args) {
        AppBuilder temp = new AppBuilder();
        final JFrame application = temp.addSignupView()
                .addHomepageView()
                .addLoginView()
                .addSignupUseCase()
                .addLoginUseCase()
                .addProfileView()
                .addCreateStudyView()
                .addCreateStudyUseCase()
                .addHomepageUseCase()
                .addLoggedInView()
                .addEditProfileUseCase()
                .build();
        application.pack();
        application.setVisible(true);

    }
}