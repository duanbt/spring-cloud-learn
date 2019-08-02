package top.aceofspades.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanbt
 * @since 1.0
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
