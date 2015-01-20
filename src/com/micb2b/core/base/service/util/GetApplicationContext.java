package com.micb2b.core.base.service.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetApplicationContext {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-test.xml");

	public static ApplicationContext getContext() {
		return context;
	}

}
