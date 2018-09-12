# spring-framework

## Reference- https://docs.spring.io/spring-boot/docs/current/reference/html/index.html

## Using the @SpringBootApplication Annotation
Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration on their "application class". A single @SpringBootApplication annotation can be used to enable those three features, that is:

@EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
@ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
@Configuration: allow to register extra beans in the context or import additional configuration classes
The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes, as shown in the following example:

package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

## The “main” Method
The final part of our application is the main method. This is just a standard method that follows the Java convention for an application entry point. Our main method delegates to Spring Boot’s SpringApplication class by calling run. SpringApplication bootstraps our application, starting Spring, which, in turn, starts the auto-configured Tomcat web server. We need to pass Example.class as an argument to the run method to tell SpringApplication which is the primary Spring component. The args array is also passed through to expose any command-line arguments.

## Spring Annotation:
Reference: https://dzone.com/articles/a-guide-to-spring-framework-annotations

### Core Spring Framework Annotations

@Autowired
Autowired annotation shall be used to inject dependency @var, @constructor and @method level during the bean creation.
As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target
bean only defines one constructor to begin with. However, if several constructors are available, at least one must
be annotated to teach the container which one to use.

@Qualifier
If there are more than 1 class of the fortune service then you need add the @qualifier along with @autowire to help the spring to identify the class.
    
@ComponentScan


@Bean
method annotated with this annotation works as the bean ID, and it creates and returns the actual bean.

@Value

@PreDestroy
add a destroy method.Code is executed before bean is destroyed. equivalent to destroy-method

@Configuration


### Spring Framework Stereotype Annotations

@Configuration:
+indicates that it contains source of bean definitions, methods annotated with @Bean. When the spring framework comes across a @Configuration class, not only the @Configuration class itself is registered as a bean definition, even all the declared @Bean methods within the class are also registered as bean definitions.
+is meta-annotated with @Component, therefore @Configuration classes are candidates for component scanning

@Component
marks the Java class as a bean or component so that the component-scanning mechanism of Spring can add it into the application context.

@Controller
used to identify controllers for Spring MVC or Spring WebFlux.

@Repository
works as a marker for any class that fulfills the role of repository or Data Access Object.
This annotation has an automatic translation feature. For example, when an exception occurs in the @Repository, there is a handler for that exception and there is no need to add a try-catch block.
