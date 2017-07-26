package com.example.user.ks_intern_2017.screen.userDetails;

import android.content.Context;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.data.model.User;

/**
 * Created by User on 14.07.2017.
 */

public class SecondPresenter implements SecondContract.Presenter {
    private SecondContract.View view;
    private User user;
    private Context context;

    public SecondPresenter(Context context,SecondContract.View view, User user) {
        this.view = view;
        this.user = user;
        this.context=context;
        view.setPresenter(this);

    }

    @Override
    public void init() {
        view.initToolbarName(user.getUsername());
        view.initEmailField(user.getUserAddress());
        switch (user.getCategory()) {
            case FAMILY:
                view.initImageCategory(R.drawable.family);
                break;
            case FRIENDS:
                view.initImageCategory(R.drawable.friends);
                break;
            case OTHER:
                view.initImageCategory(R.drawable.other);
                break;
            case WORK:
                view.initImageCategory(R.drawable.work);
                break;
        }
        if (user.isOnline()) {
            view.initStatus(context.getString(R.string.online));
        } else {
            view.initStatus(context.getString(R.string.not_online));

        }
        view.initCategory(user.getCategory());
    }


    @Override
    public void sendMessage() {
        view.startSendIntent(user.getUserAddress());
    }

    @Override
    public void cancel() {
        view.closeActivity();
    }
}
