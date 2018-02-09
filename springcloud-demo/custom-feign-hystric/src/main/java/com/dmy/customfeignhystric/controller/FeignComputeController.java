package com.dmy.customfeignhystric.controller;

import com.dmy.customfeignhystric.intf.ComputeInf;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignComputeController {
    @Autowired
    ComputeInf computeInf;

    @GetMapping("/add")
//    @HystrixCommand(fallbackMethod = "fallback")
    public Integer add() {
        return computeInf.add(10, 20);
    }

//    public Integer fallback(){
//        return -1001;
//    }

}
