package com.smarthane.mudfrog.sapmles;

import org.springframework.stereotype.Component;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/6 15:16
 * @Description:
 */
@Component
public class FeignTestFallback implements FeignTestService {
    @Override
    public String hello() {
        return "error";
    }
}
