package com.ergon.test.nasafeedapp.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ergon.test.nasafeedapp.R;
import com.ergon.test.nasafeedapp.model.NewsSingleton;
import com.ergon.test.nasafeedapp.model.pojo.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by daniel on 15.5.16.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private ArrayList<Item> mItems;
    private NewsItemListener mItemListener;

    public NewsAdapter(ArrayList<Item> items, NewsItemListener itemListener) {
        this.mItems = items;
        mItemListener = itemListener;
    }

    public void addNews(ArrayList<Item> news) {
        NewsSingleton.getInstance().setNews(news);
        notifyDataSetChanged();
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_row, parent, false);
        return new NewsHolder(view, mItemListener);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.mTitle.setText(mItems.get(position).getTitle());
        Picasso.with(holder.itemView.getContext())
                .load(mItems.get(position).getEnclosure().getLink())
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public Item getItem(int position) {
        return mItems.get(position);
    }

    public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public ImageView mImage;
        private NewsItemListener mItemListener;

        public NewsHolder(View itemView, NewsItemListener listener) {
            super(itemView);
            mItemListener = listener;
            mTitle = (TextView) itemView.findViewById(R.id.news_title);
            mImage = (ImageView) itemView.findViewById(R.id.news_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Item news = getItem(position);
            mItemListener.onNewsClick(news);
        }
    }

    public interface NewsItemListener {
        void onNewsClick(Item news);
    }

}


