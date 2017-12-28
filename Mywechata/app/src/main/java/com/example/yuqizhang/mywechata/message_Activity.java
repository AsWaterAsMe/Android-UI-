package com.example.yuqizhang.mywechata;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class message_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {


    //-----------------------------从这开始是复制的-------------------
    private ImageView mBt1, mBt2, mBt3, mBt4;//声明底部四个图片
    private ImageView mSelBg;  //声明一个背景的控件
    private LinearLayout mTab_item_container;//
    private FragmentManager mFM = null;//

    LinearLayout content_container, content_container2;//两个上部布局文件

    Intent m_Intent;//

    //-----------------------------从这开始是复制的-------------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //-------------------------从这开始是复制的-------------------------------

        //找到四个按钮的控件和包含四个按钮的LinearLayout
        mTab_item_container = (LinearLayout) findViewById(R.id.tab_item_container);
        mBt1 = (ImageView) findViewById(R.id.tab_bt_1);
        mBt2 = (ImageView) findViewById(R.id.tab_bt_2);
        mBt3 = (ImageView) findViewById(R.id.tab_bt_3);
        mBt4 = (ImageView) findViewById(R.id.tab_bt_4);
        //初始化四个按钮的监听
        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
        mBt3.setOnClickListener(this);
        mBt4.setOnClickListener(this);
        //背景的控件
        mSelBg = (ImageView) findViewById(R.id.tab_bg_view);
        //每个所占的位置
        ViewGroup.LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 4;
        //控件
        content_container = (LinearLayout) findViewById(R.id.content_container);//这个是上面的布局
        content_container2 = (LinearLayout) findViewById(R.id.content_container2);//这个也是上面的布局



    }



    //获取手机屏幕的高度和宽度
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ViewGroup.LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 4;
    }

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
        getMenuInflater().inflate(R.menu.message_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){

            case R.id.action_chat:
                Intent intent = new Intent(message_Activity.this,chat_group_Activity.class);
                startActivity(intent);
//                Toast.makeText(this,"发起群聊",Toast.LENGTH_SHORT).show();

                break;
            case R.id.action_add:
//                Toast.makeText(this,"添加好友",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(message_Activity.this,add_friend_Activity.class);
                startActivity(intent2);
                break;
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


    //----------------------------------------------
    //从这开始是复制的



    //这个也不明白是什么意思2
    private void startAnimation(View last, View now) {
        TranslateAnimation ta = new TranslateAnimation(last.getLeft(), now.getLeft(), 0, 0);
        ta.setDuration(300);
        ta.setFillAfter(true);
        mSelBg.startAnimation(ta);
    }


    private int mSelectIndex = 0;
    private View last, now;
    View v1, v2;
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_bt_1:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(0);
                startAnimation(last, now);
                mSelectIndex = 0;

                //changePerson();
                /**
                 * 切换fragement
                 */

                Fragment f = new Person_fragment();
                if (null == mFM)
                    mFM = getSupportFragmentManager();
                FragmentTransaction ft = mFM.beginTransaction();
                ft.replace(R.id.content_container, f);
                ft.commit();

                break;
            case R.id.tab_bt_2:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(1);
                startAnimation(last, now);
                mSelectIndex = 1;

                //changeEntrepreneue();
                /**
                 * 切换fragement
                 */

                Fragment f2 = new Entrepreneur_fragment();
                if (null == mFM)
                    mFM = getSupportFragmentManager();
                FragmentTransaction ft2 = mFM.beginTransaction();
                ft2.replace(R.id.content_container, f2);
                ft2.commit();

                break;
            case R.id.tab_bt_3:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(2);
                startAnimation(last, now);
                mSelectIndex = 2;

                //changeMessage();
                /**
                 * 切换fragement
                 */

                Fragment f3 = new Message_fragment();
                if (null == mFM)
                    mFM = getSupportFragmentManager();
                FragmentTransaction ft3 = mFM.beginTransaction();
                ft3.replace(R.id.content_container, f3);
                ft3.commit();

                break;
            case R.id.tab_bt_4:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(3);
                startAnimation(last, now);
                mSelectIndex = 3;

                //changeSetting();
                /**
                 * 切换fragement
                 */

                Fragment f4 = new Setting_fragment();
                if (null == mFM)
                    mFM = getSupportFragmentManager();
                FragmentTransaction ft4 = mFM.beginTransaction();
                ft4.replace(R.id.content_container, f4);
                ft4.commit();

                break;
            default:
                break;
        }
    }



}
