package io.github.water1207.dashsdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DaShSdkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaShSdkApplication.class, args);
    }

}
