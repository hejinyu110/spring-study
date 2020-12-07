package com.he.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //等价于 <bean id="user" class="com.he.pojo.User" />
public class User {

    @Value("abc") //相当于默认值 等价于 bean 中定义属性值
    public String str;

    public User() {
    }

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
