package io.datajek.springmvc.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    @Nullable
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    @Nullable
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { PlayerConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/springmvc/*" };
    }

}