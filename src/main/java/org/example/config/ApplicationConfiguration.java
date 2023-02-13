package org.example.config;

import org.example.database.pool.ConnectionPool;
import org.example.database.repository.CrudRepository;
import org.example.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.web.config.WebConfiguration;

//@ImportResource("classpath:application.xml")
@Import( WebConfiguration.class )
@Configuration(proxyBeanMethods = true)
@PropertySource( "classpath:application.properties" )
@ComponentScan( basePackages = "org.example",
        useDefaultFilters = false,
        includeFilters = {
                @Filter( type = FilterType.ANNOTATION, value = Component.class ),
                @Filter( type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class ),
                @Filter( type = FilterType.REGEX, pattern = "org\\..+Repository" )
        } )
public class ApplicationConfiguration {

    @Bean( "pool2" )
    @Scope( BeanDefinition.SCOPE_PROTOTYPE )
    public ConnectionPool pool2(@Value( "${db.username}" ) String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 25);
    }

    @Bean
    @Profile("prod&web")
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository3() {
        ConnectionPool connectionPool1 = pool3();
        ConnectionPool connectionPool2 = pool3();
        ConnectionPool connectionPool3 = pool3();
        return new UserRepository(pool3());
    }
}
