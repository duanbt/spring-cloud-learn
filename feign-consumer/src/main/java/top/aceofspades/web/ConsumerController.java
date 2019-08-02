package top.aceofspades.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanbt
 * @since 1.0
 **/
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @GetMapping("/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

    @GetMapping("/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(helloService.hello()).append("\n")
                .append(helloService.hello("ace")).append("\n")
                .append(helloService.hello("ace", 25)).append("\n")
                .append(helloService.hello(new User("ace", 25))).append("\n");
        return sb.toString();
    }

    @GetMapping("/feign-consumer3")
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb
                .append(refactorHelloService.hello("ace")).append("\n")
                .append(refactorHelloService.hello("ace", 25)).append("\n")
                .append(refactorHelloService.hello(new top.aceofspades.dto.User("ace", 25))).append("\n");
        return sb.toString();
    }
}
