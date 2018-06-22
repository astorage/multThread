package com.java.springmultithread;

import com.java.springmultithread.model.SimpleBO;
import com.java.springmultithread.spring.MyApplicationObjectSupport;
import com.java.springmultithread.task.FirstTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * spring完全管理多线程的情况
 *在servlet容器环境下面，数据量不确定， 通过ApplicationObjectSupport获得ApplicationContext,
 * 再通过context根据数据量动态生成任务（不用手动new 任务对象）
 * Created by boris on 2018/6/21.
 */
public class TheadPoolApp2 {

    public static void main(String[] args) {
        List<SimpleBO> dataList = new ArrayList<>();

        for (int i=0; i<10; i++) {
            SimpleBO data = new SimpleBO();
            data.setName("task" + i);
            dataList.add(data);
        }
        test1(dataList);
    }

    /**
     * submit提交Runnable类型的任务
     */
    public static void test1(List<SimpleBO> dataList) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");

        MyApplicationObjectSupport myApplicationObjectSupport = context.getBean("myApplicationObjectSupport", MyApplicationObjectSupport.class);
        ApplicationContext myContext = myApplicationObjectSupport.getApplicationContext();
        ThreadPoolTaskExecutor pool = context.getBean("threadPool", ThreadPoolTaskExecutor.class);
        int i = 0;
        for (SimpleBO simpleBO : dataList) {
            FirstTask task = myContext.getBean("callableTask", FirstTask.class);
            task.setSimpleBO(simpleBO);
            pool.submit(task);
            System.out.println("task"+ (i++) + "  " +task);
        }
    }

}


