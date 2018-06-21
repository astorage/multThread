package com.java.springmultithread;

import com.java.springmultithread.model.SimpleBO;
import com.java.springmultithread.service.SimpleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 简单测试spring
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        SimpleService simpleService = context.getBean("simpleService", SimpleService.class);
        SimpleBO simpleBO = new SimpleBO();
        simpleBO.setName("This is a simplest spring demo");
        simpleService.print(simpleBO);
    }
}
