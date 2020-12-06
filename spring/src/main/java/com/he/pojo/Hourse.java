package com.he.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hourse {
    private String name;



    @Value("金玉的房子")
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Hourse{" +
                ", name='" + name + '\'' +
                '}';
    }
}
