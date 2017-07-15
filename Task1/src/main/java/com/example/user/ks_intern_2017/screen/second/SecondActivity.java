package com.example.user.ks_intern_2017.screen.second;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.screen.first.FirstActivity;

public class SecondActivity extends AppCompatActivity implements SecondContract.View {

    private SecondPresenter secondPresenter;
    private TextView tvEmail;
    private Button btnAccept;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);
        initView();
        secondPresenter = new SecondPresenter(this);
        secondPresenter.initEmail(getIntent().getStringExtra(FirstActivity.EMAIL_KEY));
    }

    private void initView() {
        tvEmail = (TextView) findViewById(R.id.et_email);
        btnAccept = (Button) findViewById(R.id.btn_accept);
        btnAccept.setOnClickListener(v -> secondPresenter.sendMessage());
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(v -> secondPresenter.cancel());
    }


    @Override
    public void initEmailField(String content) {
        tvEmail.setText(content);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void closeActivity() {
        setResult(RESULT_CANCELED, getIntent());
        finish();
    }

    @Override
    public void startSendIntent(String email) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        startActivity(Intent.createChooser(intent, "Send Email"));
        setResult(RESULT_OK, getIntent());
        finish();
    }


}
