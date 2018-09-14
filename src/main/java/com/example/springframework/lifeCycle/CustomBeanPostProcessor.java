package com.example.springframework.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/5/17.
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("##--## postProcessBeforeInitialization " + beanName.toString());

        if(bean instanceof LifeCycleBeanOne){
            ((LifeCycleBeanOne) bean).beforeInit();
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("##--## postProcessAfterInitialization " + beanName.toString());
        if(bean instanceof LifeCycleBeanOne){
            ((LifeCycleBeanOne) bean).afterInit();
        }

        return bean;
    }
}
