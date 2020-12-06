package aop.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl  implements UserService{
    public void add() {
        System.out.println("添加一个用户");
    }

    public void update() {
        System.out.println("更新用户");
    }

    public void search() {
        System.out.println("查找用户");
    }

    public void delete() {
        System.out.println("删除用户");
    }
}
