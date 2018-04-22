package com.example.android.pocketnews.ui;

//import android.app.LoaderManager;
//import android.support.v4.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.DatabaseUtils;
import android.support.v4.content.Loader;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
//import android.content.CursorLoader;
//import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pocketnews.R;
import com.example.android.pocketnews.data.ItemsContract;
import com.example.android.pocketnews.sync.NewsUpdaterService;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by berto on 3/20/2018.
 */

public class TopStoriesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    /*private TextView mTitle;
    private TextView mAuthor;
    private TextView mDate;
    private TextView mDescription; */
    final static String ARG_NEWS_PAGE = "news_page";
    private static String newsPage = "top_stories";
    private static RecyclerView recyclerView;
    private NewsAdapter newsAdapter;

    private static final int TOP_STORIES_LOADER = 0;
    public TopStoriesFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newsAdapter = new NewsAdapter(getActivity(), null);

        //getLoaderManager().initLoader(TOP_STORIES_LOADER, null, this);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState == null) {
            refresh();
        }
        //getActivity().getSupportLoaderManager().initLoader(TOP_STORIES_LOADER, null, getActivity());
        getLoaderManager().initLoader(TOP_STORIES_LOADER, null, this);

        TopStoriesFragment topStoriesFragment = new TopStoriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NEWS_PAGE, newsPage );
        topStoriesFragment.setArguments(args);

    }

    /*private void updateRefreshingUI() {
        mSwipeRefreshLayout.setRefreshing(mIsRefreshing);
    } */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_top_stories, container, false);
        /*mTitle = (TextView)rootView.findViewById(R.id.title_textView);
        mAuthor = (TextView)rootView.findViewById(R.id.author_textView);
        mDate = (TextView)rootView.findViewById(R.id.date_textView);
        mDescription = (TextView)rootView.findViewById(R.id.description_textView); */
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.topNews_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsAdapter);

    }

    private void refresh() {
        getActivity().startService(new Intent(getActivity().getApplicationContext(), NewsUpdaterService.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().registerReceiver(mRefreshingReceiver,
                new IntentFilter(NewsUpdaterService.BROADCAST_ACTION_STATE_CHANGE));
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(mRefreshingReceiver);
    }

    private boolean mIsRefreshing = false;

    private BroadcastReceiver mRefreshingReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (NewsUpdaterService.BROADCAST_ACTION_STATE_CHANGE.equals(intent.getAction())) {
                mIsRefreshing = intent.getBooleanExtra(NewsUpdaterService.EXTRA_REFRESHING, true);
                //updateRefreshingUI();
            }
        }
    };

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        //return null;
        String[] args = {"null"};
        return new CursorLoader(this.getContext(),
                ItemsContract.TopNewsEntry.CONTENT_URI,
                ItemsContract.TopNewsEntry.TOP_NEWS_COLUMNS.toArray(new String[]{}),
                //null, null, ItemsContract.TopNewsEntry.DEFAULT_SORT);
                ItemsContract.TopNewsEntry.COLUMN_SOURCE_ID + " !=?", args, ItemsContract.TopNewsEntry.DEFAULT_SORT);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        newsAdapter.setmCursor(cursor);
        /*if(cursor != null && cursor.moveToFirst()) {
            String title = cursor.getString(ItemsContract.TopNewsEntry.POSITION_TITLE);
            String author = cursor.getString(ItemsContract.TopNewsEntry.POSITION_AUTHOR);
            String date = cursor.getString(ItemsContract.TopNewsEntry.POSITION_PUBLISH_DATE);
            String description = cursor.getString(ItemsContract.TopNewsEntry.POSITION_DESCRIPTION);

            mTitle.setText(title);
            mAuthor.setText(author);
            mDate.setText(date);
            mDescription.setText(description);

        } */
        DatabaseUtils.dumpCursorToString(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        newsAdapter.setmCursor(null);

    }
}
