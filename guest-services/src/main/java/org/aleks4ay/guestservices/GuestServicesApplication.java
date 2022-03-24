package org.aleks4ay.guestservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GuestServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuestServicesApplication.class, args);
    }

}
