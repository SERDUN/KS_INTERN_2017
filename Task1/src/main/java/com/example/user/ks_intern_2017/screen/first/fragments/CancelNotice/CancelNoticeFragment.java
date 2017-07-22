package com.example.user.ks_intern_2017.screen.first.fragments.CancelNotice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.screen.first.FirstContract;
import com.example.user.ks_intern_2017.screen.first.fragments.OkNotice.OkNoticeFragment;

public class CancelNoticeFragment extends Fragment {

    private Button btnOk;
    public static final String DATA_ENTRY_FRAGMENT_KEY = OkNoticeFragment.class.getName().toString();

    public CancelNoticeFragment() {
        // Required empty public constructor
    }


    public static CancelNoticeFragment newInstance() {
        CancelNoticeFragment fragment = new CancelNoticeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cancel_notice, container, false);

        btnOk = (Button) view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v ->
            getActivity().getSupportFragmentManager().popBackStack()

        );
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ((FirstContract.View)getActivity()).showDataEntryFragment();

    }
}
