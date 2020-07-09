package com.test.mvvmtest.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;

import com.test.mvvmtest.model.User;

public class LoginViewModel extends BaseObservable {

    private User user = User.init();

    private SharedPreferences preferences;

    @SuppressLint("CommitPrefEdits")
    public LoginViewModel(Context context) {
        this.preferences = context.getSharedPreferences("test", Context.MODE_PRIVATE);
        this.user.setEmail(this.preferences.getString("email", "")).setPassword(this.preferences.getString("password", ""));
    }

    public String getEmail() {
        return this.isEmpty(user.email);
    }

    public String getPassWord() {
        return this.isEmpty(user.password);
    }

    private String isEmpty(String txt) {
        return TextUtils.isEmpty(txt) ? "" : txt;
    }

    public boolean isCheck() {
        return this.preferences.getBoolean("checkbox", false);
    }


}
