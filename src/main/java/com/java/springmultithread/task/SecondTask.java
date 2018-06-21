package com.java.springmultithread.task;

import com.java.springmultithread.service.SimpleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

public class SecondTask implements Runnable {

    @Autowired
    private SimpleService simpleService;

    @Override
    public void run() {
        simpleService.print();
    }
}
