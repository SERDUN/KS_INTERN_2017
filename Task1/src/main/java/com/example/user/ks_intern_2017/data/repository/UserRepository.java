package com.example.user.ks_intern_2017.data.repository;

import android.support.annotation.NonNull;

import com.example.user.ks_intern_2017.data.model.User;
import com.example.user.ks_intern_2017.data.repository.local_hard_datasorces.LocalHardDataSources;

import java.util.List;

/**
 * Created by User on 23.07.2017.
 */

public class UserRepository implements UserDataSource {

    private final LocalHardDataSources localHardDataSources;

    private static UserRepository INSTANCE = null;


    private UserRepository(@NonNull LocalHardDataSources localHardDataSources) {
        this.localHardDataSources = localHardDataSources;
    }


    public static UserRepository getInstance(LocalHardDataSources localHardDataSources) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(localHardDataSources);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getUsers(@NonNull LoadUsersCallback callback) {

        localHardDataSources.getUsers(new LoadUsersCallback() {
            @Override
            public void onUserLoaded(List<User> tasks) {
                callback.onUserLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });


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
