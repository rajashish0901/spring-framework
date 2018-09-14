package com.example.springframework.configuration.annotation;

import com.example.springframework.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/* Java class representation the ApplicationContext file
<!-- define the dependency-->
   	<bean id="myFortuneService"
    		class="com.example.springframework.common.HappyFortuneService">
    </bean>

    <!-- Bean Life Cycle methods -->
    <bean id="trackCoach"
          class="com.example.springframework.common.TrackCoach" init-method="doMyStartupStuffXXX"
          destroy-method="doMyCleanupStuffYYY"
          scope="singleton">
    </bean>
* */

@Configuration("Secondary")
public class CoachConfiguration {

    @Bean
    FortuneService myfortuneService(){
        System.out.println("@@ CoachConfiguration::myfortuneService  @@");
        return new HappyFortuneService();
    }

    @Bean
    @Profile({"local","default"})//when no profiles are active then default is picked.
    //@Primary
    public Coach cricketCoach(){
        System.out.println("@@ CoachConfiguration::cricketCoach @@");
        //return new TrackCoach(fserv);
        return new CricketCoach(myfortuneService());
    }

    @Bean(initMethod = "doMyStartupStuffXXX", destroyMethod = "doMyCleanupStuffYYY" )
    @Profile("international")
    public Coach trackCoach(){
        System.out.println("@@ TrackCoachConfiguration::trackCoach  @@");
        //return new TrackCoach(fserv);
        return new TrackCoach(myfortuneService());
    }

    //Two @Bean of same class type lead to exception:
    //Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean
    //of type 'com.example.springframework.common.Coach' available: expected single matching bean but
    //found 2: cricketCoach,trackCoach.
    //Adding  @Primary tags solve the problem by telling Spring to pick primary Bean.

}