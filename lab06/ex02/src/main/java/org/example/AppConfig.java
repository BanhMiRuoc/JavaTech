package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Bean01 bean01() {
        return new Bean01();
    }

    @Bean
    @Scope("singleton")
    public Bean02 bean02() {
        return new Bean02();
    }
}
