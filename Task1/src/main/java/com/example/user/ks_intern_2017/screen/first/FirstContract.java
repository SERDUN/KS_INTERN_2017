package com.example.user.ks_intern_2017.screen.first;

import com.example.user.ks_intern_2017.BasePresenter;
import com.example.user.ks_intern_2017.BaseView;

/**
 * Created by User on 14.07.2017.
 */

public class FirstContract {
    interface View extends BaseView{
        void clearField();

        void sendTextFromField();

        void showErrorMessage(String message);
    }

    interface Presenter extends BasePresenter {
        void clearField();

        void sendTextFromField(String string);
    }
}
