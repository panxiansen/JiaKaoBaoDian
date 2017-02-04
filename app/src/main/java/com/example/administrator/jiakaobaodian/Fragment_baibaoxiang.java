package com.example.administrator.jiakaobaodian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/12/11.
 */

public class Fragment_baibaoxiang extends Fragment {

    private Toolbar fragment_baibaoxiang_toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baibaoxiang, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        fragment_baibaoxiang_toolbar = (Toolbar) view.findViewById(R.id.fragment_baibaoxiang_toolbar);
        fragment_baibaoxiang_toolbar.inflateMenu(R.menu.jiakao_toolbar_menu);
    }

}
