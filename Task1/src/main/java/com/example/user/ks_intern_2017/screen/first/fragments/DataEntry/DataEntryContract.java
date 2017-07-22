package com.example.user.ks_intern_2017.screen.first.fragments.DataEntry;

import com.example.user.ks_intern_2017.BasePresenter;
import com.example.user.ks_intern_2017.BaseView;

/**
 * Created by User on 19.07.2017.
 */

public class DataEntryContract {
    public interface View extends BaseView {
        void clearField();

        void sendTextFromField();

        void showErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter {
        void clearField();

        void sendTextFromField(String string);
    }
}
