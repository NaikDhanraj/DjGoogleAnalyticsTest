package com.dssp.djgoogleanalyticstest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dssp.djgoogleanalyticstest.R;
import com.dssp.djgoogleanalyticstest.app.MyApplication;

/**
 * Created by dhanrajnaik522 on 8/31/2016.
 */
public class FooterFragment extends Fragment {

    public FooterFragment() {
        //require empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        //inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_footer,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        /**
         * tracking the screen view
         */
        MyApplication.getmInstance().trackScreenView("Footer Fragment");
    }
}
