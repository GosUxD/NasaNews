package com.ergon.test.nasafeedapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ergon.test.nasafeedapp.R;
import com.ergon.test.nasafeedapp.model.NewsSingleton;
import com.ergon.test.nasafeedapp.model.pojo.Item;
import com.squareup.picasso.Picasso;

/**
 * Created by daniel on 16.5.16.
 */
public class NewsDetailFragment extends Fragment {

    private static final String ARG_NEWS_TITLE = "arg_news_title";
    private Item mItem;
    private ImageView mDetailImage;
    private TextView mDetailTitle;
    private TextView mDetailDesc;
    private TextView mDetailDate;
    private TextView mDetailLink;


    public static NewsDetailFragment newInstance(String newsTitle) {

        Bundle args = new Bundle();
        args.putString(ARG_NEWS_TITLE, newsTitle);
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_detail, container, false);

        mDetailImage = (ImageView) root.findViewById(R.id.detail_image);
        mDetailTitle = (TextView) root.findViewById(R.id.detail_title);
        mDetailDesc = (TextView) root.findViewById(R.id.detail_description);
        mDetailDate = (TextView) root.findViewById(R.id.detail_date);
        mDetailLink = (TextView) root.findViewById(R.id.detail_link);

        Picasso.with(getActivity()).load(mItem.getEnclosure().getLink()).into(mDetailImage);
        mDetailTitle.setText(mItem.getTitle());
        mDetailDesc.setText(mItem.getDescription());
        mDetailDate.setText(mItem.getPubDate());
        mDetailLink.setText(mItem.getLink());
        mDetailLink.setMovementMethod(LinkMovementMethod.getInstance());

        return root;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        String newsTitle = getArguments().getString(ARG_NEWS_TITLE);
        mItem = NewsSingleton.getInstance().getItem(newsTitle);
    }
}
