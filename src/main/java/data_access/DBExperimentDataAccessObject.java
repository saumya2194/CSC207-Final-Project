package data_access;

import entity.ResearchStudy;
import entity.User;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.view_experiment.ViewExperimentDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBExperimentDataAccessObject implements ViewExperimentDataAccessInterface {
    private static final int SUCCESS_CODE = 200;
    private static final int CREDENTIAL_ERROR = 401;
    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String STATUS_CODE_LABEL = "status_code";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";

    public boolean saveResearchStudy(ResearchStudy researchStudy) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        // POST METHOD
        final MediaType mediaType = MediaType.parse(CONTENT_TYPE_JSON);
        final JSONObject requestBody = new JSONObject();
        requestBody.put(USERNAME, "NullPointers");
        requestBody.put(PASSWORD, "NullPointers");
        final JSONObject extra = new JSONObject();
        JSONObject study = new JSONObject();
        study.put("user",researchStudy.getResearcherName());
        study.put("title", researchStudy.getTitle());
        study.put("details", researchStudy.getDetails());
        extra.put(researchStudy.getId(), study);
        requestBody.put("info", extra);
        final RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        final Request request = new Request.Builder()
                .url("http://vm003.teach.cs.toronto.edu:20112/modifyUserInfo")
                .method("PUT", body)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                return true;
            }
            else if (responseBody.getInt(STATUS_CODE_LABEL) == CREDENTIAL_ERROR) {
                throw new DataAccessException("message could not be found or password was incorrect");
            }
            else {
                throw new DataAccessException("database error: " + responseBody.getString(MESSAGE));
            }
        }
        catch (IOException | JSONException ex) {
            throw new DataAccessException(ex.getMessage());
        }

    }

    @Override
    public ResearchStudy getResearchStudy(String id) {
        final String username = "NullPointers";
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder()
                .url(String.format("http://vm003.teach.cs.toronto.edu:20112/user?username=%s", username))
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                final JSONObject userJSONObject = responseBody.getJSONObject("user");
                final JSONObject data = userJSONObject.getJSONObject("info");
                final JSONObject study = data.getJSONObject(id);
                return new ResearchStudy((String)study.get("user"), (String)study.get("title"), (String)study.get("details"));
            }
            else {
                throw new DataAccessException(responseBody.getString(MESSAGE));
            }
        }
        catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<ResearchStudy> getResearchStudies() {
        final String username = "NullPointers";
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder()
                .url(String.format("http://vm003.teach.cs.toronto.edu:20112/user?username=%s", username))
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                final JSONObject userJSONObject = responseBody.getJSONObject("user");
                final JSONObject data = userJSONObject.getJSONObject("info");
                List<ResearchStudy> researchStudies = new ArrayList<>();
                for (String keyStr : data.keySet()) {
                    final JSONObject study = data.getJSONObject(keyStr);
                    ResearchStudy detail = new ResearchStudy((String)study.get("user"), (String)study.get("title"),
                            (String)study.get("details"));
                    researchStudies.add(detail);
                }
                return researchStudies;
            }
            else {
                throw new DataAccessException(responseBody.getString(MESSAGE));
            }
        }
        catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean editResearchStudy(ResearchStudy researchStudy, String title, String details) {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Define the media type as JSON
        final MediaType mediaType = MediaType.parse(CONTENT_TYPE_JSON);

        // Create the JSON request body
        final JSONObject requestBody = new JSONObject();
        requestBody.put(USERNAME, "NullPointers");
        requestBody.put(PASSWORD, "NullPointers");
        final JSONObject extra = new JSONObject();
        JSONObject study = new JSONObject();
        study.put("user", researchStudy.getResearcherName());
        study.put("title", title);
        study.put("details", details);
        extra.put(researchStudy.getId(), study);
        requestBody.put("info", extra);

        // Build the PUT request
        final RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        final Request request = new Request.Builder()
                .url("http://vm003.teach.cs.toronto.edu:20112/modifyUserInfo")
                .method("PUT", body)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_JSON)
                .build();

        try {
            // Execute the request
            final Response response = client.newCall(request).execute();

            // Parse the response body
            final JSONObject responseBody = new JSONObject(response.body().string());

            // Check the response status code
            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                return true; // Indicate success
            } else if (responseBody.getInt(STATUS_CODE_LABEL) == CREDENTIAL_ERROR) {
                throw new DataAccessException("Authentication error: Incorrect username or password.");
            } else {
                throw new DataAccessException("Database error: " + responseBody.getString(MESSAGE));
            }
        } catch (IOException | JSONException ex) {
            throw new DataAccessException("Error while editing research study: " + ex.getMessage(), ex);
        }
    }

}
