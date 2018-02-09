package com.dmy.customfeignhystric.fallback;

import com.dmy.customfeignhystric.intf.ComputeInf;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * hystrix容错机制，异常后返回的结果
 */
@Component
public class AddClientFallback implements ComputeInf {
    @Override
    public Integer add(@RequestParam(value = "a")Integer a, @RequestParam(value = "b")Integer b) {
        System.out.println("AddClientFallback.add");
        System.out.println("result : a="+a + " b="+b);
        return -1001;
    }
}
