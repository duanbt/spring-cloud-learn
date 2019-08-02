package top.aceofspades.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanbt
 * @since 1.0
 **/
@RestController
public class ConsumerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/ribbon-consumer")
    public String helloConsumer() {
        long start = System.currentTimeMillis();
        String result = helloService.helloService();
        long end = System.currentTimeMillis();
        logger.info("Spend time: " + (end - start));
        return result;
    }
}
