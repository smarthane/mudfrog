package com.smarthane.mudfrog.sapmles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/6 10:18
 * @Description:
 */
@RestController
public class RibbonConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HystrixTestService hystrixTestService;

    @GetMapping(value = "/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://mudfrog-samples/hello", String.class).getBody();
    }

    @GetMapping(value = "/hystrix-consumer")
    public String hystrixConsumer() {
        return hystrixTestService.hystrixService();
    }

}
