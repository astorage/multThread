package com.java.springmultithread;

import com.java.springmultithread.task.SecondTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * Copyright (c) 2013-2018 JOLLY INFORMATION TECHNOLOGY CO.LTD.
 * All rights reserved.
 * This software is the confidential and proprietary information of JOLLY
 * INFORMATION Technology CO.LTD("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with JOLLY.
 * Website：http://www.jollycorp.com
 * Created by boris on 2018/6/20.
 */
public class ThreadPoolApp {

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
        //test4();
    }



    public static void test1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        ThreadPoolTaskExecutor pool = context.getBean("threadPool", ThreadPoolTaskExecutor.class);
        SecondTask task1 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task1);
        SecondTask task2 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task2);
        SecondTask task3 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task3);
        SecondTask task4 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task4);
        System.out.println("task1" + task1);
        System.out.println("task2" + task2);
        System.out.println("task3" + task3);
        System.out.println("task4" + task4);

    }

    public static void test2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        ThreadPoolTaskExecutor pool = context.getBean("threadPool", ThreadPoolTaskExecutor.class);
        SecondTask task1 = new SecondTask();
        pool.execute(task1);
        SecondTask task2 = new SecondTask();
        pool.execute(task2);
        SecondTask task3 = new SecondTask();
        pool.execute(task3);
        SecondTask task4 = new SecondTask();
        pool.execute(task4);
        System.out.println("task1" + task1);
        System.out.println("task2" + task2);
        System.out.println("task3" + task3);
        System.out.println("task4" + task4);

    }

    public static void test3(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        //ThreadPoolExecutor pool = context.getBean("threadPool1", ThreadPoolExecutor.class);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 50, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),  Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        SecondTask task1 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task1);
        SecondTask task2 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task2);
        SecondTask task3 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task3);
        SecondTask task4 = context.getBean("runnabelTask", SecondTask.class);
        pool.execute(task4);
        System.out.println("task1" + task1);
        System.out.println("task2" + task2);
        System.out.println("task3" + task3);
        System.out.println("task4" + task4);

    }


    public static void test4(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        ThreadPoolExecutor pool = context.getBean("threadPool1", ThreadPoolExecutor.class);
        SecondTask task1 = new SecondTask();
        pool.execute(task1);
        SecondTask task2 = new SecondTask();
        pool.execute(task2);
        SecondTask task3 = new SecondTask();
        pool.execute(task3);
        SecondTask task4 = new SecondTask();
        pool.execute(task4);
        System.out.println("task1" + task1);
        System.out.println("task2" + task2);
        System.out.println("task3" + task3);
        System.out.println("task4" + task4);

    }
}
