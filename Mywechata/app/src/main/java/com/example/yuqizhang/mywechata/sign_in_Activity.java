
package com.example.yuqizhang.mywechata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class sign_in_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    public void shiyongtiaokuan(View v){
        Intent intent = new Intent(sign_in_Activity.this,clause_Activity.class);
        startActivity(intent);
    }
}
