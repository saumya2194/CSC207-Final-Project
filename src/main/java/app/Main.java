package app;
import data_access.DBExperimentDataAccessObject;
import data_access.DBUserDataAccessObject;
import entity.*;
import org.json.JSONArray;
import org.json.JSONException;
import okhttp3.*;
import org.json.JSONObject;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        AppBuilder temp = new AppBuilder();
        final JFrame application = temp.addSignupView()
                .addHomepageView()
                .addLoginView()
                .addSignupUseCase()
                .addLoginUseCase()
                .build();
        application.pack();
        application.setVisible(true);

    }
//    public static void main(String[] args) {
//        final AppBuilder appBuilder = new AppBuilder();
//
//        final JFrame application = appBuilder
//                .addLoginView()
//                .addSignupView()
//                .addSignupUseCase()
//                .addLoginUseCase()
//                .build();
//
//        application.pack();
//        application.setVisible(true);
//    }

}
