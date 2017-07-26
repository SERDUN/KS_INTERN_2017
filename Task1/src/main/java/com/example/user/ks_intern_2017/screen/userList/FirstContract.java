package com.example.user.ks_intern_2017.screen.userList;

import com.example.user.ks_intern_2017.BasePresenter;
import com.example.user.ks_intern_2017.BaseView;
import com.example.user.ks_intern_2017.data.model.User;

/**
 * Created by User on 14.07.2017.
 */

public class FirstContract {
    public interface View extends BaseView<FirstContract.Presenter> {
        public void openSecondActivity(User user);

        public void showOkNoticeFragment();

        public void showCancelNoticeFragment();

        public void showUserListFragment();


    }

    public interface Presenter extends BasePresenter {
        public void showOkNoticeFragment();

        public void showCancelNoticeFragment();

        public void showUserListFragment();


    }
}
