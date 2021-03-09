package net.xdclass.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class CustomBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("CustomBeanPostProcessor BeforeInitialization BeanName: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("CustomBeanPostProcessor AfterInitialization BeanName: " + beanName);
        return bean;
    }

    // Integers specify a priority,
    // the lower numeric takes precedence
    @Override
    public int getOrder() {
        return 1;
    }
}
