package com.example.frgmentustmaust.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.frgmentustmaust.R;

public class MainActivity extends AppCompatActivity {
//TextView tv_home;

static final String TAG = MainActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    void initView(){
      //  tv_home = findViewById(R.id.tv_home);
        Button b_detail = findViewById(R.id.b_detail);
        b_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackStackActivity();
            }
        });
    }


    void openBackStackActivity() {
        Intent intent = new Intent(this, BackStackActivity.class);
        startActivity(intent);
    }
}