package com.mvc.controller;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.mvc.model.User;
import com.mvvm.R;
import com.utils.Api;
import com.utils.glide.GlideUtils;

public class MainActivity extends AppCompatActivity {
    private TextView tv_lastname;
    private TextView tv_firstname;
    private TextView tv_sex;
    private TextView tv_age;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvc_activity_main);
        initView();
        initData();
    }

    private void initData() {
        User user =  new Api().getUser();
        tv_lastname.setText(user.getLastname());
        tv_firstname.setText(user.getFirstname());
        tv_sex.setText(user.getSex());
        tv_age.setText(user.getAge() + "");
        GlideUtils.getInstance().loadImage(this,iv,user.getUrl());
    }

    private void initView() {
        tv_lastname= (TextView) findViewById(R.id.tv_lastname);
        tv_firstname= (TextView) findViewById(R.id.tv_firstname);
        tv_sex= (TextView) findViewById(R.id.tv_sex);
        tv_age= (TextView) findViewById(R.id.tv_age);
        iv= (ImageView) findViewById(R.id.iv);
    }
}
