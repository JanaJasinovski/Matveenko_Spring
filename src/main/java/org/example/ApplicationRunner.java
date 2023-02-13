package org.example;

import org.example.config.ApplicationConfiguration;
import org.example.database.pool.ConnectionPool;
import org.example.database.repository.CrudRepository;
import org.example.service.CompanyService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

public class ApplicationRunner {
    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyService = context.getBean("companyService", CompanyService.class);
             System.out.println(companyService.findById(1));
        }

    }
}