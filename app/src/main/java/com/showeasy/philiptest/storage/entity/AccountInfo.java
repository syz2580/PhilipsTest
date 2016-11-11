package com.showeasy.philiptest.storage.entity;

/**
 * Created by 邵一哲_Native on 2016/11/11.
 */

public class AccountInfo {
    private String username;
    private String password;
    public AccountInfo(String u, String p) {
        username = u;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
