package com.example.android.commitcontent.ime;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;

public class AdapterPager extends PagerAdapter implements MyRecyclerViewAdapter.MyClickListener {

    private Context mContext;
    private LayoutInflater inflater = null;
    private ArrayList<File> files = null;
    private MyClickListener myClickListener = null;

    public AdapterPager(Context context, ArrayList<File> files) {
        mContext = context;
        this.files = files;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.frag_keyboard, collection, false);
        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.rcvCharacter);

        recyclerView.setHasFixedSize(true);
        int span = mContext.getResources().getBoolean(R.bool.is_landscape) ? 6 : 4;
        LinearLayoutManager mLayoutManager = new GridLayoutManager(mContext, span);
        recyclerView.setLayoutManager(mLayoutManager);
        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(mContext, files);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        mAdapter.setOnItemClickListener(this);
        collection.addView(layout);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    @Override
    public void onItemClick(int position, View v) {
        myClickListener.onItemClick(position, v);
    }


    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}

