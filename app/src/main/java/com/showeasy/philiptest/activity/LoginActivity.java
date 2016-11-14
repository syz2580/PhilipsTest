package com.showeasy.philiptest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.showeasy.philiptest.R;
import com.showeasy.philiptest.framework.listener.NotifyListener;
import com.showeasy.philiptest.presenter.AccountPresenter;
import com.showeasy.philiptest.util.LaunchUtil;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends BaseActivity {

    public static final String ERR_USERNAME_EMPTY = "用户名不能为空";
    public static final String ERR_PASSWORD_EMPTY = "密码不能为空";
    private CircularProgressButton btnLogin;
    private TextView tvSignup;
    private TextView tvResetPassword;
    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    @Override
    protected void onResume() {
        super.onResume();
        btnLogin.setProgress(0);
    }

    private void init() {
        btnLogin = (CircularProgressButton) findViewById(R.id.btn_login);
        tvSignup = (TextView) findViewById(R.id.tv_signup);
        tvResetPassword = (TextView) findViewById(R.id.tv_reset_password);
        etUsername = (EditText) findViewById(R.id.input_username);
        etPassword = (EditText) findViewById(R.id.input_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchRegisterActivity(LoginActivity.this);
            }
        });
    }

    private void login() {
        //Do Login Procedure
        btnLogin.setIndeterminateProgressMode(true);
        btnLogin.setProgress(50);
        if (!validateInput()) {
            onLoginFail();
            return;
        }

        //Post login request to server
        AccountPresenter.loginWithAccount(etUsername.getText().toString()
                , etPassword.getText().toString()
                , new NotifyListener() {
                    @Override
                    public void onNotify(Object result) {
                        if (result.equals(true)) {
                            onLoginSuccess();
                        } else {
                            onLoginFail();
                        }
                    }
                });
    }

    private boolean validateInput() {
        //验证输入格式
        boolean validate = true;

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if (username.isEmpty()) {
            etUsername.setError(ERR_USERNAME_EMPTY);
            validate = false;
        } else {
            etUsername.setError(null);
        }
        if (password.isEmpty()) {
            etPassword.setError(ERR_PASSWORD_EMPTY);
            validate = false;
        } else {
            etPassword.setError(null);
        }
        return validate;
    }

    private void onLoginFail() {
        btnLogin.setProgress(-1);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                btnLogin.post(new Runnable() {
                    @Override
                    public void run() {
                        btnLogin.setProgress(0);
                    }
                });
            }
        }, 1800);
    }

    private void onLoginSuccess() {
        btnLogin.setProgress(100);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                btnLogin.post(new Runnable() {
                    @Override
                    public void run() {
                        //跳转至下一界面
                    }
                });
            }
        }, 1500);
    }
}
