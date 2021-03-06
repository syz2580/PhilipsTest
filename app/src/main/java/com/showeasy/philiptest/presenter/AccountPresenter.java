package com.showeasy.philiptest.presenter;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.showeasy.philiptest.PTException;
import com.showeasy.philiptest.framework.listener.NotifyListener;
import com.showeasy.philiptest.storage.SharedPrefsManager;
import com.showeasy.philiptest.storage.entity.AccountInfo;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by 邵一哲_Native on 2016/11/10.
 */

public class AccountPresenter {

    public static void loginWithAccount(String userName, String password, final NotifyListener finishListener) {
        Observable.just(new AccountInfo(userName, password))
                .map(new Func1<AccountInfo, LoginInfo>() {
                    @Override
                    public LoginInfo call(AccountInfo accountInfo) {

                        // TODO: 2016/11/11 从app服务器获取token及用户信息
                        return null;
                    }
                })
                .subscribe(new Action1<LoginInfo>() {
                    @Override
                    public void call(LoginInfo loginInfo) {
                        doLogin(loginInfo, finishListener);
                    }
                });
    }

    public static LoginInfo getLoginInfo() {
        try {
            return SharedPrefsManager.getInstance().getLoginInfo();
        } catch (PTException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void logout() {
        NIMClient.getService(AuthService.class).logout();
        SharedPrefsManager.getInstance().removeLoginInfo();
    }

    private static void doLogin(LoginInfo loginInfo, final NotifyListener finishListener) {
        RequestCallback<LoginInfo> callback = new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {
                SharedPrefsManager.getInstance().setLoginInfo(param);
                finishListener.onNotify(true);
            }
            @Override
            public void onFailed(int code) {
                finishListener.onNotify(false);
            }
            @Override
            public void onException(Throwable exception) {
                exception.printStackTrace();
                finishListener.onNotify(false);
            }
        };
        NIMClient.getService(AuthService.class)
                .login(loginInfo)
                .setCallback(callback);
    }
}
