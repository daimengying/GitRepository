package com.dmy.customfeignhystric.intf;

import com.dmy.customfeignhystric.fallback.AddClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 对于Feign负载均衡的hystrix容错机制
 * 接口层添加fallback = AddClientFallback.class，指定异常后的返回结果
 */
@FeignClient(name="eureka-client", fallback = AddClientFallback.class)
public interface ComputeInf {
    @GetMapping("/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}

