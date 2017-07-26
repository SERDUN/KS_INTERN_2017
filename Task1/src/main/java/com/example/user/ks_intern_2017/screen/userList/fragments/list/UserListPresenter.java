package com.example.user.ks_intern_2017.screen.userList.fragments.list;

import android.support.annotation.NonNull;

import com.example.user.ks_intern_2017.data.model.User;
import com.example.user.ks_intern_2017.data.repository.UserDataSource;
import com.example.user.ks_intern_2017.data.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by User on 19.07.2017.
 */

public class UserListPresenter implements UserListContract.Presenter {
    private UserListContract.View view;
    private UserRepository userRepository;


    public UserListPresenter(@NonNull UserRepository userRepository, UserListContract.View view) {
        this.view = view;
        this.userRepository = userRepository;
        view.setPresenter(this);
    }

    @Override
    public void init() {

    }


    @Override
    public void getUsers(Callback<List<User>> users) {
        userRepository.getUsers(new UserDataSource.LoadUsersCallback() {
            @Override
            public void onUserLoaded(List<User> tasks) {

                Collections.sort(tasks, new UserClassComparator());
                users.call(tasks);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void openDetailActivity(User user) {
        view.openDetailActivity(user);

    }

    public class UserClassComparator implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return o1.getUsername().compareTo(o2.getUsername());
        }
    }
}
