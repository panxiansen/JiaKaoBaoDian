package com.example.administrator.jiakaobaodian.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.jiakaobaodian.R;

/**
 * Created by Administrator on 2016/12/11.
 */

public class Fragment_maiche extends Fragment {

    private Toolbar fragment_maiche_toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_maiche, container, false);
        init(view);
        return view;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    private void init(View view){
        fragment_maiche_toolbar = (Toolbar) view.findViewById(R.id.fragment_maiche_toolbar);
        fragment_maiche_toolbar.inflateMenu(R.menu.jiakao_toolbar_menu);
    }

}
