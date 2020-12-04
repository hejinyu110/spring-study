package com.he.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.*;

public class Student {
    private String name;
    /* 自动注解 自动会去加载类 但是必须在 xml 加入开启配置 require 说明这个值可以为null  否则必须给值 不给值会报空指针*/
    /* Autowired（通过class匹配） 和 Qualifier Resource（先通过名字，再通过 class） */
    @Autowired(required = false)
    @Qualifier(value = "address") /* 会自动去查找 xml 文件中 aaa 的定义匹配上 Adderss 默认是会按照名称  或者类型自动匹配*/
    @Resource //自动去按照名称 或者类型去加载，不用指定
    private Address address;//引用类型属性
    private String[] books;//数组
    private List<String> hobbys;//集合
    private Map<String,String> card;//map
    private Set<String> games;//set

    private Properties info;//属性类型
    private String wife;//空指针

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", hobbys=" + hobbys +
                ", card=" + card +
                ", games=" + games +
                ", info=" + info +
                ", wife='" + wife + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public Map<String, String> getCard() {
        return card;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public Set<String> getGames() {
        return games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }
}
