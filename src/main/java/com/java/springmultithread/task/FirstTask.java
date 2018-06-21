package com.java.springmultithread.task;

import com.java.springmultithread.model.SimpleBO;
import com.java.springmultithread.service.SimpleService;
import lombok.Data;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

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
