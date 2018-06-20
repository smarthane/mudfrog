package com.smarthane.mudfrog.sapmles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/6 15:04
 * @Description:
 */
@RestController
public class FeignTestController {

    @Autowired
    private FeignTestService feignTestService;

    @GetMapping(value = "/feign-consumer")
    public String feignConsumer() {
        return feignTestService.hello();
    }


}
