package com.java.springmultithread;

import com.java.springmultithread.model.SimpleBO;
import com.java.springmultithread.task.FirstTask;
import com.java.springmultithread.task.SecondTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
public class TheadPoolApp1 {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }


    /**
     * submit提交Runnable类型的任务
     */
    public static void test1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        ThreadPoolTaskExecutor pool = context.getBean("threadPool", ThreadPoolTaskExecutor.class);
        SecondTask task1 = context.getBean("runnabelTask", SecondTask.class);
        pool.submit(task1);
        SecondTask task2 = context.getBean("runnabelTask", SecondTask.class);
        pool.submit(task2);
        SecondTask task3 = context.getBean("runnabelTask", SecondTask.class);
        pool.submit(task3);
        SecondTask task4 = context.getBean("runnabelTask", SecondTask.class);
        pool.submit(task4);
        System.out.println("task1" + task1);
        System.out.println("task2" + task2);
        System.out.println("task3" + task3);
        System.out.println("task4" + task4);
    }

    /**
     * submit提交callable类型的任务——不带返回参数
     */
    public static void test2() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        ThreadPoolTaskExecutor pool = context.getBean("threadPool", ThreadPoolTaskExecutor.class);
        FirstTask task1 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data1 = new SimpleBO();
        data1.setName("task1");
        task1.setSimpleBO(data1);
        pool.submit(task1);
        FirstTask task2 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data2 = new SimpleBO();
        data2.setName("task2");
        task1.setSimpleBO(data2);
        pool.submit(task2);
        FirstTask task3 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data3 = new SimpleBO();
        data3.setName("task3");
        task1.setSimpleBO(data3);
        pool.submit(task3);
        FirstTask task4 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data4 = new SimpleBO();
        data4.setName("task4");
        task1.setSimpleBO(data4);
        pool.submit(task4);
        System.out.println("task1" + task1);
        System.out.println("task2" + task2);
        System.out.println("task3" + task3);
        System.out.println("task4" + task4);
    }

    /**
     * submit提交callable类型的任务——带返回参数
     */
    public static void test3() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        ThreadPoolTaskExecutor pool = context.getBean("threadPool", ThreadPoolTaskExecutor.class);
        FirstTask task1 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data1 = new SimpleBO();
        data1.setName("task1");
        task1.setSimpleBO(data1);
        Future<SimpleBO> future1 = pool.submit(task1);
        FirstTask task2 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data2 = new SimpleBO();
        data2.setName("task2");
        task2.setSimpleBO(data2);
        Future<SimpleBO> future2 = pool.submit(task2);
        FirstTask task3 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data3 = new SimpleBO();
        data3.setName("task3");
        task3.setSimpleBO(data3);
        Future<SimpleBO> future3 = pool.submit(task3);
        FirstTask task4 = context.getBean("callableTask", FirstTask.class);
        SimpleBO data4 = new SimpleBO();
        data4.setName("task4");
        task4.setSimpleBO(data4);
        Future<SimpleBO> future4 = pool.submit(task4);
        System.out.println("task1" + task1);
        System.out.println("task2" + task2);
        System.out.println("task3" + task3);
        System.out.println("task4" + task4);

        if (future1.isDone()) {
            try {
                SimpleBO result = future1.get();
                System.out.println("任务1返回值：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (future2.isDone()) {
            try {
                SimpleBO result = future2.get();
                System.out.println("任务2返回值：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (future3.isDone()) {
            try {
                SimpleBO result = future3.get();
                System.out.println("任务3返回值：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (future4.isDone()) {
            try {
                SimpleBO result = future4.get();
                System.out.println("任务4返回值：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
