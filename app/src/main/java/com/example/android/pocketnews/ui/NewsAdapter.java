package com.example.android.pocketnews.ui;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pocketnews.R;
import com.example.android.pocketnews.data.ItemsContract;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.logging.Handler;

/**
 * Created by berto on 3/25/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    public static String TAG = NewsAdapter.class.toString();
    private final Context mContext;
    private Cursor mCursor;

    public NewsAdapter(Context context, Cursor cursor) {
        //super();
        mContext = context;
        mCursor = cursor;

    }

    void setmCursor(Cursor cursor) {
        mCursor = cursor;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, Integer.toString(position));
        return super.getItemViewType(position);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);

        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        holder.titleTextView.setText(mCursor.getString(ItemsContract.TopNewsEntry.POSITION_TITLE));
        holder.authorTextView.setText(mCursor.getString(ItemsContract.TopNewsEntry.POSITION_SOURCE_ID));

        Picasso.with(mContext).load(mCursor.getString(ItemsContract.TopNewsEntry.POSITION_IMAGE_URL))
                .fit()
                .into(holder.image);



        holder.titleTextView.setText(mCursor.getString(ItemsContract.TopNewsEntry.POSITION_TITLE));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mCursor != null) {
            count = mCursor.getCount();
        }
        return count;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTextView;
        public TextView authorTextView;
        public ImageView image;
        public NewsViewHolder(View itemView) {
            super(itemView);

            titleTextView = (TextView)itemView.findViewById(R.id.news_title);
            authorTextView = (TextView)itemView.findViewById(R.id.news_author);
            image = (ImageView)itemView.findViewById(R.id.news_image);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
