package com.example.administrator.jiakaobaodian;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    //双击退出变量声明
    private long firstTime = 0;

    //导航栏控件布局声明
    private LinearLayout tab_menu_baoming;
    private LinearLayout tab_menu_jiakao;
    private LinearLayout tab_menu_maiche;
    private LinearLayout tab_menu_faxian;
    private LinearLayout tab_menu_baibaoxiang;

    //导航栏字体控件声明
    private TextView tab_menu_baoming_text;
    private TextView tab_menu_jiakao_text;
    private TextView tab_menu_maiche_text;
    private TextView tab_menu_faxian_text;
    private TextView tab_menu_baibaoxiang_text;

    //五大界面布局
    private Fragment_baoming Baoming;
    private Fragment_maiche Maiche;
    private Fragment__faxian Faxian;
    private Fragment_baibaoxiang Baibaoxiang;
    private Fragment_test Jiakao;

    private Toolbar toolbar;

    //登录界面变量声明
    private ImageButton menu_login_image;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        setSelected();
        setDefaultFragment();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //双击退出
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            long secondTime = System.currentTimeMillis();

            if(secondTime - firstTime > 2000){
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;//重置第一次点击退出键时间
                return true;
            }else{
                System.exit(0);
            }
        }


        return super.onKeyUp(keyCode, event);
    }

    //初始化控件
    public void init(){
        tab_menu_baoming = (LinearLayout) findViewById(R.id.tab_menu_baoming);
        tab_menu_jiakao = (LinearLayout) findViewById(R.id.tab_menu_jiakao);
        tab_menu_maiche = (LinearLayout) findViewById(R.id.tab_menu_maiche);
        tab_menu_faxian = (LinearLayout) findViewById(R.id.tab_menu_faxian);
        tab_menu_baibaoxiang = (LinearLayout) findViewById(R.id.tab_menu_baibaoxiang);

        tab_menu_baoming_text = (TextView) findViewById(R.id.teb_menu_baoming_text);
        tab_menu_jiakao_text = (TextView) findViewById(R.id.teb_menu_jiakao_text);
        tab_menu_maiche_text = (TextView) findViewById(R.id.tab_menu_maiche_text);
        tab_menu_faxian_text = (TextView) findViewById(R.id.tab_menu_faxian_text);
        tab_menu_baibaoxiang_text = (TextView) findViewById(R.id.tab_menu_baibaoxiang_text);

        //登录界面
        menu_login_image = (ImageButton) findViewById(R.id.menu_login_image);
        menu_login_image.setOnClickListener(this);

        tab_menu_baoming.setOnClickListener(this);
        tab_menu_jiakao.setOnClickListener(this);
        tab_menu_maiche.setOnClickListener(this);
        tab_menu_faxian.setOnClickListener(this);
        tab_menu_baibaoxiang.setOnClickListener(this);

    }

    //定义初始界面方法
    private void setDefaultFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Jiakao = new Fragment_test();
        transaction.replace(R.id.fragment_contentview, Jiakao);
        transaction.commit();
        tab_menu_jiakao_text.setSelected(true);

    }


    //重置所有TextView的选择状态
    private void setSelected(){

        tab_menu_baoming_text.setSelected(false);
        tab_menu_jiakao_text.setSelected(false);
        tab_menu_maiche_text.setSelected(false);
        tab_menu_faxian_text.setSelected(false);
        tab_menu_baibaoxiang_text.setSelected(false);

    }

    //下方导航栏点击监听
    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.tab_menu_baoming:
                if(tab_menu_baoming_text.isSelected()){
                    break;
                }else{
                    setSelected();
                    tab_menu_baoming_text.setSelected(true);
                    Baoming = new Fragment_baoming();
                    transaction.replace(R.id.fragment_contentview, Baoming);
                    break;
                }


            case R.id.tab_menu_jiakao:
                if (tab_menu_jiakao_text.isSelected()){
                    break;
                }else{
                    setSelected();
                    tab_menu_jiakao_text.setSelected(true);
                    Jiakao = new Fragment_test();
                    transaction.replace(R.id.fragment_contentview, Jiakao);
                    break;
                }


            case R.id.tab_menu_maiche:
                if(tab_menu_maiche_text.isSelected()){
                    break;
                }else{
                    setSelected();
                    tab_menu_maiche_text.setSelected(true);
                    Maiche = new Fragment_maiche();
                    transaction.replace(R.id.fragment_contentview, Maiche);
                    break;
                }


            case R.id.tab_menu_faxian:
                if(tab_menu_faxian_text.isSelected()){
                    break;
                }else{
                    setSelected();
                    tab_menu_faxian_text.setSelected(true);
                    Faxian = new Fragment__faxian();
                    transaction.replace(R.id.fragment_contentview, Faxian);
                    break;
                }


            case R.id.tab_menu_baibaoxiang:
                if(tab_menu_baibaoxiang_text.isSelected()){
                    break;
                }else{
                    setSelected();
                    tab_menu_baibaoxiang_text.setSelected(true);
                    Baibaoxiang = new Fragment_baibaoxiang();
                    transaction.replace(R.id.fragment_contentview, Baibaoxiang);
                    break;
                }


        }
        transaction.commit();

        //判断是否点击登录按钮，转到登录界面
        if (v.getId() == R.id.menu_login_image){
            Intent intent = new Intent(MainActivity.this, Login_Activity.class);
            startActivity(intent);
        }

    }

}
