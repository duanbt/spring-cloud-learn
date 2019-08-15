package top.aceofspades;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author duanbt
 * @version 1.0
 **/
@FeignClient("consul-provider")
public interface HelloService {

    @GetMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);
}
