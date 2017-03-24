package com.example.administrator.jiakaobaodian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.jiakaobaodian.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/19.
 */

public class FirstStart_Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<View> picList;
    private PagerAdapter pagerAdapter;
    private LinearLayout layout1,layout2,layout3;
    private RelativeLayout layout4;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_start);

        init();
    }


    public void init(){
        picList = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.first_start_viewPager);
        LayoutInflater inflater = getLayoutInflater();
        layout1 = (LinearLayout) inflater.inflate(R.layout.first_start_background1, null);
        layout2 = (LinearLayout) inflater.inflate(R.layout.first_start_background2, null);
        layout3 = (LinearLayout) inflater.inflate(R.layout.first_start_background3, null);
        layout4 = (RelativeLayout) inflater.inflate(R.layout.first_start_background, null);

        picList.add(layout1);
        picList.add(layout2);
        picList.add(layout3);
        picList.add(layout4);



        pagerAdapter = new PagerAdapter() {


            @Override
            public int getCount() {
                return picList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(picList.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(picList.get(position));
                return picList.get(position);
            }
        };

        viewPager.setAdapter(pagerAdapter);

        textView = (TextView) findViewById(R.id.first_start_textView);

    }

    public void doonclick(View view){
        Intent intent = new Intent(FirstStart_Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
