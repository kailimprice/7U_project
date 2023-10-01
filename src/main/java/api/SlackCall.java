package api;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SlackCall {
    private static final String API_URL = "https://grade-logging-api.chenpan.ca/api/grade";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }
    public SlackCall() throws JSONException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://grade-logging-api.chenpan.ca/team")
                .get()
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

        if (responseBody.getInt("status_code") == 200) {
            JSONObject team = responseBody.getJSONObject("team");
            JSONArray membersArray = team.getJSONArray("members");
            String[] members = new String[membersArray.length()];
        for (int i = 0; i < membersArray.length(); i++) {
            members[i] = membersArray.getString(i);
        }
        return Team.builder()
                        .name(team.getString("name"))
                        .members(members)
                        .build();
        }
        else {
        throw new RuntimeException(responseBody.getString("message"));
            }
        }
        catch (IOException | JSONException e){
        throw new RuntimeException(e);
        }
    }

    // draft copy
    public Team getMyTeam(String course) {


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://grade-logging-api.chenpan.ca/grade?course=%s&utorid=%s", course, utorid))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                JSONObject grade = responseBody.getJSONObject("grade");
                return Grade.builder()
                        .utorid(grade.getString("utorid"))
                        .course(grade.getString("course"))
                        .grade(grade.getInt("grade"))
                        .build();
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
