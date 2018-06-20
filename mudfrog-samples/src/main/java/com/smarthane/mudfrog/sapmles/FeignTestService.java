
package com.smarthane.mudfrog.sapmles;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/6 15:04
 * @Description:
 * @FeignClient注解定义了该接口是一个Feign客户端，name指定了注册到Eureka上的服务名，fallback是服务降级后的接口实现类。
 @RequestMapping里指定了请求的相对url和http请求方式，与服务端一一对应。入参里的@RequestParam、@RequestBody、@RequestHeader注解比起服务端多了value属性，这里不能省略，需要显式的告知Feign客户端参数要如何对应。
 降级服务代码：
 feign:
    hystrix:
        enabled: true

 */
@FeignClient(name="mudfrog-samples", fallback=FeignTestFallback.class)
public interface FeignTestService {
    
    @RequestMapping("/hello")
    String hello();
}
