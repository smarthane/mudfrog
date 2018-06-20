package com.smarthane.mudfrog.sapmles;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/6 13:57
 * @Description:
 */
@Service
public class HystrixTestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public String hystrixService()  {
        return restTemplate.getForEntity("http://mudfrog-samples/hello", String.class).getBody();
    }

    public String hystrixFallback() {
        return "error from hystrix fallback";
    }


}
