package com.he.config;

import com.he.pojo.Hourse;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;


@Configuration
//@ComponentScan("com.he.pojo")  //自动扫描包自动装载  同 xml 配置文件
//@Import("aaaa")   Import  注解也可以引入多个 注解类 同xml 中 import
public class AppConfig {

    @Bean
    public Hourse getHourse(){
        return new Hourse();
    }
}
