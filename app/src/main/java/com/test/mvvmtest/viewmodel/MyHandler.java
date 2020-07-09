package com.test.mvvmtest.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.test.mvvmtest.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyHandler {

    private boolean isCheck = false;

    public void afterUserCheckBoxChange(CompoundButton button, boolean isCheck) {
        this.isCheck = isCheck;
        Log.d("isCheck", "onCheckedChange: " + isCheck);
    }

    @SuppressLint("CommitPrefEdits")
    public void onClickLogin(View view, String email, String password) {
        Context context = view.getContext();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            showToast(context, "Không được để trống");
            return;
        }
        if (password.length() < 7) {
            showToast(context, "Độ dài mật khẩu phải lớn hơn 6 kí tự");
            return;
        }

        if (!this.matches(password)) {
            showToast(context, "Mật khẩu phải chứa  1 kí tự đặc biệt");
            return;
        }

        if (!this.containsDigit(password)) {
            showToast(context, "Mật khẩu phải chứa ít nhất 1 số");
            return;
        }
        showToast(context, "Đăng nhập thành công");
        SharedPreferences.Editor editor = context.getSharedPreferences("test", Context.MODE_PRIVATE).edit();
        editor.putBoolean("checkbox", isCheck);
        if (this.isCheck) {
            editor.putString("email", email);
            editor.putString("password", password);
            editor.apply();
            return;
        }
        editor.putString("email", "");
        editor.putString("password", "");
        editor.apply();
    }

    private void showToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }


    private boolean matches(String msg) {
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(msg);
        return hasSpecial.find();
    }

    private boolean containsDigit(String msg) {
        String regex = "(.)*(\\d)(.)*";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(msg).matches();
    }
}
