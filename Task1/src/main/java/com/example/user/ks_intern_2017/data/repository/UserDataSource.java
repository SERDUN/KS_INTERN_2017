package com.example.user.ks_intern_2017.data.repository;

import android.support.annotation.NonNull;

import com.example.user.ks_intern_2017.data.model.User;

import java.util.List;

/**
 * Created by User on 23.07.2017.
 */

public interface UserDataSource {

    interface LoadUsersCallback {

        public void onUserLoaded(List<User> tasks);

        public void onDataNotAvailable();
    }

    interface GetUserCallback {

        public void onUserLoaded(User task);

        public void onDataNotAvailable();
    }

    void getUsers(@NonNull LoadUsersCallback callback);

    void getUserById(@NonNull String id, @NonNull GetUserCallback callback);

    void getUserByUsername(@NonNull String username, @NonNull GetUserCallback callback);

    void getUsersByCategory(@NonNull User.Category category, @NonNull LoadUsersCallback callback);

    void getUsersByStatusConnection(@NonNull boolean isConnection, @NonNull LoadUsersCallback callback);

}
