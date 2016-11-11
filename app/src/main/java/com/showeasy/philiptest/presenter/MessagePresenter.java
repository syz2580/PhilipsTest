package com.showeasy.philiptest.presenter;

import com.netease.nimlib.sdk.InvocationFuture;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.showeasy.philiptest.framework.listener.NotifyListener;
import com.showeasy.philiptest.storage.AccountManager;

/**
 * Created by 邵一哲_Native on 2016/11/11.
 */

public class MessagePresenter {
    public static void sendTextMessage(String content, final NotifyListener finishListener) {
        IMMessage message = MessageBuilder.createTextMessage(
                AccountManager.getInstance().getCurrentUser().getAnotherId(),
                SessionTypeEnum.P2P,
                content
        );
        InvocationFuture invocationFuture = NIMClient.getService(MsgService.class).sendMessage(message, true);
        if (null != finishListener) {
            invocationFuture.setCallback(new RequestCallback() {
                @Override
                public void onSuccess(Object param) {
                    finishListener.onNotify(true);
                }

                @Override
                public void onFailed(int code) {
                    finishListener.onNotify(false);
                }

                @Override
                public void onException(Throwable exception) {
                    finishListener.onNotify(false);
                    exception.printStackTrace();
                }
            });
        }
    }
}
