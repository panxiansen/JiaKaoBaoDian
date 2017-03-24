package com.example.administrator.jiakaobaodian.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/3/20.
 */

public class FirstStart_PagerAdapter extends PagerAdapter {

    private List<View> viewList;

    public FirstStart_PagerAdapter(List<View> viewList) {
        super();
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
