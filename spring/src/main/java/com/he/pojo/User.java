package com.he.pojo;

import org.springframework.stereotype.Component;

//等价于 <bean id="user" class="com.he.pojo.User" />
@Component
public class User {
    public String str;

    public User(String str) {
        this.str = str;
    }

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
