package io.datajek.spring.basics.movierecommendersystem.lesson11;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("CBF")
// @Component
// @Qualifier("CBF")
public class ContentBasedFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String[] getRecommendations(String Movie) {
        return new String[] { "Happy Feet", "Ice Age", "Shark Tale" };
    }

    @javax.annotation.PostConstruct
    public void whatToDoWithRecommendation() {
        logger.info("In ContentBasedFilter PostConstruct method");
    }

    @PreDestroy
    public void cleanSth() {
        logger.info("In ContentBasedFilter preDestroy method");
    }
}
