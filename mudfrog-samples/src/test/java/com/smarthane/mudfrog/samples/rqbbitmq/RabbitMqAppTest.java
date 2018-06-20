package com.smarthane.mudfrog.samples.rqbbitmq;

import com.smarthane.mudfrog.sapmles.rabbitmq.RabbitApplicaton;
import com.smarthane.mudfrog.sapmles.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/8 9:48
 * @Description:
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitApplicaton.class)
public class RabbitMqAppTest {

    @Autowired
    private Sender sender;

    @Test
    public void sendTest() throws Exception {
        int i = 0;
        while(i < 5){
            String msg = new Date().toString();
            sender.send(msg);
            i++;
            Thread.sleep(3000);
        }
    }

}
