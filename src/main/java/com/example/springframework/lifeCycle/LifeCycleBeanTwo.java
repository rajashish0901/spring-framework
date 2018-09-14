package com.example.springframework.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jt on 6/5/17.
 */
@Component("LifeCycleBeanTwo")
@Scope("prototype")
public class LifeCycleBeanTwo implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware{


    public LifeCycleBeanTwo() {
        System.out.println("## I'm in the LifeCycleBeanTwo Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The LifeCycleBeanTwo bean has been terminated");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBeanTwo has its properties set!");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## LifeCycleBeanTwo::Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## LifeCycleBeanTwo::My Bean Name is: " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## LifeCycleBeanTwo::Application context has been set");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## LifeCycleBeanTwo::The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## LifeCycleBeanTwo::The Predestroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("## LifeCycleBeanTwo::Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("## LifeCycleBeanTwo::After init called by Bean Post Processor");
    }

    public void doStuffXXX(){
        System.out.println("## - LifeCycleBeanTwo::doStuffXXX");
    }
}
