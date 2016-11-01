package com.showeasy.philiptest.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.showeasy.philiptest.PTException;
import com.showeasy.philiptest.util.MiscUtil;

/**
 * Created by 邵一哲_Native on 2016/11/1.
 */

public class SharedPrefsManager {

    private static final String SHAREDPREFERENCE_FILE_NAME = "philipssp";

    private static final String LAST_CONNECTED_IP = "lastconnectedip";
    private static final String LAST_CONNECTED_USERNAME = "lastconnectedusername";

    protected SharedPreferences mSP = null;

    private static class SharedPrefsManagerHolder {
        private static final SharedPrefsManager instance = new SharedPrefsManager(MiscUtil.getApplicationContext());
    }
    private SharedPrefsManager(Context context) {
        if(null != context){
            mSP = context.getSharedPreferences(SHAREDPREFERENCE_FILE_NAME,Context.MODE_PRIVATE);
            if(null == mSP){
                throw new IllegalStateException("Failed to init SharedPrefsManager! ");
            }
        }
    }
    public static SharedPrefsManager getInstance() {
        return SharedPrefsManagerHolder.instance;
    }

    private PTException createSharedPrefsException(Throwable throwable) {
        return new PTException(PTException.SHAREDPREFS_FAILED,
                "sharedprefs failed",
                throwable);
    }

    /**
     *
     * @param field
     * @param defaultVaule
     * @return
     * @throws PTException
     */
    public boolean getBooleanField(String field,boolean defaultVaule) throws PTException {
        try {
            return mSP.getBoolean(field, defaultVaule);
        } catch (ClassCastException ex) {
            throw createSharedPrefsException(ex);
        }
    }

    /**
     * @param field
     * @return
     */
    public boolean getBooleanField(String field) throws PTException {
        try {
            return mSP.getBoolean(field, false);
        } catch (ClassCastException ex) {
            throw createSharedPrefsException(ex);
        }
    }

    /**
     *
     * @param field
     * @param defaultValue
     * @return
     * @throws PTException
     */
    public int getInt(String field,int defaultValue) throws PTException {
        try {
            return mSP.getInt(field, defaultValue);
        } catch (ClassCastException ex) {
            throw createSharedPrefsException(ex);
        }
    }

    /**
     * @param field
     * @return
     */
    public int getInt(String field) throws PTException {
        try {
            return mSP.getInt(field, 0);
        } catch (ClassCastException ex) {
            throw createSharedPrefsException(ex);
        }
    }

    /**
     * @param field
     * @return
     */
    public float getFloat(String field) throws PTException {
        try {
            return mSP.getFloat(field, 0);
        } catch (ClassCastException ex) {
            throw createSharedPrefsException(ex);
        }
    }

    /**
     * @param field
     * @return
     */
    public long getLong(String field) throws PTException {
        try {
            return mSP.getLong(field, 0);
        } catch (ClassCastException ex) {
            throw createSharedPrefsException(ex);
        }
    }

    /**
     * @param field
     * @return
     */
    public String getString(String field) throws PTException {
        try {
            return mSP.getString(field, "");
        } catch (ClassCastException ex) {
            throw createSharedPrefsException(ex);
        }
    }

    /**
     * @param field
     * @param value
     */
    public void setBoolean(String field, boolean value) {
        mSP.edit().putBoolean(field, value).commit();
    }

    /**
     * @param field
     * @param value
     */
    public void setInt(String field, int value) {
        mSP.edit().putInt(field, value).commit();
    }

    /**
     * @param field
     * @param value
     */
    public void setFloat(String field, float value) {
        mSP.edit().putFloat(field, value).commit();
    }

    /**
     * @param field
     * @param value
     */
    public void setLong(String field, long value) {
        mSP.edit().putLong(field, value).commit();
    }

    /**
     * @param field
     * @param value
     */
    public void setString(String field, String value) {
        mSP.edit().putString(field, value).commit();
    }

    public void remove(String field) {
        mSP.edit().remove(field).commit();
    }

    public boolean contains(String field) {
        return mSP.contains(field);
    }


    public void setLastConnectedIPAddress(String ip) {
        setString(LAST_CONNECTED_IP,ip);
    }

    public void setLastConnectedUsername(String username) {
        setString(LAST_CONNECTED_USERNAME,username);
    }
}
