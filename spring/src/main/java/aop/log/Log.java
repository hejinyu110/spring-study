package aop.log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//方法增强 实现类   同 php 中的 beforeAction 方法
@Component
public class Log implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("要开始执行了"+method.getName());
    }
}
