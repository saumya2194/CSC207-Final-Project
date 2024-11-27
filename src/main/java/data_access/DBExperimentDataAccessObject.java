package data_access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import entity.CommonStudy;
import entity.CommonStudyFactory;
import entity.CommonUserFactory;
import entity.StudyFactory;
import entity.UserFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import use_case.view_experiment.ViewExperimentDataAccessInterface;



public class DBExperimentDataAccessObject implements ViewExperimentDataAccessInterface {
    private static final int SUCCESS_CODE = 200;
    private static final int CREDENTIAL_ERROR = 401;
    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String STATUS_CODE_LABEL = "status_code";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
    private final StudyFactory studyFactory;
    private final UserFactory userFactory;



    /**
     * Gets all the studies which are currently saved.
     *
     * @return All the studies that have been made from the DB.
     */
    public DBExperimentDataAccessObject(StudyFactory studyFactory, UserFactory userFactory) {
        this.studyFactory = studyFactory;
        this.userFactory = userFactory;
        // No need to do anything to reinitialize a user list! The data is the cloud that may be miles away.
    }

    /**
     *
     * @return JSONArray of the all the studies under NullPointers account from the database.
     */
    public JSONArray getStudies() {
        // Make an API call to get the user object.
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder()
                .url(String.format("http://vm003.teach.cs.toronto.edu:20112/user?username=%s", "NullPointers"))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                final JSONObject userJSONObject = responseBody.getJSONObject("user");
                final JSONObject info = userJSONObject.getJSONObject("info");
                final JSONArray studies = info.getJSONArray("studies");

                return studies;
            } else {
                throw new RuntimeException(responseBody.getString(MESSAGE));
            }
        } catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * This method is to the getStudies JSONArray return into CommonStudy objects.
     * @return List of CommonStudy objects
     */
    public List<CommonStudy> getStudyObjects() {
        final JSONArray temp = getStudies();
        List<CommonStudy> res = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++ ) {
            JSONObject study = temp.getJSONObject(i);
            CommonStudy myStudyObject = studyFactory.create(study.getString("user"), study.getString("title"), study.getString("details"), study.getString("id"));
            res.add(myStudyObject);
        }
        return res;
    }

    /**
     * Takes the list of current studies we have saved. And add the new researchStudy to that list.
     * All the studies are added under NullPointers username.
     *
     * @param researchStudy - CommonStudy object that we want to add into the database.
     * @return True if the study is added successfully onto current studies list. Otherwise return False.
     */

    public boolean saveResearchStudy(CommonStudy researchStudy) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        // POST METHOD
        final MediaType mediaType = MediaType.parse(CONTENT_TYPE_JSON);
        final JSONObject requestBody = new JSONObject();
        requestBody.put(USERNAME, "NullPointers");
        requestBody.put(PASSWORD, "NullPointers");

        JSONArray studies = getStudies();
        JSONObject study = new JSONObject();

        // TODO create a builder for JSON Objects.
        // part for putting the
        study.put("user", researchStudy.getUser());
        study.put("title", researchStudy.getTitle());
        study.put("details", researchStudy.getDetails());
        study.put("id", researchStudy.getId());

        studies.put(study);
        JSONObject studiesObject = new JSONObject();
        studiesObject.put("studies", studies);
        requestBody.put("info", studiesObject);
        final RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        final Request request = new Request.Builder()
                .url("http://vm003.teach.cs.toronto.edu:20112/modifyUserInfo")
                .method("PUT", body)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            System.out.println(responseBody);

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                return true;
            } else if (responseBody.getInt(STATUS_CODE_LABEL) == CREDENTIAL_ERROR) {
                throw new RuntimeException("message could not be found or password was incorrect");
            } else {
                throw new RuntimeException("database error: " + responseBody.getString(MESSAGE));
            }
        } catch (IOException | JSONException ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

    /**
     * Retrieve all the research studies created by a User.
     *
     * @param username is a String that is username of the User that we want to retrieve of.
     * @return
     */
    public List<CommonStudy> retrieveUserStudies(String username) {
        final List<CommonStudy> studies = new ArrayList<>();
        for (Object obj : getStudies().toList()) {
            Map<String, String> map = (Map<String, String>) obj;
            if (map.get("user").equals(username)) {
                String details = map.get("details");
                String title = map.get("title");
                String id = map.get("id");
                CommonStudy userStudy = studyFactory.create(username, title, details, id);
                studies.add(userStudy);
            }
        }
        return studies;
    }


    /**
     * Delete a specified ResearchStudy from the database. Deletion will be based on the unique ID that is associated with
     * the study.
     *
     * @param id
     * @return
     */

    public boolean deleteResearchStudy(String id) {
        final JSONArray studies = getStudies();
        final JSONArray newStudies = new JSONArray();
        studies.toList().stream().map(obj -> (Map<String, String>) obj).filter(obj -> !obj.get("id").equals(id)).forEach(newStudies::put);
        final JSONObject requestBody = new JSONObject(); requestBody.put(USERNAME, "NullPointers"); requestBody.put(PASSWORD, "NullPointers");
        final MediaType mediaType = MediaType.parse(CONTENT_TYPE_JSON);
        final JSONObject studiesObject = new JSONObject(); studiesObject.put("studies", newStudies); requestBody.put("info", studiesObject);
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        final Request request = new Request.Builder()
                .url("http://vm003.teach.cs.toronto.edu:20112/modifyUserInfo")
                .method("PUT", body)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) { return studies.length() != newStudies.length();
            } else if (responseBody.getInt(STATUS_CODE_LABEL) == CREDENTIAL_ERROR) { throw new RuntimeException("message could not be found or password was incorrect");
            } else { throw new RuntimeException("database error: " + responseBody.getString(MESSAGE));
            }
        } catch (IOException | JSONException ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

    public boolean editResearchStudy(CommonStudy study) {
        if (!deleteResearchStudy(study.getId()))
            return false;
        saveResearchStudy(study); return true;
    }

//    public void editRes


}
