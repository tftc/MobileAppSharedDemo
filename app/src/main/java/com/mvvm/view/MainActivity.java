package com.mvvm.view;

import android.os.Bundle;

import com.mvc.model.User;
import com.mvvm.R;
import com.mvvm.viewmodel.UserViewModel;
import com.utils.Api;

public class MainActivity extends BaseActivity {
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel=new UserViewModel(this);
        initializeContentView(R.layout.mvvm_activity_main,userViewModel);
        initData();
    }

    private void initData() {
        Api api=new Api();
        User user = api.getUser();
        userViewModel.setUser(user);
    }
}
