package com.example.user.ks_intern_2017.screen.first;

import android.util.Log;

import com.example.user.ks_intern_2017.BaseView;

/**
 * Created by User on 14.07.2017.
 */

public class FirstPresenter implements FirstContract.Presenter {
    FirstContract.View view;

    public FirstPresenter(FirstContract.View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.showDataEntryFragment();

    }


    @Override
    public void showOkNoticeFragment() {
        view.showOkNoticeFragment();

        Log.d("presenter", "showOkNoticeFragment: presenter");


    }

    @Override
    public void showCancelNoticeFragment() {
        view.showCancelNoticeFragment();

    }

    @Override
    public void showDataEntryFragment() {
        view.showDataEntryFragment();
        Log.d("presenter", "showDataEntryFragment: presenter");


    }
}
