package com.dmy.customfeignhystric;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
//@EnableHystrix
//等价于 @SpringBootApplication @EnableDiscoveryClient @EnableCircuitBreaker的和
@SpringCloudApplication
@EnableHystrixDashboard
public class CustomFeignHystricApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(CustomFeignHystricApplication.class).web(true).run(args);
	}
}
