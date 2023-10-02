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
                .url("https://slack.com/api/auth.test")
                .get()
                .addHeader("Authorization", API_TOKEN)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

        if (responseBody.getBoolean("ok")) {
            JSONObject url = responseBody.getJSONObject("url");
            JSONObject team = responseBody.getJSONObject("team");
            JSONObject user = responseBody.getJSONObject("user");
            JSONObject team_id = responseBody.getJSONObject("team_id");
            JSONObject user_id = responseBody.getJSONObject("user_id");
            JSONObject bot_id = responseBody.getJSONObject("bot_id");
            JSONObject is_enterprise_install = responseBody.getJSONObject("is_enterprise_install");

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

    // example response body
    //{
    //    "ok": true,
    //        "url": "https://7ugroup.slack.com/",
    //        "team": "7U",
    //        "user": "7u_encryption",
    //        "team_id": "T05V1KHB6V7",
    //        "user_id": "U05VC0UF00Y",
    //        "bot_id": "B05URE7PN5A",
    //        "is_enterprise_install": false
    //}

}
