package net.xdclass.spring.config;


import net.xdclass.spring.domain.VideoOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomAppConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope
    public VideoOrder videoOrder() {

        // Spring 会将生成的对象加入到IOC容器中
        return new VideoOrder();
    }
}
