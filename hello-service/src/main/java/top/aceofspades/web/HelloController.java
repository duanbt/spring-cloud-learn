package top.aceofspades.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author duanbt
 * @since 1.0
 **/
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
//        测试超时触发断路器
//        int sleepTime = new Random().nextInt(3000);
//        logger.info("sleepTime:" + sleepTime);
//        Thread.sleep(sleepTime);

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                logger.info("/hello, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId());
            }
        }
        return "Hello World";
    }

    @GetMapping("/hello1")
    public String hello(@RequestParam String name) {
        logger.info("/hello1");
        return "Hello " + name;
    }

    @GetMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        logger.info("hello2");
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello(@RequestBody User user){
        logger.info("hello3");
        return user.toString();
    }
}
