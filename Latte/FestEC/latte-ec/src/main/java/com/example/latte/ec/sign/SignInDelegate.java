package com.example.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.latte.ec.R;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R2;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.ISuccess;
import com.example.latte.util.log.LatteLogger;
import com.example.latte.wechat.LatteWeChat;
import com.example.latte.wechat.callbacks.IWeChatSignInCallback;

import butterknife.BindView;
import butterknife.OnClick;
//import com.example.latte.util.log.LatteLogger;
//import com.example.latte.wechat.LatteWeChat;
//import com.example.latte.wechat.callbacks.IWeChatSignInCallback;


/**
 *  Created by moransu on 2018/8/22
 */

public class SignInDelegate extends LatteDelegate implements View.OnClickListener {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            RestClient.builder()
                    .url("http://192.168.56.1:8080/RestDataServer/api/user_profile.php")
                    .params("email", mEmail.getText().toString())
                    .params("password", mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignIn(response, mISignListener);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWechat() {
        LatteWeChat.getInstance().onSignSuccess(new IWeChatSignInCallback() {
            @Override
            public void onSignInSuccess(String userInfo) {
                Toast.makeText(getContext(), "微信登录成功", Toast.LENGTH_LONG).show();
            }
        }).signIn();

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        start(new SignUpDelegate());
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
//        mEmail = $(R.id.edit_sign_in_email);
//        mPassword = $(R.id.edit_sign_in_password);
//        $(R.id.btn_sign_in).setOnClickListener(this);
//        $(R.id.tv_link_sign_up).setOnClickListener(this);
//        $(R.id.icon_sign_in_wechat).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
//        int i = view.getId();
//        if (i == R.id.btn_sign_in) {
//            onClickSignIn();
//        } else if (i == R.id.tv_link_sign_up) {
//            onClickLink();
//        } else if (i == R.id.icon_sign_in_wechat) {
//            onClickWeChat();
//        }
    }

    //    private TextInputEditText mEmail = null;
//    private TextInputEditText mPassword = null;


//    private void onClickWeChat() {
//        LatteWeChat
//                .getInstance()
//                .onSignSuccess(new IWeChatSignInCallback() {
//                    @Override
//                    public void onSignInSuccess(String userInfo) {
//                        Toast.makeText(getContext(), userInfo, Toast.LENGTH_LONG).show();
//                    }
//                })
//                .signIn();
//    }

//    private void onClickLink() {
//        getSupportDelegate().start(new SignUpDelegate());
//    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }
}
