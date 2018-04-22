package com.example.android.pocketnews.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.media.tv.TvContract.Programs.Genres.NEWS;
import static android.os.Build.VERSION_CODES.M;
import static android.os.Build.VERSION_CODES.N;

/**
 * Created by berto on 3/21/2018.
 */

public class NewsItemsProvider extends ContentProvider {
    public static final int TOP_NEWS = 100;
    public static final int TOP_NEWS_WITH_ID = 101;
    public static final int US_NEWS = 200;
    public static final int US_NEWS_WITH_ID = 201;
    public static final int WORLD_NEWS = 300;
    public static final int WORLD_NEWS_WITH_ID = 301;
    public static final int BUSINESS_NEWS = 400;
    public static final int BUSINESS_NEWS_WITH_ID = 401;
    public static final int SPORT_NEWS = 500;
    public static final int SPORT_NEWS_WITH_ID = 501;
    public static final int TECHNOLOGY_NEWS = 600;
    public static final int TECHNOLOGY_NEWS_WITH_ID = 601;
    private static final UriMatcher sUriMatcher= buildUriMatcher();

    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_TOP_NEWS, TOP_NEWS);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_TOP_NEWS + "/*", TOP_NEWS_WITH_ID);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_US_NEWS, US_NEWS);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_TOP_NEWS + "/*", US_NEWS_WITH_ID);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_WORLD_NEWS, WORLD_NEWS);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_WORLD_NEWS + "/*", WORLD_NEWS_WITH_ID);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_BUSINESS_NEWS, BUSINESS_NEWS);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_BUSINESS_NEWS + "/*", BUSINESS_NEWS_WITH_ID);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_SPORTS_NEWS, SPORT_NEWS);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_SPORTS_NEWS + "/*", SPORT_NEWS_WITH_ID);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_TECHNOLOGY_NEWS, TECHNOLOGY_NEWS);
        uriMatcher.addURI(ItemsContract.AUTHORITY, ItemsContract.PATH_TECHNOLOGY_NEWS + "/*", TECHNOLOGY_NEWS_WITH_ID);

        return uriMatcher;
    }

    private NewsDbHelper mOpenHelper;


    public NewsItemsProvider() {
        super();
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new NewsDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case TOP_NEWS:
                return ItemsContract.TopNewsEntry.CONTENT_TYPE;
            case TOP_NEWS_WITH_ID:
                return ItemsContract.TopNewsEntry.CONTENT_ITEM_TYPE;
            case US_NEWS:
                return ItemsContract.UsNewsEntry.CONTENT_TYPE;
            case US_NEWS_WITH_ID:
                return ItemsContract.UsNewsEntry.CONTENT_ITEM_TYPE;
            case WORLD_NEWS:
                return ItemsContract.WorldNewsEntry.CONTENT_TYPE;
            case WORLD_NEWS_WITH_ID:
                return ItemsContract.WorldNewsEntry.CONTENT_ITEM_TYPE;
            case BUSINESS_NEWS:
                return ItemsContract.BusinessNewsEntry.CONTENT_TYPE;
            case BUSINESS_NEWS_WITH_ID:
                return ItemsContract.BusinessNewsEntry.CONTENT_ITEM_TYPE;
            case SPORT_NEWS:
                return ItemsContract.SportNewsEntry.CONTENT_TYPE;
            case SPORT_NEWS_WITH_ID:
                return ItemsContract.SportNewsEntry.CONTENT_ITEM_TYPE;
            case TECHNOLOGY_NEWS:
                return ItemsContract.TechnologyNewsEntry.CONTENT_TYPE;
            case TECHNOLOGY_NEWS_WITH_ID:
                return ItemsContract.TechnologyNewsEntry.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //return super.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
        final SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        int match = sUriMatcher.match(uri);
        Cursor returnCursor;
        switch (match) {
            case TOP_NEWS:
                returnCursor = db.query(ItemsContract.TopNewsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case TOP_NEWS_WITH_ID:
                String id = uri.getPathSegments().get(1);
                String mSelection = "_id=?";
                String[] mSelectionArgs = new String[]{id};

                returnCursor = db.query(ItemsContract.TopNewsEntry.TABLE_NAME,
                        projection,
                        mSelection,
                        mSelectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case US_NEWS:
                returnCursor = db.query(ItemsContract.UsNewsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case US_NEWS_WITH_ID:
                String teamId = uri.getPathSegments().get(1);
                String teamSelection = "_id=?";
                String[] teamSelectionArgs = new String[]{teamId};

                returnCursor = db.query(ItemsContract.UsNewsEntry.TABLE_NAME,
                        projection,
                        teamSelection,
                        teamSelectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case WORLD_NEWS:
                returnCursor = db.query(ItemsContract.WorldNewsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case WORLD_NEWS_WITH_ID:
                String worldNewsId = uri.getPathSegments().get(1);
                String worldNewsSelection = "_id=?";
                String[] worldNewsSelectionArgs = new String[]{worldNewsId};

                returnCursor = db.query(ItemsContract.WorldNewsEntry.TABLE_NAME,
                        projection,
                        worldNewsSelection,
                        worldNewsSelectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case BUSINESS_NEWS:
                returnCursor = db.query(ItemsContract.BusinessNewsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case BUSINESS_NEWS_WITH_ID:
                String businessNewsId = uri.getPathSegments().get(1);
                String businessNewsSelection = "_id=?";
                String[] businessNewsSelectionArgs = new String[]{businessNewsId};

                returnCursor = db.query(ItemsContract.BusinessNewsEntry.TABLE_NAME,
                        projection,
                        businessNewsSelection,
                        businessNewsSelectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case SPORT_NEWS:
                returnCursor = db.query(ItemsContract.SportNewsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case SPORT_NEWS_WITH_ID:
                String sportsNewsId = uri.getPathSegments().get(1);
                String sportNewsSelection = "_id=?";
                String[] sportNewsSelectionArgs = new String[]{sportsNewsId};

                returnCursor = db.query(ItemsContract.SportNewsEntry.TABLE_NAME,
                        projection,
                        sportNewsSelection,
                        sportNewsSelectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case TECHNOLOGY_NEWS:
                returnCursor = db.query(ItemsContract.TechnologyNewsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case TECHNOLOGY_NEWS_WITH_ID:
                String techNewsId = uri.getPathSegments().get(1);
                String techNewsSelection = "_id=?";
                String[] techNewsSelectionArgs = new String[]{techNewsId};

                returnCursor = db.query(ItemsContract.TechnologyNewsEntry.TABLE_NAME,
                        projection,
                        techNewsSelection,
                        techNewsSelectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        returnCursor.setNotificationUri(getContext().getContentResolver(), uri);

        DatabaseUtils.dumpCursorToString(returnCursor);

        return returnCursor;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        Uri returnUri;

        switch (match) {
            case TOP_NEWS:
                db.insert(ItemsContract.TopNewsEntry.TABLE_NAME, null, contentValues);
                returnUri = ItemsContract.TopNewsEntry.CONTENT_URI;
                break;

            case US_NEWS:
                db.insert(ItemsContract.UsNewsEntry.TABLE_NAME, null, contentValues);
                returnUri = ItemsContract.UsNewsEntry.CONTENT_URI;
                break;
            case WORLD_NEWS:
                db.insert(ItemsContract.WorldNewsEntry.TABLE_NAME, null, contentValues);
                returnUri = ItemsContract.WorldNewsEntry.CONTENT_URI;
                break;
            case BUSINESS_NEWS:
                db.insert(ItemsContract.BusinessNewsEntry.TABLE_NAME, null, contentValues);
                returnUri = ItemsContract.BusinessNewsEntry.CONTENT_URI;
                break;
            case SPORT_NEWS:
                db.insert(ItemsContract.SportNewsEntry.TABLE_NAME, null, contentValues);
                returnUri = ItemsContract.SportNewsEntry.CONTENT_URI;
                break;
            case TECHNOLOGY_NEWS:
                db.insert(ItemsContract.TechnologyNewsEntry.TABLE_NAME, null, contentValues);
                returnUri = ItemsContract.TechnologyNewsEntry.CONTENT_URI;
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsDeleted;
        if (selection == null) selection = "1";
        switch (match) {
            case TOP_NEWS:
                rowsDeleted =db.delete(ItemsContract.TopNewsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case US_NEWS:
                rowsDeleted = db.delete(ItemsContract.UsNewsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case WORLD_NEWS:
                rowsDeleted =db.delete(ItemsContract.WorldNewsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case BUSINESS_NEWS:
                rowsDeleted =db.delete(ItemsContract.BusinessNewsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case SPORT_NEWS:
                rowsDeleted =db.delete(ItemsContract.SportNewsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case TECHNOLOGY_NEWS:
                rowsDeleted =db.delete(ItemsContract.TechnologyNewsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        if (rowsDeleted != 0 ) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        //return super.bulkInsert(uri, values);
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case TOP_NEWS:
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(ItemsContract.TopNewsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            case US_NEWS:
                db.beginTransaction();
                int teamReturnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(ItemsContract.UsNewsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            teamReturnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return teamReturnCount;

            case WORLD_NEWS:
                db.beginTransaction();
                int returnWorldNewsCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(ItemsContract.WorldNewsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnWorldNewsCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnWorldNewsCount;

            case BUSINESS_NEWS:
                db.beginTransaction();
                int returnBusinessNewsCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(ItemsContract.BusinessNewsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnBusinessNewsCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnBusinessNewsCount;
            case SPORT_NEWS:
                db.beginTransaction();
                int returnSportsnewsCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(ItemsContract.SportNewsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnSportsnewsCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnSportsnewsCount;
            case TECHNOLOGY_NEWS:
                db.beginTransaction();
                int returnTechNewsCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(ItemsContract.TechnologyNewsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnTechNewsCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnTechNewsCount;
            default:
                return super.bulkInsert(uri, values);
        }
    }
}
