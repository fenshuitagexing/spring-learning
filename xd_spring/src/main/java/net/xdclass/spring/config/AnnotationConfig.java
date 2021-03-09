package net.xdclass.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("net.xdclass")
@EnableAspectJAutoProxy // 开启Spring对Aspect的支持
public class AnnotationConfig {


}
