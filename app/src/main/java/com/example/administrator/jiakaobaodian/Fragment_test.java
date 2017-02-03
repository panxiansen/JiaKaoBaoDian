package com.example.administrator.jiakaobaodian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */

public class Fragment_test extends Fragment {

    private List<Fragment> list_fragment;
    private List<String> list_title;

    private Toolbar fragment_test_toolbar;
    private TabLayout fragment_test_tablayout;
    private ViewPager fragment_test_viewpager;
    private Fragment_test_PagerAdapter pagerAdapter;
    private TextView toolbar_city_text;

    private Fragment_test_1 test1;
    private Fragment_test_2 test2;
    private Fragment_test_3 test3;
    private Fragment_test_4 test4;
    private Fragment_test_5 test5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test, container,false);

        initControls(view);

        return view;
    }

    //初始化各种控件
    private void initControls(View view){

        //初始化界面里的控件
        fragment_test_tablayout = (TabLayout) view.findViewById(R.id.fragment_test_tablayout);
        fragment_test_toolbar = (Toolbar) view.findViewById(R.id.fragment_test_toolbar);
        fragment_test_toolbar.inflateMenu(R.menu.jiakao_toolbar_menu);
        fragment_test_viewpager = (ViewPager) view.findViewById(R.id.fragment_test_viewPager);

        //初始化相对应的5个Fragment
        test1 = new Fragment_test_1();
        test2 = new Fragment_test_2();
        test3 = new Fragment_test_3();
        test4 = new Fragment_test_4();
        test5 = new Fragment_test_5();

        //将Fragment装进对应的列表
        list_fragment = new ArrayList<>();
        list_fragment.add(test1);
        list_fragment.add(test2);
        list_fragment.add(test3);
        list_fragment.add(test4);
        list_fragment.add(test5);

        //将对应的名字加到列表中，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("科目一");
        list_title.add("科目二");
        list_title.add("科目三");
        list_title.add("科目四");
        list_title.add("拿本");

        //设置TabLayout格式
        fragment_test_tablayout.setTabMode(TabLayout.MODE_FIXED);

        //为TabLayout添加名称
        fragment_test_tablayout.addTab(fragment_test_tablayout.newTab().setText(list_title.get(0)));
        fragment_test_tablayout.addTab(fragment_test_tablayout.newTab().setText(list_title.get(1)));
        fragment_test_tablayout.addTab(fragment_test_tablayout.newTab().setText(list_title.get(2)));
        fragment_test_tablayout.addTab(fragment_test_tablayout.newTab().setText(list_title.get(3)));
        fragment_test_tablayout.addTab(fragment_test_tablayout.newTab().setText(list_title.get(4)));

        pagerAdapter = new Fragment_test_PagerAdapter(getActivity().getSupportFragmentManager(),list_fragment,list_title);

        //viewPager加载Adapter
        fragment_test_viewpager.setAdapter(pagerAdapter);

        //TabLayout加载ViewPager
        fragment_test_tablayout.setupWithViewPager(fragment_test_viewpager);

        fragment_test_toolbar = (Toolbar) view.findViewById(R.id.fragment_test_toolbar);

        toolbar_city_text = (TextView) view.findViewById(R.id.test_toolbar_city);

        toolbar_city_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CityListActicity.class);
                startActivity(intent);
            }
        });

    }


}
