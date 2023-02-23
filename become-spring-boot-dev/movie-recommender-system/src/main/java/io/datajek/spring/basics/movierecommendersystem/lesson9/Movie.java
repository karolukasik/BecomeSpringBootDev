package io.datajek.spring.basics.movierecommendersystem.lesson9;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.*;;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {
    private static int instances = 0;


    public Movie() {
        instances++;
        System.out.println("Movie constructor called");
    }

    public static int getInstances() {
        return instances;
    }
}
