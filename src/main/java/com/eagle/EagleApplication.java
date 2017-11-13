package com.eagle;

import com.eagle.service.ServiceI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

@SpringBootApplication(scanBasePackages = {"com.eagle"})
@PropertySource("classpath:application.properties")
public class EagleApplication {
    @Resource
    ServiceI serviceI;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EagleApplication.class, args);
    }


}


