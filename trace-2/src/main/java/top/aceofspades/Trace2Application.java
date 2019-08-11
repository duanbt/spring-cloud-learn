package top.aceofspades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(Trace2Application.class);

    @GetMapping("/trace-2")
    public String trace(HttpServletRequest request) {
        logger.info("=== call trace-2， TraceId={}, SpanId={} ===", request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        return "Trace";
    }

}
