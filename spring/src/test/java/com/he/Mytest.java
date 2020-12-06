package com.he;

import com.he.config.AppConfig;
import com.he.pojo.Hourse;
import com.he.pojo.Student;
import com.he.pojo.User;
import com.he.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        //获取spring 的上下文对象  相当远自动化实力类 控制反转
        //直接拿到 spring 的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());
    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user",User.class);
        System.out.println(user.getStr());
    }
    @Test
    public void testConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Hourse getHourse = (Hourse) context.getBean("getHourse");
        System.out.println(getHourse.toString());
    }
}
