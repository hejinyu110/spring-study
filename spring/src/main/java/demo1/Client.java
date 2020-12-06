package demo1;

import com.he.service.UserService;
import com.he.service.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真是角色
        UserService userService = new UserServiceImpl();

        //代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);
        UserService proxy = (UserService) pih.getProxy();
        proxy.getUser();

    }
}
