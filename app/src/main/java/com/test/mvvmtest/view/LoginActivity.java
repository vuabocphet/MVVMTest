package com.test.mvvmtest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.test.mvvmtest.R;
import com.test.mvvmtest.databinding.ActivityMainBinding;
import com.test.mvvmtest.viewmodel.LoginViewModel;
import com.test.mvvmtest.viewmodel.MyHandler;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);
        MyHandler handlers = new MyHandler();
        binding.setHandler(handlers);
        binding.setLoginViewModel(new LoginViewModel(this));
    }
}