package com.example.user.ks_intern_2017.screen.first.fragments.DataEntry;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.screen.second.SecondActivity;


public class DataEntryFragment extends Fragment implements DataEntryContract.View {

    public static final String DATA_ENTRY_FRAGMENT_KEY = DataEntryFragment.class.getName().toString();


    static String TAG = "data_entry_fragment";

    private DataEntryPresenter firstPresenter;
    private Button btnSend;
    private EditText etEmail;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("counter", etEmail.getText().toString());

    }


    private OnFragmentInteractionListener mListener;

    public DataEntryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DataEntryFragment newInstance() {
        DataEntryFragment fragment = new DataEntryFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: " + TAG);

        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);
        firstPresenter = new DataEntryPresenter(this);
        initialView(view);
        if (savedInstanceState != null) {
            etEmail.setText(savedInstanceState.getString("counter", ""));


        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: " + TAG);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: " + TAG);

        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void openSecondActivity(String email);

    }

    private void initialView(View view) {
        etEmail = (EditText) view.findViewById(R.id.et_email);
        CheckBox cbAccess = (CheckBox) view.findViewById(R.id.cb_access_send);
        btnSend = (Button) view.findViewById(R.id.btn_send);
        btnSend.setEnabled(false);

        btnSend.setOnClickListener(v ->
                firstPresenter.sendTextFromField(etEmail.getText().toString())
        );
        Button btnClear = (Button) view.findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(v -> firstPresenter.clearField());


        cbAccess.setOnCheckedChangeListener((v, checked) -> {
            if (v.getId() == R.id.cb_access_send) {
                btnSend.setEnabled(checked);
            }

        });
    }

    @Override
    public void clearField() {
        etEmail.setText("");
    }


    @Override
    public void sendTextFromField() {
        mListener.openSecondActivity(etEmail.getText().toString());
    }

    @Override
    public void showErrorMessage(String msg) {
        Toast.makeText(getView().getContext(), msg, Toast.LENGTH_LONG).show();

    }


}
