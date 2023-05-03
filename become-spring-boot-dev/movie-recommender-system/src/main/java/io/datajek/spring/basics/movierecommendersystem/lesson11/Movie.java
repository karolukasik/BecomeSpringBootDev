package io.datajek.spring.basics.movierecommendersystem.lesson11;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Movie() {
        super();
        logger.info("In Movie constructor method");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In Movie postConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("In Movie preDestroy method");
    }

}
