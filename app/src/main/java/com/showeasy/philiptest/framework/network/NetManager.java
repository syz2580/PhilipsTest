package com.showeasy.philiptest.framework.network;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 邵一哲_Native on 2016/11/11.
 */

public class NetManager {
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/html; charset=utf8");

    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    private static class NetManagerHolder {
        private static final NetManager instance = new NetManager();
    }
    public static NetManager getInstance() {
        return NetManagerHolder.instance;
    }
    private NetManager() {
        mOkHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void get(String url, HttpCallBack callBack) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        call(request, callBack);
    }

    public void post(String url, String body, HttpCallBack callBack) {
        RequestBody requestBody;
        if (null == body) {
            requestBody = RequestBody.create(MEDIA_TYPE_TEXT, "");
        } else {
            requestBody = RequestBody.create(MEDIA_TYPE_JSON, body);
        }

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        call(request, callBack);
    }

    private void call(final Request request, final HttpCallBack callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = mOkHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        final String result = response.body().string();
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onSuccess(result);
                            }
                        });
                    } else {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onError(new Exception("请求失败"));
                            }
                        });
                    }
                } catch (final IOException e) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onError(e);
                        }
                    });
                }
            }
        }).start();
    }

    public interface HttpCallBack {
        void onSuccess(String result);
        void onError(Exception e);
    }
}
