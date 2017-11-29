package pl.gov.arimr.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Maciasz Mateusz on 2017-07-05.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"pl.gov.arimr.spring"})
@PropertySource(value = {"classpath:application.properties", "classpath:application-core.properties"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
