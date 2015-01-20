package com.micb2b.core.base.utils;


import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * 在Spring完全載入前，儘量別使用，否則ApplicationContext會是Null.
 */
@SuppressWarnings("rawtypes")
public class SpringBeanUtils implements ApplicationContextInitializer {

    private static ApplicationContext context;

    private static final Date startupTimestamp = new Date();

    @SuppressWarnings("unchecked")
    public static <T extends Object> T getBean(String bean) {
        try {
            T t = (T) context.getBean(bean);

            if (t == null) {
                t = (T) context.getParent().getBean(bean);
            }

            return t;
        } catch (BeansException e) {
            return null;
        }
    }

    public static String[] getBeanNamesForType(Class aclass) {
        try {
            String[] names = context.getBeanNamesForType(aclass);
            if (names == null || names.length == 0) {
                names = context.getParent().getBeanNamesForType(aclass);
            }
            return names;
        } catch (Exception e) {
            return null;
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }

    @Deprecated
    public static void setContext(ApplicationContext c) {
        context = c;
    }

    public static String getContextPath() {
        return ((WebApplicationContext) context).getServletContext().getContextPath();
    }

    public static Date getStartupTimestamp() {
        return (Date) startupTimestamp.clone();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        SpringBeanUtils.context = applicationContext;
    }

}
