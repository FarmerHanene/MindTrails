package edu.virginia.psyc.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This is a Spring based application, and will auto discover the 
 * controllers in this code base and make them available
 *  as web endpoints.
 *
 * If you are using this as a template, be sure to repace "org.mindtrails.basic" in the scan
 * paths below with the package or your own code base.
 */
@ComponentScan ({"edu.virginia.psyc.mobile", "org.mindtrails"})
@Configuration
@EnableJpaRepositories(basePackages = {"edu.virginia.psyc.mobile", "org.mindtrails"})
@EnableAutoConfiguration
@EntityScan(basePackages = {"edu.virginia.psyc.mobile", "org.mindtrails"})
@EnableScheduling
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}