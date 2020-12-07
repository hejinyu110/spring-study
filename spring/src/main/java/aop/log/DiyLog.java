package aop.log;

public class DiyLog {
    public void before(){
        System.out.println("方法之前=====");
    }
    public void after(){
        System.out.println("方法之后=========");
    }
}
