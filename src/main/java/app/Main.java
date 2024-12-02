package app;
import data_access.DBExperimentDataAccessObject;
import data_access.DBUserDataAccessObject;
import entity.*;
import org.json.JSONArray;
import org.json.JSONException;
import okhttp3.*;
import org.json.JSONObject;

import javax.swing.*;

public static void main(String[] args) {
    final AppBuilder appBuilder = new AppBuilder();
    // TODO: add the Logout Use Case to the app using the appBuilder
    final JFrame application = appBuilder
            .addLoginView()
            .addSignupView()
            .addLoggedInView()
            .addSignupUseCase()
            .addLoginUseCase()
            .addLogoutUseCase()
            .add
            .build();

    application.pack();
    application.setVisible(true);
}