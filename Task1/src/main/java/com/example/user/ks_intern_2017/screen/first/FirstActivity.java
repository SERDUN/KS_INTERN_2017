package com.example.user.ks_intern_2017.screen.first;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.screen.first.fragments.CancelNotice.CancelNoticeFragment;
import com.example.user.ks_intern_2017.screen.first.fragments.DataEntry.DataEntryContract;
import com.example.user.ks_intern_2017.screen.first.fragments.DataEntry.DataEntryFragment;
import com.example.user.ks_intern_2017.screen.first.fragments.OkNotice.OkNoticeFragment;
import com.example.user.ks_intern_2017.screen.second.SecondActivity;

public class FirstActivity extends AppCompatActivity implements FirstContract.View, DataEntryFragment.OnFragmentInteractionListener {

    static String TAG = "main_Activity";


    public static final String EMAIL_KEY = "email";
    public static final int REQUEST_KODE = 1;
    public static final String TRANSACTION_KEY = "notice";


    public Fragment[] fragments = new Fragment[3];
    private FirstPresenter firstPresenter;

    private CurrentFragmentEnum currentFragmentEnum = CurrentFragmentEnum.DataEntry;


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
                firstPresenter.showDataEntryFragment();
                break;
            case CancelNotice:
                currentFragmentEnum = CurrentFragmentEnum.DataEntry;
                firstPresenter.showCancelNoticeFragment();
                break;
            case OkNotice:
                ((DataEntryContract.View) fragments[0]).clearField();
                currentFragmentEnum = CurrentFragmentEnum.DataEntry;
                firstPresenter.showOkNoticeFragment();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstPresenter = new FirstPresenter(this);
        init();
    }

    private void init() {
        fragments[0] = new DataEntryFragment();
        fragments[1] = new OkNoticeFragment();
        fragments[2] = CancelNoticeFragment.newInstance();
        firstPresenter.init();

    }

    @Override
    public void showOkNoticeFragment() {
        addFragment(fragments[1], OkNoticeFragment.DATA_ENTRY_FRAGMENT_KEY);

    }

    @Override
    public void showCancelNoticeFragment() {
        addFragment(fragments[2], CancelNoticeFragment.DATA_ENTRY_FRAGMENT_KEY);

    }

    @Override
    public void showDataEntryFragment() {
        addFragment(fragments[0], DataEntryFragment.DATA_ENTRY_FRAGMENT_KEY);
    }

    @Override
    public void showDataEntryFragmentAndClean() {
        addFragment(fragments[0], DataEntryFragment.DATA_ENTRY_FRAGMENT_KEY);
//        ((DataEntryContract.View) fragments[0]).clearField();

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
    public void openSecondActivity(String email) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EMAIL_KEY, email);
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
