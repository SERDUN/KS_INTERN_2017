package com.example.user.ks_intern_2017.screen.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.screen.second.SecondActivity;

public class FirstActivity extends AppCompatActivity implements FirstContract.View {

    public static final String EMAIL_KEY = "email";
    public static final int REQUEST_KODE = 1;

    private FirstPresenter firstPresenter;
    private Button btnSend;
    private EditText etEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstPresenter = new FirstPresenter(this);
        initialView();
    }

    private void initialView() {
        etEmail = (EditText) findViewById(R.id.et_email);
        CheckBox cbAccess = (CheckBox) findViewById(R.id.cb_access_send);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnSend.setEnabled(false);

        btnSend.setOnClickListener(view ->
                firstPresenter.sendTextFromField(etEmail.getText().toString())
        );
        Button btnClear=(Button)findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(v->firstPresenter.clearField());


        cbAccess.setOnCheckedChangeListener((view, checked) -> {
            if (view.getId() == R.id.cb_access_send) {
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
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EMAIL_KEY, etEmail.getText().toString());
        startActivityForResult(intent, REQUEST_KODE);
    }

    @Override
    public void showErrorMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) return;
        switch (requestCode) {
            case REQUEST_KODE:
                if (resultCode == RESULT_OK) {
                    firstPresenter.clearField();
                    Toast.makeText(this,getResources().getString(R.string.sending), Toast.LENGTH_SHORT).show();
                } else if (RESULT_CANCELED == resultCode) {
                    Toast.makeText(this, getResources().getString(R.string.user_canceled), Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }
}
