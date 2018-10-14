package org.ling.springboot.tk.mybatis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "org.ling.springboot.tk.mybatis.mapper")
//@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@SpringBootApplication
public class LingTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LingTestApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

}
