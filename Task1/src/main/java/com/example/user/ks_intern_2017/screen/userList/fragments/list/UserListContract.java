package com.example.user.ks_intern_2017.screen.userList.fragments.list;

import com.example.user.ks_intern_2017.BasePresenter;
import com.example.user.ks_intern_2017.BaseView;
import com.example.user.ks_intern_2017.data.model.User;

import java.util.List;

/**
 * Created by User on 19.07.2017.
 */

public class UserListContract {
    public interface View extends BaseView<Presenter> {

        public void openDetailActivity(User user);

    }

    public interface Presenter extends BasePresenter {

        interface Callback<T>{
            public void call(T t);
        }

        public void getUsers(Callback<List<User>> users);


        public void openDetailActivity(User user);


    }
}
