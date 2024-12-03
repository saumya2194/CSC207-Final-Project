package entity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.UUID;

/**
 Class representation of the Common Study.
 Common Study is created by the User. Unique study ID is created along
 with the Study object upon its initialization.
 */

public class CommonStudy implements Study {
    private static final int SUCCESS_CODE = 200;
    private final String id;
    private final String user;
    private static final String STATUS_CODE_LABEL = "status_code";
    private final String title;
    private final String details;


    // Changed the code so CommonStudy.user type will always be CommonUser object rather than String

    public CommonStudy(String user, String title, String details) {
        // UUID and hashcode will ensure that
        this.id = this.getRandomNumber();
        this.user = user;
        this.title = title;
        this.details = details;
    }

    // Overload the method if id of the study is already known.
    public CommonStudy(String user, String title, String details, String id) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.details = details;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }
    public String getDetails() {
        return this.details;
    }

    private String getRandomNumber() {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder()
                .url(String.format("http://www.randomnumberapi.com/api/v1.0/random?min=1&max=100000000000000&count=1", "NullPointers"))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONArray responseBody = new JSONArray(response.body().string());

            return ((Long) responseBody.get(0)).toString();
        } catch (IOException | JSONException ex) {
            return "backup";
        }
    }
}


