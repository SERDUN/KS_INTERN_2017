package com.example.user.ks_intern_2017.screen.first.fragments.OkNotice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.screen.first.FirstActivity;
import com.example.user.ks_intern_2017.screen.first.FirstContract;
import com.example.user.ks_intern_2017.screen.first.fragments.DataEntry.DataEntryFragment;

public class OkNoticeFragment extends Fragment {
    private Button btnOk;
    public static final String DATA_ENTRY_FRAGMENT_KEY = OkNoticeFragment.class.getName().toString();
    static String TAG = "data_entry_fragment";

    public OkNoticeFragment() {
        // Required empty public constructor
    }

    public static OkNoticeFragment newInstance() {
        OkNoticeFragment fragment = new OkNoticeFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ok_notice, container, false);
        btnOk = (Button) view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v ->
                getActivity().getSupportFragmentManager().popBackStack());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((FirstContract.View) getActivity()).showDataEntryFragmentAndClean();

    }
}
