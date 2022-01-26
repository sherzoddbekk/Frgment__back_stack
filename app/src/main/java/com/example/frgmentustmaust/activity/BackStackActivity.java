package com.example.frgmentustmaust.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.frgmentustmaust.R;
import com.example.frgmentustmaust.fragment.PageOneFragment;
import com.example.frgmentustmaust.fragment.PageTreeFragment;
import com.example.frgmentustmaust.fragment.PageTwoFragment;

public class BackStackActivity extends AppCompatActivity {

    static final  String TAG = BackStackActivity.class.toString();
    Button btn_third,btn_first,btn_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backstack);

        initView();

      //  StaticFragment fragment = StaticFragment.newInstance("Pdp");
    }
    void  initView(){
        btn_first = findViewById(R.id.btn_first);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PageOneFragment());
            }
        });

        btn_second = findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PageTwoFragment());
            }
        });
        btn_third = findViewById(R.id.btn_third);
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PageTreeFragment());
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName,0);

        if (!fragmentPopped){
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.framelayout,fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }

    }
    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
