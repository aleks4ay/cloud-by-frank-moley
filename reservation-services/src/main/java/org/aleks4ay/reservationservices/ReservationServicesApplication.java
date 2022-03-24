package org.aleks4ay.reservationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ReservationServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServicesApplication.class, args);
    }

}
