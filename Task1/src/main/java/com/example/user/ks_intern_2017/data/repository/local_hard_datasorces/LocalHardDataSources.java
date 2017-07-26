package com.example.user.ks_intern_2017.data.repository.local_hard_datasorces;

import android.support.annotation.NonNull;

import com.example.user.ks_intern_2017.data.model.User;
import com.example.user.ks_intern_2017.data.plug.UsersPlug;
import com.example.user.ks_intern_2017.data.repository.UserDataSource;

/**
 * Created by User on 23.07.2017.
 */

public class LocalHardDataSources implements UserDataSource {

    private static LocalHardDataSources INSTANCE;


    private UsersPlug usersPlug;

    public LocalHardDataSources() {
        usersPlug = new UsersPlug(20);
    }

    public static LocalHardDataSources getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalHardDataSources();
        }
        return INSTANCE;
    }

    @Override
    public void getUsers(@NonNull LoadUsersCallback callback) {
        callback.onUserLoaded(usersPlug.getUsers());
    }

    @Override
    public void getUserById(@NonNull String id, @NonNull GetUserCallback callback) {

    }

    @Override
    public void getUserByUsername(@NonNull String username, @NonNull GetUserCallback callback) {

    }

    @Override
    public void getUsersByCategory(@NonNull User.Category category, @NonNull LoadUsersCallback callback) {

    }

    @Override
    public void getUsersByStatusConnection(@NonNull boolean isConnection, @NonNull LoadUsersCallback callback) {

    }
}
