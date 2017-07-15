package com.example.user.ks_intern_2017.screen.second;

import com.example.user.ks_intern_2017.BasePresenter;
import com.example.user.ks_intern_2017.BaseView;
import com.example.user.ks_intern_2017.screen.first.FirstContract;

/**
 * Created by User on 14.07.2017.
 */

public class SecondContract {
    interface View extends BaseView {
        void initEmailField(String content);
        void showErrorMessage(String message);
        void closeActivity();
        void startSendIntent(String email);
    }

    interface Presenter extends BasePresenter {
        public void initEmail(String string);
        public void sendMessage();
        public void cancel();

    }
}
