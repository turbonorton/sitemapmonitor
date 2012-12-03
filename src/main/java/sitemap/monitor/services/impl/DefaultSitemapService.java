package sitemap.monitor.services.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import sitemap.monitor.config.ConfigProperties;
import sitemap.monitor.domain.Sitemap;
import sitemap.monitor.external.SitemapFactory;
import sitemap.monitor.external.SitemapNotAvailableException;
import sitemap.monitor.services.SitemapService;


public class DefaultSitemapService implements SitemapService, ApplicationContextAware {

	private static final String SITEMAP_FACTORY_BEAN = "SitemapFactory";
	
	private ApplicationContext appContext;
	
	private String configKey;
	private ConfigProperties bean;
	
	public long getMinsSinceUpdate() {
		return getSitemap().lastupdate();
	}

	public void setConfigKey(String key) {
		this.configKey = key;
	}

	public void setConfigProperties(ConfigProperties props) {
		this.bean = props;
	}
	
	private Sitemap getSitemap() {
		try {
			SitemapFactory factory = this.appContext.getBean(SITEMAP_FACTORY_BEAN, SitemapFactory.class);
			return factory.create(buildURL());
		} catch (MalformedURLException malEx) {
			throw new SitemapNotAvailableException(malEx);
		}
	}

	private URL buildURL() throws MalformedURLException {
		String protocol = bean.get(configKey + ".protocol");
		String host = bean.get(configKey + ".host");
		String filePath = bean.get(configKey + ".path");
		
		return new URL(protocol, host, filePath);
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.appContext = applicationContext;
	}

}
