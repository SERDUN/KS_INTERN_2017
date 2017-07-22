package com.example.user.ks_intern_2017.screen.first;

import com.example.user.ks_intern_2017.BasePresenter;
import com.example.user.ks_intern_2017.BaseView;

/**
 * Created by User on 14.07.2017.
 */

public class FirstContract {
    public interface View extends BaseView {
        public void showOkNoticeFragment();

        public void showCancelNoticeFragment();

        public void showDataEntryFragment();

        public void showDataEntryFragmentAndClean();

    }

    public interface Presenter extends BasePresenter {
        public void showOkNoticeFragment();

        public void showCancelNoticeFragment();

        public void showDataEntryFragment();



    }
}
