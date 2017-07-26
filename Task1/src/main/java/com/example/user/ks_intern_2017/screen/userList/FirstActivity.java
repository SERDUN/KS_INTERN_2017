package com.example.user.ks_intern_2017.screen.userList;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import com.example.user.ks_intern_2017.R;

import com.example.user.ks_intern_2017.data.model.User;
import com.example.user.ks_intern_2017.screen.userDetails.SecondActivity;
import com.example.user.ks_intern_2017.screen.userList.fragments.CancelNotice.CancelNoticeFragment;
import com.example.user.ks_intern_2017.screen.userList.fragments.OkNotice.OkNoticeFragment;
import com.example.user.ks_intern_2017.screen.userList.fragments.list.UserListFragment;

public class FirstActivity extends AppCompatActivity implements FirstContract.View {

    static String TAG = "main_Activity";


    public static final String USER_KEY = "user_key";
    private static final int REQUEST_KODE = 1;
    public static final String TRANSACTION_KEY = "notice";


    public Fragment[] fragments = new Fragment[3];
    private FirstContract.Presenter firstPresenter;

    private CurrentFragmentEnum currentFragmentEnum = CurrentFragmentEnum.DataEntry;

    @Override
    public void setPresenter(FirstContract.Presenter presenter) {
        this.firstPresenter = presenter;
    }


    private enum CurrentFragmentEnum {
        DataEntry,
        CancelNotice,
        OkNotice
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity");

        switch (currentFragmentEnum) {
            case DataEntry:
                firstPresenter.showUserListFragment();
                break;
            case CancelNotice:
                currentFragmentEnum = CurrentFragmentEnum.DataEntry;
                firstPresenter.showCancelNoticeFragment();
                break;
            case OkNotice:
                currentFragmentEnum = CurrentFragmentEnum.DataEntry;
                firstPresenter.showOkNoticeFragment();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FirstPresenter(this);
        init();
    }

    private void init() {
        fragments[0] = UserListFragment.newInstance();
        fragments[1] = OkNoticeFragment.newInstance();
        fragments[2] = CancelNoticeFragment.newInstance();
        firstPresenter.init();

    }

    @Override
    public void showOkNoticeFragment() {
        addFragment(fragments[1], OkNoticeFragment.OK_NOTICE_FRAGMENT_KEY);

    }

    @Override
    public void showCancelNoticeFragment() {
        addFragment(fragments[2], OkNoticeFragment.OK_NOTICE_FRAGMENT_KEY);

    }

    @Override
    public void showUserListFragment() {
        addFragment(fragments[0], UserListFragment.USER_LIST_FRAGMENT_KEY);
    }


    private void addFragment(Fragment fragment, String fragmentKey) {
        if (getSupportFragmentManager().findFragmentByTag(fragmentKey) == null) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_in_right, R.anim.exit_to_left, R.anim.exit_to_right)
                    .add(R.id.containerFragment, fragment, fragmentKey)
                    .addToBackStack(TRANSACTION_KEY)

                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (fragments == 1) {
            finish();
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 1) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void openSecondActivity(User user) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(USER_KEY, user);
        startActivityForResult(intent, REQUEST_KODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: Activity");
        if (data == null) return;
        switch (requestCode) {
            case REQUEST_KODE:
                if (resultCode == RESULT_OK) {
                    currentFragmentEnum = CurrentFragmentEnum.OkNotice;
                } else if (RESULT_CANCELED == resultCode) {
                    currentFragmentEnum = CurrentFragmentEnum.CancelNotice;
                }
                break;
        }
    }


}
