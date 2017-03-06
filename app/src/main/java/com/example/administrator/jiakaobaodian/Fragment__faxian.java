package com.example.administrator.jiakaobaodian;

import android.annotation.TargetApi;
import android.os.Build;
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

public class Fragment__faxian extends Fragment {

    private Toolbar fragment_faxian_toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_faxian, container, false);
        init(view);
        return view;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    private void init(View view){
        fragment_faxian_toolbar = (Toolbar) view.findViewById(R.id.fragment_faxian_toolbar);
        fragment_faxian_toolbar.inflateMenu(R.menu.jiakao_toolbar_menu);
    }

}
