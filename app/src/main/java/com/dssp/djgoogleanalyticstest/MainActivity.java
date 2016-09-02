package com.dssp.djgoogleanalyticstest;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dssp.djgoogleanalyticstest.app.MyApplication;
import com.dssp.djgoogleanalyticstest.fragment.FooterFragment;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Context context = MainActivity.this;

    private Toolbar mToolbar;
    private Button btnSecondScreen, btnSendEvent, btnException, btnAppCrash, btnLoadFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        btnSecondScreen = (Button) findViewById(R.id.btnSecondScreen);
        btnSendEvent = (Button) findViewById(R.id.btnSendEvent);
        btnException = (Button) findViewById(R.id.btnException);
        btnAppCrash = (Button) findViewById(R.id.btnAppCrash);
        btnLoadFragment = (Button) findViewById(R.id.btnLoadFragment);

        //  setSupportActionBar(mToolbar);
        //  getSupportActionBar().setDisplayShowHomeEnabled(true);

        /**
         * Launching another activity to track the other screen
         */
        btnSecondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SecondActivity.class);
                startActivity(intent);
            }
        });


        /**
         * Tracking fragment view
         */
        btnLoadFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FooterFragment footerFragment = new FooterFragment();
                fragmentTransaction.replace(R.id.frame_container, footerFragment);
                fragmentTransaction.commit();
            }
        });


        /**
         * tracking event
         * EVENT(CATEGORY,ACTION,LABEL)
         * Event tracking accepts four parameters. Category, Action, Label and Value
         */
        btnSendEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tracking an event
                //simple event example when user presses the book download button.
                MyApplication.getmInstance().trackEvent("Book", "Download", "Track event example");

                Toast.makeText(getApplicationContext(), "Event \'Book\' \'Download\' \'Event example\' is sent. Check it on Google Analytics Dashboard!", Toast.LENGTH_LONG).show();
            }
        });


        /**
         * TRACK ALL THE KNOWN EXCEPTIONS USING TRY AND CATCH
         * tracking exception manually
         * All known exceptions can be tracked this way
         * using try and catch
         */
        btnException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String name = null;

                    if (name.equals("dhanraj")) {
                        /**
                         * never comes here as it will through null pointer exception
                         */

                    }


                } catch (Exception e) {
                    e.printStackTrace();

                    /**
                     * tracking exception
                     */
                    MyApplication.getmInstance().trackException(e);

                    Log.e(LOG_TAG,"Exception : "+e.getMessage());
                    Toast.makeText(MainActivity.this, ""+getString(R.string.toast_track_exception), Toast.LENGTH_SHORT).show();
                }
            }
        });


        /**
         * tracking app crash
         * Manually crashing the app by dividing with zero
         */
        btnAppCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                //Here we are dividing a number with zero which throws Arithmetic Exception and crashes the app.

                Toast.makeText(MainActivity.this, ""+getString(R.string.toast_app_crash), Toast.LENGTH_SHORT).show();

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        int answer = 12/0;
                    }
                };

                Handler h = new Handler();
                h.postDelayed(r,2000);//runnable|delay

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * Manual screen tracking (to track activity view manually)
         */
        MyApplication.getmInstance().trackScreenView("Home Screen");
    }
}
