package com.example.android.commitcontent.ime;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Arhat on 7/26/2017.
 */

public class InputBoardView extends RelativeLayout {

    private TabLayout tab = null;
    private ViewPager pager = null;

    public InputBoardView(Context context) {
        super(context);
    }

    public InputBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputBoardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
}
