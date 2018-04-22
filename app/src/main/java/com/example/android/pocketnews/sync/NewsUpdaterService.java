package com.example.android.pocketnews.sync;

import android.app.IntentService;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android.pocketnews.data.ItemsContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * Created by berto on 3/23/2018.
 */

public class NewsUpdaterService extends IntentService {
    private static final String TAG = NewsUpdaterService.class.getSimpleName();
    public static final String BROADCAST_ACTION_STATE_CHANGE = "com.example.pocketnews.intent.action.STATE.CHANGE";
    public static final String EXTRA_REFRESHING = "com.example.pocketnews.intent.extra.REFRESHING";

    public NewsUpdaterService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            Timber.d("Network not available");
            return;
        }

        sendBroadcast(new Intent(BROADCAST_ACTION_STATE_CHANGE).putExtra(EXTRA_REFRESHING, true));

        ArrayList<ContentProviderOperation> cpo = new ArrayList<ContentProviderOperation>();

        Uri uri = ItemsContract.TopNewsEntry.CONTENT_URI;

        //Delete all items
        cpo.add(ContentProviderOperation.newDelete(uri).build());

        try {
            JSONArray jsonArray = FetchNewsUtil.fetchJsonArray();
            if (jsonArray == null) {
                throw new JSONException("No JSONArray");
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                ContentValues values = new ContentValues();
                JSONObject object = jsonArray.getJSONObject(i);
                values.put(ItemsContract.TopNewsEntry.COLUMN_TITLE, object.getString("title" ));
                String sTitle = object.getString("title");

                String author = object.getString("author");
                String mSourceId = object.getJSONObject("source").getString("id");
                String mSource = object.getJSONObject("source").getString("name");
                Timber.d(author);
                Timber.d(sTitle);
                Log.d(TAG, sTitle);
                Log.d(TAG, author);
                Log.d(TAG, mSourceId);
                Log.d(TAG, mSource);

                String sourceId = "empty";
                String sourceName = "empty";
                /*if(object.has("source")) {
                    JSONArray sourcesArray = object.getJSONArray("source");
                    for (int j =0; j < sourcesArray.length(); j++) {
                        sourceId = sourcesArray.getString(0);
                        Timber.d(sourceId);
                        Log.d(TAG, sourceId);
                        sourceName = sourcesArray.getString(1);
                        Log.d(TAG, sourceName);
                        Timber.d(sourceName);
                    }
                } */

                values.put(ItemsContract.TopNewsEntry.COLUMN_AUTHOR, object.getString("author"));
                values.put(ItemsContract.TopNewsEntry.COLUMN_DESCRIPTION, object.getString("description"));
                values.put(ItemsContract.TopNewsEntry.COLUMN_ARTICLE_URL, object.getString("url"));
                values.put(ItemsContract.TopNewsEntry.COLUMN_IMAGE_URL, object.getString("urlToImage"));
                values.put(ItemsContract.TopNewsEntry.COLUMN_PUBLISH_DATE, object.getString("publishedAt"));
                values.put(ItemsContract.TopNewsEntry.COLUMN_SOURCE_ID, mSourceId);
                values.put(ItemsContract.TopNewsEntry.COLUMN_SOURCE_NAME, mSource);



                cpo.add(ContentProviderOperation.newInsert(uri).withValues(values).build());
            }

            getContentResolver().applyBatch(ItemsContract.AUTHORITY, cpo);

        } catch (JSONException | RemoteException | OperationApplicationException e) {
            Timber.e(TAG, "Error updating news", e);

        }
        sendBroadcast(new Intent(BROADCAST_ACTION_STATE_CHANGE).putExtra(EXTRA_REFRESHING, false));
    }
}
