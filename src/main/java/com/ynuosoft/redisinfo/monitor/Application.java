package com.ynuosoft.redisinfo.monitor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by meng li on 2017/1/16.
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setRegisterShutdownHook(false);
        springApplication.setWebEnvironment(false);
        //
        //springApplication.setAddCommandLineProperties(false);
        springApplication.run(args);

    }

}
