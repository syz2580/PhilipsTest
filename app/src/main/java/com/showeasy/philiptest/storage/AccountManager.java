package com.showeasy.philiptest.storage;

import com.showeasy.philiptest.storage.entity.AccountInfo;
import com.showeasy.philiptest.storage.entity.User;

/**
 * Created by 邵一哲_Native on 2016/11/11.
 */

public class AccountManager {
    private User currentUser;

    private static class AccountManagerHolder {
        private static final AccountManager instance = new AccountManager();
    }
    public static AccountManager getInstance() {
        return AccountManagerHolder.instance;
    }
    private AccountManager() {}

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
