package com.showeasy.philiptest.storage.entity;

/**
 * Created by 邵一哲_Native on 2016/11/11.
 */

public class User {
    String uid;
    String name;
    Sex sex;

    String anotherId;
    public enum Sex {
        male,
        female,
        unknown
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAnotherId() {
        return anotherId;
    }

    public void setAnotherId(String anotherId) {
        this.anotherId = anotherId;
    }
}
