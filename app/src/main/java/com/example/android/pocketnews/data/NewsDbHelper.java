package com.example.android.pocketnews.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by berto on 3/21/2018.
 */

public class NewsDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PocketNews.db";
    private static final int VERSION = 1;

    NewsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TOP_NEWS_TABLE = "CREATE TABLE " +
                ItemsContract.TopNewsEntry.TABLE_NAME + " (" +
                ItemsContract.TopNewsEntry._ID + " INTEGER PRIMARY KEY, " +
                ItemsContract.TopNewsEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                ItemsContract.TopNewsEntry.COLUMN_AUTHOR + " TEXT NOT NULL, " +
                ItemsContract.TopNewsEntry.COLUMN_SOURCE_ID + " TEXT, " +
                ItemsContract.TopNewsEntry.COLUMN_SOURCE_NAME + " TEXT NOT NULL, " +
                ItemsContract.TopNewsEntry.COLUMN_PUBLISH_DATE + " TEXT NOT NULL, " +
                ItemsContract.TopNewsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                ItemsContract.TopNewsEntry.COLUMN_ARTICLE_URL + " TEXT NOT NULL, " +
                ItemsContract.TopNewsEntry.COLUMN_IMAGE_URL + " TEXT NOT NULL);";

        final String SQL_CREATE_US_NEWS_TABLE = "CREATE TABLE " +
                ItemsContract.UsNewsEntry.TABLE_NAME + " (" +
                ItemsContract.UsNewsEntry._ID + " INTEGER PRIMARY KEY, " +
                ItemsContract.UsNewsEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                ItemsContract.UsNewsEntry.COLUMN_AUTHOR + " TEXT NOT NULL, " +
                ItemsContract.UsNewsEntry.COLUMN_SOURCE_ID + " TEXT, " +
                ItemsContract.UsNewsEntry.COLUMN_SOURCE_NAME + " TEXT NOT NULL, " +
                ItemsContract.UsNewsEntry.COLUMN_PUBLISH_DATE + " TEXT NOT NULL, " +
                ItemsContract.UsNewsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                ItemsContract.UsNewsEntry.COLUMN_ARTICLE_URL + " TEXT NOT NULL, " +
                ItemsContract.UsNewsEntry.COLUMN_IMAGE_URL + " TEXT NOT NULL);";

        final String SQL_CREATE_WORLD_NEWS_TABLE = "CREATE TABLE " +
                ItemsContract.WorldNewsEntry.TABLE_NAME + " (" +
                ItemsContract.WorldNewsEntry._ID + " INTEGER PRIMARY KEY, " +
                ItemsContract.WorldNewsEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                ItemsContract.WorldNewsEntry.COLUMN_AUTHOR + " TEXT NOT NULL, " +
                ItemsContract.WorldNewsEntry.COLUMN_SOURCE_ID + " TEXT, " +
                ItemsContract.WorldNewsEntry.COLUMN_SOURCE_NAME + " TEXT NOT NULL, " +
                ItemsContract.WorldNewsEntry.COLUMN_PUBLISH_DATE + " TEXT NOT NULL, " +
                ItemsContract.WorldNewsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                ItemsContract.WorldNewsEntry.COLUMN_ARTICLE_URL + " TEXT NOT NULL, " +
                ItemsContract.WorldNewsEntry.COLUMN_IMAGE_URL + " TEXT NOT NULL);";

        final String SQL_CREATE_BUSINESS_NEWS_TABLE = "CREATE TABLE " +
                ItemsContract.BusinessNewsEntry.TABLE_NAME + " (" +
                ItemsContract.BusinessNewsEntry._ID + " INTEGER PRIMARY KEY, " +
                ItemsContract.BusinessNewsEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                ItemsContract.BusinessNewsEntry.COLUMN_AUTHOR + " TEXT NOT NULL, " +
                ItemsContract.BusinessNewsEntry.COLUMN_SOURCE_ID + " TEXT, " +
                ItemsContract.BusinessNewsEntry.COLUMN_SOURCE_NAME + " TEXT NOT NULL, " +
                ItemsContract.BusinessNewsEntry.COLUMN_PUBLISH_DATE + " TEXT NOT NULL, " +
                ItemsContract.BusinessNewsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                ItemsContract.BusinessNewsEntry.COLUMN_ARTICLE_URL + " TEXT NOT NULL, " +
                ItemsContract.BusinessNewsEntry.COLUMN_IMAGE_URL + " TEXT NOT NULL);";

        final String SQL_CREATE_SPORTS_NEWS_TABLE = "CREATE TABLE " +
                ItemsContract.SportNewsEntry.TABLE_NAME + " (" +
                ItemsContract.SportNewsEntry._ID + " INTEGER PRIMARY KEY, " +
                ItemsContract.SportNewsEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                ItemsContract.SportNewsEntry.COLUMN_AUTHOR + " TEXT NOT NULL, " +
                ItemsContract.SportNewsEntry.COLUMN_SOURCE_ID + " TEXT, " +
                ItemsContract.SportNewsEntry.COLUMN_SOURCE_NAME + " TEXT NOT NULL, " +
                ItemsContract.SportNewsEntry.COLUMN_PUBLISH_DATE + " TEXT NOT NULL, " +
                ItemsContract.SportNewsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                ItemsContract.SportNewsEntry.COLUMN_ARTICLE_URL + " TEXT NOT NULL, " +
                ItemsContract.SportNewsEntry.COLUMN_IMAGE_URL + " TEXT NOT NULL);";

        final String SQL_CREATE_TECHNOLOGY_NEWS_TABLE = "CREATE TABLE " +
                ItemsContract.TechnologyNewsEntry.TABLE_NAME + " (" +
                ItemsContract.TechnologyNewsEntry._ID + " INTEGER PRIMARY KEY, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_AUTHOR + " TEXT NOT NULL, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_SOURCE_ID + " TEXT, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_SOURCE_NAME + " TEXT NOT NULL, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_PUBLISH_DATE + " TEXT NOT NULL, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_ARTICLE_URL + " TEXT NOT NULL, " +
                ItemsContract.TechnologyNewsEntry.COLUMN_IMAGE_URL + " TEXT NOT NULL);";



        sqLiteDatabase.execSQL(SQL_CREATE_TOP_NEWS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_US_NEWS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_WORLD_NEWS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_BUSINESS_NEWS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_SPORTS_NEWS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TECHNOLOGY_NEWS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ItemsContract.TopNewsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ItemsContract.UsNewsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ItemsContract.WorldNewsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ItemsContract.BusinessNewsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ItemsContract.SportNewsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ItemsContract.TechnologyNewsEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
