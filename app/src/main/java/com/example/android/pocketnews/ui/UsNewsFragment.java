package com.example.android.pocketnews.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.pocketnews.R;
import com.example.android.pocketnews.data.ItemsContract;
import com.example.android.pocketnews.sync.NewsUpdaterService;

/**
 * Created by berto on 3/20/2018.
 */

public class UsNewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    final static String ARG_NEWS_PAGE = "news_page";
    private static String newsPage = "us_news";
    private static RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private static final int TOP_STORIES_LOADER = 0;

    public UsNewsFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*if(savedInstanceState == null) {
            refresh();
        }
        //getActivity().getSupportLoaderManager().initLoader(TOP_STORIES_LOADER, null, getActivity());
        getLoaderManager().initLoader(TOP_STORIES_LOADER, null, this);

        TopStoriesFragment topStoriesFragment = new TopStoriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NEWS_PAGE, newsPage );
        topStoriesFragment.setArguments(args); */
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_us_news, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*recyclerView = (RecyclerView) view.findViewById(R.id.usNews_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsAdapter); */


    }

    /*private void refresh() {
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
    }; */

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
        /*String[] args1 = {"null"};
        return new CursorLoader(this.getContext(),
                ItemsContract.UsNewsEntry.CONTENT_URI,
                ItemsContract.UsNewsEntry.US_NEWS_COLUMNS.toArray(new String[]{}),
                //null, null, ItemsContract.TopNewsEntry.DEFAULT_SORT);
                ItemsContract.UsNewsEntry.COLUMN_SOURCE_ID + " !=?", args1, ItemsContract.UsNewsEntry.DEFAULT_SORT); */
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        //newsAdapter.setmCursor(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        //newsAdapter.setmCursor(null);

    }
}
