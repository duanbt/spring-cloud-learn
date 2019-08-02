package top.aceofspades.service;

import org.springframework.web.bind.annotation.*;
import top.aceofspades.dto.User;

/**
 * @author duanbt
 * @since 1.0
 **/

@RequestMapping("/refactor")
public interface HelloService {

    @GetMapping("/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello6")
    String hello(@RequestBody User user);
}
