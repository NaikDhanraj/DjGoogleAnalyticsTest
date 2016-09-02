package com.dssp.djgoogleanalyticstest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dssp.djgoogleanalyticstest.app.MyApplication;

/**
 * Created by dhanrajnaik522 on 8/31/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private Context context = SecondActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * Manual screen tracking (to track activity view manually)
         */
        MyApplication.getmInstance().trackScreenView("Second Screen");
    }
}
