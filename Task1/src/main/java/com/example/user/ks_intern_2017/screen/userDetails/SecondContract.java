package com.example.user.ks_intern_2017.screen.userDetails;

import com.example.user.ks_intern_2017.BasePresenter;
import com.example.user.ks_intern_2017.BaseView;
import com.example.user.ks_intern_2017.data.model.User;

/**
 * Created by User on 14.07.2017.
 */

public class SecondContract {
    interface View extends BaseView<Presenter> {

        void initToolbarName(String name);
        void initImageCategory(int id);
        void initEmailField(String content);
        void initStatus(String string);
        void initCategory(User.Category category);
        void showErrorMessage(String message);
        void closeActivity();
        void startSendIntent(String email);
    }

    interface Presenter extends BasePresenter {
        public void sendMessage();
        public void cancel();

    }
}
