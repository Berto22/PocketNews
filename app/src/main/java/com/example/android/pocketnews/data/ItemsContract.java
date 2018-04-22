package com.example.android.pocketnews.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.google.common.collect.ImmutableList;

/**
 * Created by berto on 3/21/2018.
 */

public class ItemsContract {
    public static final String AUTHORITY = "com.example.android.pocketnews";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH_TOP_NEWS = "top_news";
    public static final String PATH_US_NEWS = "us_news";
    public static final String PATH_WORLD_NEWS = "world_news";
    public static final String PATH_BUSINESS_NEWS = "business_news";
    public static final String PATH_SPORTS_NEWS = "sports_news";
    public static final String PATH_TECHNOLOGY_NEWS = "technology_news";
    public static final String PATH_ENTERTAINMENT_NEWS = "entertainment_news";

    private ItemsContract() {
        throw new AssertionError("No contract instance");
    }

    public static final class TopNewsEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOP_NEWS).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_TOP_NEWS;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_TOP_NEWS;

        public static final String _ID = "_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_SOURCE_ID = "source_id";
        public static final String COLUMN_SOURCE_NAME = "source_name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ARTICLE_URL = "article_url";
        public static final String COLUMN_IMAGE_URL = "image_url";
        public static final String COLUMN_PUBLISH_DATE = "publish_date";
        public static final String TABLE_NAME = "top_news";
        public static final int POSITION_ID = 0;
        public static final int POSITION_TITLE = 1;
        public static final int POSITION_SOURCE_ID = 2;
        public static final int POSITION_SOURCE = 3;
        public static final int POSITION_AUTHOR = 4;
        public static final int POSITION_DESCRIPTION = 5;
        public static final int POSITION_ARTICLE_URL = 6;
        public static final int POSITION_IMAGE_URL = 7;
        public static final int POSITION_PUBLISH_DATE = 8;
        public static final ImmutableList<String> TOP_NEWS_COLUMNS = ImmutableList.of(
                _ID,
                COLUMN_TITLE,
                COLUMN_SOURCE_ID,
                COLUMN_SOURCE_NAME,
                COLUMN_AUTHOR,
                COLUMN_DESCRIPTION,
                COLUMN_ARTICLE_URL,
                COLUMN_IMAGE_URL,
                COLUMN_PUBLISH_DATE
        );

        public static final String DEFAULT_SORT = COLUMN_PUBLISH_DATE + " DESC";

        public static Uri buildTopNewsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class UsNewsEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_US_NEWS).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_US_NEWS;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_US_NEWS;

        public static final String _ID = "_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_SOURCE_ID = "source_id";
        public static final String COLUMN_SOURCE_NAME = "source_name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ARTICLE_URL = "article_url";
        public static final String COLUMN_IMAGE_URL = "image_url";
        public static final String COLUMN_PUBLISH_DATE = "publish_date";
        public static final String TABLE_NAME = "us_news";
        public static final int POSITION_ID = 0;
        public static final int POSITION_TITLE = 1;
        public static final int POSITION_SOURCE_ID = 2;
        public static final int POSITION_SOURCE = 3;
        public static final int POSITION_AUTHOR = 4;
        public static final int POSITION_DESCRIPTION = 5;
        public static final int POSITION_ARTICLE_URL = 6;
        public static final int POSITION_IMAGE_URL = 7;
        public static final int POSITION_PUBLISH_DATE = 8;
        public static final ImmutableList<String> US_NEWS_COLUMNS = ImmutableList.of(
                _ID,
                COLUMN_TITLE,
                COLUMN_AUTHOR,
                COLUMN_SOURCE_ID,
                COLUMN_SOURCE_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_ARTICLE_URL,
                COLUMN_IMAGE_URL,
                COLUMN_PUBLISH_DATE
        );

        public static final String DEFAULT_SORT = COLUMN_PUBLISH_DATE + " DESC";

        public static Uri buildUsNewsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static final class WorldNewsEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_WORLD_NEWS).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_WORLD_NEWS;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_WORLD_NEWS;

        public static final String _ID = "_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_SOURCE_ID = "source_id";
        public static final String COLUMN_SOURCE_NAME = "source_name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ARTICLE_URL = "article_url";
        public static final String COLUMN_IMAGE_URL = "image_url";
        public static final String COLUMN_PUBLISH_DATE = "publish_date";
        public static final String TABLE_NAME = "world_news";
        public static final int POSITION_ID = 0;
        public static final int POSITION_TITLE = 1;
        public static final int POSITION_SOURCE_ID = 2;
        public static final int POSITION_SOURCE = 3;
        public static final int POSITION_AUTHOR = 4;
        public static final int POSITION_DESCRIPTION = 5;
        public static final int POSITION_ARTICLE_URL = 6;
        public static final int POSITION_IMAGE_URL = 7;
        public static final int POSITION_PUBLISH_DATE = 8;
        public static final ImmutableList<String> WORLD_NEWS_COLUMNS = ImmutableList.of(
                _ID,
                COLUMN_TITLE,
                COLUMN_AUTHOR,
                COLUMN_SOURCE_ID,
                COLUMN_SOURCE_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_ARTICLE_URL,
                COLUMN_IMAGE_URL,
                COLUMN_PUBLISH_DATE
        );

        public static final String DEFAULT_SORT = COLUMN_PUBLISH_DATE + " DESC";

        public static Uri buildWorldNewsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class BusinessNewsEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_BUSINESS_NEWS).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_BUSINESS_NEWS;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_BUSINESS_NEWS;

        public static final String _ID = "_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_SOURCE_ID = "source_id";
        public static final String COLUMN_SOURCE_NAME = "source_name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ARTICLE_URL = "article_url";
        public static final String COLUMN_IMAGE_URL = "image_url";
        public static final String COLUMN_PUBLISH_DATE = "publish_date";
        public static final String TABLE_NAME = "business_news";
        public static final int POSITION_ID = 0;
        public static final int POSITION_TITLE = 1;
        public static final int POSITION_SOURCE_ID = 2;
        public static final int POSITION_SOURCE = 3;
        public static final int POSITION_AUTHOR = 4;
        public static final int POSITION_DESCRIPTION = 5;
        public static final int POSITION_ARTICLE_URL = 6;
        public static final int POSITION_IMAGE_URL = 7;
        public static final int POSITION_PUBLISH_DATE = 8;
        public static final ImmutableList<String> BUSINESS_NEWS_COLUMNS = ImmutableList.of(
                _ID,
                COLUMN_TITLE,
                COLUMN_AUTHOR,
                COLUMN_SOURCE_ID,
                COLUMN_SOURCE_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_ARTICLE_URL,
                COLUMN_IMAGE_URL,
                COLUMN_PUBLISH_DATE
        );

        public static final String DEFAULT_SORT = COLUMN_PUBLISH_DATE + " DESC";

        public static Uri buildBusinessNewsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class SportNewsEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_SPORTS_NEWS).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_SPORTS_NEWS;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_SPORTS_NEWS;

        public static final String _ID = "_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_SOURCE_ID = "source_id";
        public static final String COLUMN_SOURCE_NAME = "source_name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ARTICLE_URL = "article_url";
        public static final String COLUMN_IMAGE_URL = "image_url";
        public static final String COLUMN_PUBLISH_DATE = "publish_date";
        public static final String TABLE_NAME = "sport_news";
        public static final int POSITION_ID = 0;
        public static final int POSITION_TITLE = 1;
        public static final int POSITION_SOURCE_ID = 2;
        public static final int POSITION_SOURCE = 3;
        public static final int POSITION_AUTHOR = 4;
        public static final int POSITION_DESCRIPTION = 5;
        public static final int POSITION_ARTICLE_URL = 6;
        public static final int POSITION_IMAGE_URL = 7;
        public static final int POSITION_PUBLISH_DATE = 8;
        public static final ImmutableList<String> SPORTS_NEWS_COLUMNS = ImmutableList.of(
                _ID,
                COLUMN_TITLE,
                COLUMN_AUTHOR,
                COLUMN_SOURCE_ID,
                COLUMN_SOURCE_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_ARTICLE_URL,
                COLUMN_IMAGE_URL,
                COLUMN_PUBLISH_DATE
        );

        public static final String DEFAULT_SORT = COLUMN_PUBLISH_DATE + " DESC";

        public static Uri buildSportNewsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class TechnologyNewsEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TECHNOLOGY_NEWS).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_TECHNOLOGY_NEWS;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/"
                + AUTHORITY + "/" + PATH_TECHNOLOGY_NEWS;

        public static final String _ID = "_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_SOURCE_ID = "source_id";
        public static final String COLUMN_SOURCE_NAME = "source_name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ARTICLE_URL = "article_url";
        public static final String COLUMN_IMAGE_URL = "image_url";
        public static final String COLUMN_PUBLISH_DATE = "publish_date";
        public static final String TABLE_NAME = "technology_news";
        public static final int POSITION_ID = 0;
        public static final int POSITION_TITLE = 1;
        public static final int POSITION_SOURCE_ID = 2;
        public static final int POSITION_SOURCE = 3;
        public static final int POSITION_AUTHOR = 4;
        public static final int POSITION_DESCRIPTION = 5;
        public static final int POSITION_ARTICLE_URL = 6;
        public static final int POSITION_IMAGE_URL = 7;
        public static final int POSITION_PUBLISH_DATE = 8;
        public static final ImmutableList<String> TECHNOLOGY_NEWS_COLUMNS = ImmutableList.of(
                _ID,
                COLUMN_TITLE,
                COLUMN_AUTHOR,
                COLUMN_SOURCE_ID,
                COLUMN_SOURCE_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_ARTICLE_URL,
                COLUMN_IMAGE_URL,
                COLUMN_PUBLISH_DATE
        );

        public static final String DEFAULT_SORT = COLUMN_PUBLISH_DATE + " DESC";

        public static Uri buildTechnologyNewsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
