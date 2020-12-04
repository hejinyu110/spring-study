##常用依赖
```xml
<dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.0.RELEASE</version>
    </dependency>
```
注解需要配置xml 注解文件 context
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
</beans>
```

前提需要在 beans.xml 开启注解 
```xml
<context:annotation-config/>
```
 自动注解 自动会去加载类 但是必须在 xml 加入开启配置 require 说明这个值可以为null  否则必须给值 不给值会报空指针*/
 @Autowired（通过class匹配）
@Qualifier(require=false) 是否可以为空 
 @Resource（先通过名字，再通过 class） */
 

类的上方  @Component 表示自动装配类了，不需要在xml 中 beans 中再注入


自动扫描这个包下面的注解就会自动生效
```xml
    <context:component-scan base-package="com.he.pojo"/>
```