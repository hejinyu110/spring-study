package com.he;

import com.he.config.AppConfig;
import com.he.mapper.UserMapper;
import com.he.pojo.Hourse;
import com.he.pojo.Student;
import com.he.pojo.User;
import com.he.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
        Student student = (Student) context.getBean("Student");
        System.out.println(student.getName());
    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user",User.class);
        System.out.println(user.getStr());
    }
    @Test
    public void testConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Hourse getHourse = (Hourse) context.getBean("getHourse");
        System.out.println(getHourse.toString());
    }

    @Test
    public void testMapper(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);

        }

    }
}
