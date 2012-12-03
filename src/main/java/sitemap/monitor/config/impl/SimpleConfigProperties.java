package sitemap.monitor.config.impl;


import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import sitemap.monitor.config.ConfigProperties;

public class SimpleConfigProperties implements ConfigProperties, ApplicationContextAware {
	
	private static final String SETTINGS_BEAN = "appSettings";
	
	private ApplicationContext appContext;
	
	private Properties config = new Properties();

	public void postInit() {
		Properties bean = appContext.getBean(SETTINGS_BEAN, Properties.class);

		config.putAll(bean);
	}
	
	public String get(String key) {
		return config.getProperty(key);
	}

	public String get(String key, String def) {
		return config.getProperty(key, def);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.appContext = applicationContext;
	}

}
