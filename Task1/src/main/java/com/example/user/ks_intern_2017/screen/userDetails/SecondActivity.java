package com.example.user.ks_intern_2017.screen.userDetails;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.ks_intern_2017.R;
import com.example.user.ks_intern_2017.data.model.User;
import com.example.user.ks_intern_2017.screen.userList.FirstActivity;

public class SecondActivity extends AppCompatActivity implements SecondContract.View {
    private CollapsingToolbarLayout mCollapsingToolbar;
    private Toolbar toolbar;
    private ImageView imageView;

    private SecondContract.Presenter secondPresenter;
    private TextView tvEmail;
    private TextView tvStatus;
    private TextView tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);
        new SecondPresenter(getBaseContext(), this, (User) getIntent().getSerializableExtra(FirstActivity.USER_KEY));
        initView();
        secondPresenter.init();
    }

    private void initView() {
        Button btnAccept = (Button) findViewById(R.id.btn_accept);
        btnAccept.setOnClickListener(v -> secondPresenter.sendMessage());
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(v -> secondPresenter.cancel());

        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc3);
//        Palette.from(bitmap).generate();
        imageView = (ImageView) findViewById(R.id.iv_avatar);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvStatus = (TextView) findViewById(R.id.tv_status);
        tvCategory = (TextView) findViewById(R.id.tv_category);


    }


    @Override
    public void initToolbarName(String name) {
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);

    }

    @Override
    public void initImageCategory(int id) {
        imageView.setImageResource(id);
    }

    @Override
    public void initEmailField(String content) {
        tvEmail.setText(content);
    }

    @Override
    public void initStatus(String string) {
        tvStatus.setText(string);
    }

    @Override
    public void initCategory(User.Category category) {
        tvCategory.setText(getResources().getString(R.string.category)+" "+category.toString());
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
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_email)));
        setResult(RESULT_OK, getIntent());
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("test1", "onDestroy: SecondActivity");
    }


    @Override
    public void setPresenter(SecondContract.Presenter presenter) {
        this.secondPresenter = presenter;
    }
}
