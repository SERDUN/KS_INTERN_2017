package com.example.user.ks_intern_2017.screen.first;

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

    }

    @Override
    public void clearField() {

    }

    @Override
    public void sendTextFromField(String email) {
        if (email.isEmpty()) {
            view.showErrorMessage("field(email) is empty");
            return;
        }

        if (validationEmail(email)) {
            view.sendTextFromField();
        } else {
            view.showErrorMessage("incorrect email");

        }
    }

    private boolean validationEmail(String email) {
        //// TODO: 14.07.2017 rewrite the algorithm validation
        if (email.contains("@")) {
            if (email.contains(".")) {
                return true;
            }
        }
        return false;

    }

}
