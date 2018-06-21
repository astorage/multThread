package com.java.springmultithread.service.impl;

import com.java.springmultithread.model.SimpleBO;
import com.java.springmultithread.service.SimpleService;


public class SimpleServiceImpl implements SimpleService {
    @Override
    public void print(SimpleBO simpleBO) {
        System.out.println(simpleBO);
    }

    @Override
    public void print() {
        System.out.println("dayin .....");
    }
}
