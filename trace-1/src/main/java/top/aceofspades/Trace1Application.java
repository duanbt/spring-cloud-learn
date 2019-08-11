package top.aceofspades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace1Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace1Application.class, args);
    }

    private final Logger logger = LoggerFactory.getLogger(Trace1Application.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/trace-1")
    public String trace(){
        logger.info("=== call trace-1 ===");
        return restTemplate().getForObject("http://TRACE-2/trace-2", String.class);
    }

}
