package top.aceofspades;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@SpringBootApplication
public class ConsulConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigApplication.class, args);
    }

    @Value("${foo.bar.name:default}")
    private String name;

    @GetMapping("/getName")
    public String getName(){
        return name;
    }



}
