package com.example.android.pocketnews.sync;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

/**
 * Created by berto on 3/23/2018.
 */

public class FetchNewsUtil {
    private static final String TAG = FetchNewsUtil.class.getSimpleName();
    private static Context mContext;

    private FetchNewsUtil() {

    }

    public static JSONArray fetchJsonArray() {
        String jsonArrayResponse = null;

        try {
            jsonArrayResponse = fetchNews(Config.BASE_URL);
        } catch (IOException e) {
            Timber.e(TAG, "Error fetching news", e);
            return null;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonArrayResponse);
            JSONArray jsonArray = jsonObject.getJSONArray("articles");
            return jsonArray;
        } catch (JSONException e) {
            Timber.e(TAG, "Error parsing JSON");
        }

        return null;
    }

    static String fetchNews(URL url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
