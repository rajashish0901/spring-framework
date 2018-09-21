package com.example.springframework.configuration.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.swing.plaf.synth.SynthEditorPaneUI;

//Precedence of configuration options
//https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html

@Configuration
//Option#1
//@PropertySource("classpath:DataSoruceProperties/datasource.properties")
//Option#2
@PropertySources({
        @PropertySource("classpath:DataSoruceProperties/datasource.properties")
})
public class DataSourceConfigDemo1 {

    //Approach#2
    @Autowired
    Environment env;

    //Approach#1
    @Value("${property.username}")
    String name;
    @Value("${property.password}")
    String pswd;
    @Value("${property.url}")
    String url;

    /*@Bean
    public static PropertySourcesPlaceholderConfigurer configurerInst() {
        System.out.println(" @@ PropertySourcesPlaceholderConfigurer getConfigurer @@ ");
        return new PropertySourcesPlaceholderConfigurer();
    }*/

    @Bean
    public DataSource dataSourceInstance(){
        System.out.println(" @@ DataSource getDataSourceInstance @@ " + name );

        DataSource object = new DataSource();
        //Approach#1
        object.setName(name);
        object.setUrl(url);

        //Approach#2
        object.setPassword(env.getProperty("property.password"));
        return object;
    }
}
