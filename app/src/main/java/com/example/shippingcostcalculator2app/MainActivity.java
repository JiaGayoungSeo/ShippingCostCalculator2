package com.example.shippingcostcalculator2app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // -- Display inforamtion --
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        if(width>height){
             Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(R.id.frame,fragment2);
        }else{
            Fragment1 fragment1= new Fragment1();
            fragmentTransaction.replace(R.id.frame,fragment1);
        }
        fragmentTransaction.commit();

        setContentView(R.layout.activity_main);
    }
}
