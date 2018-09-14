package com.example.springframework.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jt on 6/5/17.
 */

@Component
class A{
    A(){
        System.out.println("@@## A::Const ##@@");
    }

    public void hello(){
        System.out.println("@@## A::Hello() ##@@");
    }
}

class B{
    B(){
        System.out.println("@@## B::Const ##@@");
    }
    public void hello(){
        System.out.println("@@## B::Hello() ##@@");
    }
}

@Component
class C{
    C(){
        System.out.println("@@## C::Const ##@@");
    }
    public void hello(){
        System.out.println("@@## C::Hello() ##@@");
    }
}

@Component("LifeCycleBeanOne")
public class LifeCycleBeanOne implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware{

    @Autowired
    private A a;

    private B b;
    private C c;

    public LifeCycleBeanOne() {
        System.out.println("## I'm in the LifeCycleBeanOne Constructor");
    }

    @Autowired
    public void setC(C c){
        System.out.println("LifeCycleBeanOne::setC via DI");
        this.c = c;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The LifeCycleBeanOne bean has been terminated");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBeanOne has its properties set!");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## LifeCycleBeanOne::Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## LifeCycleBeanOne::My Bean Name is: " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## LifeCycleBeanOne::Application context has been set");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## LifeCycleBeanOne::The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## LifeCycleBeanOne::The Predestroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("## - LifeCycleBeanOne::Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        this.b = new B();
        System.out.println("## - LifeCycleBeanOne::After init called by Bean Post Processor");
    }

    public void doStuffXXX(){
        System.out.println("## - LifeCycleBeanOne::doStuffXXX");
        a.hello();
        b.hello();
        c.hello();
    }
}
