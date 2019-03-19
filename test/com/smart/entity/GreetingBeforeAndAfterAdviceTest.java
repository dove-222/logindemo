package com.smart.entity;

import com.smart.entity.aop.Greeting;
import com.smart.entity.aop.GreetingAroundAdvice;
import com.smart.entity.aop.GreetingBeforeAndAfterAdvice;
import com.smart.entity.aop.GreetingImpl;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class GreetingBeforeAndAfterAdviceTest {


    public void afterReturning() {
    }


    public void before() {
    }

    @Test
    public void client1(){
        ProxyFactory proxyFactory = new ProxyFactory();// 创建代理工厂对象
        proxyFactory.setTarget(new GreetingImpl());//投入目标类对象
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());//添加前置后置增强
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greeting greeting = (Greeting)proxyFactory.getProxy();
        greeting.sayHello("Dove");
    }
    @Test
    public void client2(){
        ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/applicationContext.xml");

        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.sayHello("Dove");
    }
}