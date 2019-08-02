package top.aceofspades.web;

import org.springframework.cloud.openfeign.FeignClient;
import top.aceofspades.service.HelloService;

/**
 * @author duanbt
 * @since 1.0
 **/
@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {
}
