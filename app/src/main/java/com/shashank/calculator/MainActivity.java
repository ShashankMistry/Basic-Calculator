package com.shashank.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    pageAdapter pageAdapter;
    Button btnEqual;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        //Get rid of ActionBar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        pageAdapter = new pageAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(pageAdapter);
        getSupportFragmentManager().beginTransaction().add(R.id.viewPager, new CalculatorFragment()).add(R.id.viewPager,new HistoryFragment()).commit();
    }
}