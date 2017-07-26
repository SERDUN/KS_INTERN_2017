package com.example.user.ks_intern_2017.screen.userList.fragments.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.data.model.User;
import com.example.user.ks_intern_2017.data.repository.UserRepository;
import com.example.user.ks_intern_2017.data.repository.local_hard_datasorces.LocalHardDataSources;
import com.example.user.ks_intern_2017.screen.userList.FirstContract;
import com.example.user.ks_intern_2017.screen.userList.fragments.CancelNotice.CancelNoticeFragment;

import java.util.ArrayList;


public class UserListFragment extends Fragment implements UserListContract.View {

    public static final String USER_LIST_FRAGMENT_KEY = CancelNoticeFragment.class.getName().toString();

    public RecyclerView recyclerView;


    private UserListContract.Presenter userListPresenter;
    private UserListAdapter userListAdapter;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    public UserListFragment() {
    }

    public static UserListFragment newInstance() {
        UserListFragment fragment = new UserListFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);
        new UserListPresenter(UserRepository.getInstance(LocalHardDataSources.getInstance()), this);

        initialView(view);

        return view;
    }

    @Override
    public void setPresenter(UserListContract.Presenter presenter) {
        this.userListPresenter = presenter;
    }

    @Override
    public void openDetailActivity(User user) {
        ((FirstContract.View)getActivity()).openSecondActivity(user);

    }


    private void initialView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_user_list);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        userListPresenter.getUsers(users -> {
            userListAdapter = new UserListAdapter((ArrayList<User>) users, (v, position) -> {
                userListPresenter.openDetailActivity(userListAdapter.getItem(position));
            });
            recyclerView.setAdapter(userListAdapter);

        });
    }


}


