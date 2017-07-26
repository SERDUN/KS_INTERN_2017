package com.example.user.ks_intern_2017.screen.userList;

/**
 * Created by User on 14.07.2017.
 */

public class FirstPresenter implements FirstContract.Presenter {
    FirstContract.View view;

    public FirstPresenter(FirstContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }


    @Override
    public void init() {

    }

    @Override
    public void showOkNoticeFragment() {
        view.showOkNoticeFragment();
    }

    @Override
    public void showCancelNoticeFragment() {
        view.showCancelNoticeFragment();
    }

    @Override
    public void showUserListFragment() {
        view.showUserListFragment();
    }
}
