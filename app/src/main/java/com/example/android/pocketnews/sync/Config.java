package com.example.android.pocketnews.sync;

import android.os.Bundle;

import com.example.android.pocketnews.ui.MainActivity;
import com.example.android.pocketnews.ui.SectionsPagerAdapter;
import com.example.android.pocketnews.ui.TopStoriesFragment;

import java.net.MalformedURLException;
import java.net.URL;

import timber.log.Timber;

/**
 * Created by berto on 3/23/2018.
 */

public class Config {
    public static String TAG = Config.class.toString();
    public static final URL BASE_URL;
    //private static int fragPos = MainActivity



    static {
        URL url = null;
        try {
            //url = new URL("https://newsapi.org/v1/articles?source=nfl-news&sortBy=latest&apiKey=");
            //url = new URL("https://newsapi.org/v2/top-headlines?sources=reuters&apiKey=");
            url = new URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=");

        } catch (MalformedURLException ignored) {
            Timber.e(TAG, "Check internet connection");
        }
        BASE_URL = url;
    }
}
