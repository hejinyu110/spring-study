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
http://mybatis.org/spring/zh/transactions.html#container
前提需要在 beans.xml 开启注解  很重要
```xml
<context:annotation-config/>
```
 自动注解 自动会去加载类 但是必须在 xml 加入开启配置 require 说明这个值可以为null  否则必须给值 不给值会报空指针*/
 @Autowired（通过class匹配）
@Qualifier(require=false) 是否可以为空 
 @Resource（先通过名字，再通过 class） */
 

类的上方  @Component 表示自动装配类了，不需要在xml 中 beans 中再注入
@Controller 表示也被Spring 自动装配  同Component 只是专门放在Controller 文件中
@Repository dao 文件中自动装配
@Service service 文件中自动装配

自动扫描这个包下面的注解就会自动生效
```xml
    <context:component-scan base-package="com.he.pojo"/>
```

最新的 方案都是使用  Javaconfig 使用注解
里面定义方法实例化 类就是一个Bean

```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
Hourse getHourse = (Hourse) context.getBean("getHourse");
System.out.println(getHourse.toString());
```


Aop 面向切面编程 
静态代理
1.需要将所有的 service 实现类
动态代理  proxy     InvocationHandler 代理实现类

demo1 中实现的的是 动态代理



aop 实现 需要 新的包 
```xml

<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.6</version>
    <scope>runtime</scope>
</dependency>

```

aop 实现 个人理解 就是  beforeAction afterAction 事件 
通过  aop:config 注册需要的列 事件类 
 然后进行绑定类的事件行为
 
 src 目录下的 xml 文件需要打包到项目里面 ，默认是不打包的，需要将配置爱打开
 ```xml

<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

事务织入  aop
```xml

<!--开启 spring 事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <constructor-arg ref="dataSource" />
    </bean>
<!--结合 AOP 实现事务织入-->
    <!-- 配置事务通知-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!--给那些方法配置事务-->
        <!--配置事务传播特性 propagation-->
        <tx:attributes>
            <tx:method name="add" propagation="REQUIRED"/>
            <tx:method name="delete" propagation="REQUIRED"/>
            <tx:method name="update" propagation="REQUIRED"/><!-- propagation="REQUIRED"  表示开启事务，并且使用事务（多个事务操作）-->
            <tx:method name="query" read-only="true"/> <!--所有的查询都是制度-->
        </tx:attributes>
    </tx:advice>

    <!--配置事务的切入-->
    <!--所有的 mapper.xml 全部使用事务
     这样在写 代码逻辑的时候就不用使用 事务，因为在配置文件中已经全部使用了事务
     -->
    <aop:config>
        <aop:pointcut id="txPoint" expression="execution(* com.he.mapper.*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPoint"/>
    </aop:config>

```