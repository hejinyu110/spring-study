package com.he.pojo;

public class User {
    public String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "User{" +
                "str='" + str + '\'' +
                '}';
    }
}
