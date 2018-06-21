package com.java.springmultithread.task;

import com.java.springmultithread.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by boris on 2018/6/20.
 */

public class SecondTask implements Runnable {

    @Autowired
    private SimpleService simpleService;

    @Override
    public void run() {
        simpleService.print();
    }
}
