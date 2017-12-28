package com.example.yuqizhang.mywechata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;




//------------------注释-----------------//
//整个程序的开始类，程序从这个类开始
//这是第一个登录界面
//
//
//------------------注释-----------------//



public class login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void denglu(View v){
        Intent intent = new Intent(login_Activity.this,message_Activity.class);
        startActivity(intent);
    }

    public void zhuce(View v){
        Intent intent = new Intent(login_Activity.this,sign_in_Activity.class);
        startActivity(intent);
    }

    public void zhaohui(View v){
        Intent intent = new Intent(login_Activity.this,forgit_Activity.class);
        startActivity(intent);
    }

}
