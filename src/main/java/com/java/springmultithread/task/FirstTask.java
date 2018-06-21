package com.java.springmultithread.task;

import com.java.springmultithread.model.SimpleBO;
import com.java.springmultithread.service.SimpleService;
import lombok.Data;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 *
 */
@Data
public class FirstTask implements Callable {

    @Resource
    private SimpleService simpleService;

    private SimpleBO simpleBO;

    @Override
    public Object call() throws Exception {
        return simpleBO;
    }

    @Override
    public String toString() {
        return super.getClass().getName() + "@" + Integer.toHexString(super.hashCode())+"{" +
                "simpleService=" + simpleService +
                ", simpleBO=" + simpleBO +
                '}';
    }
}
