package sitemap.monitor.services;

import sitemap.monitor.config.ConfigProperties;

public interface SitemapService {

	void setConfigProperties(ConfigProperties props);
	void setConfigKey(String key);
	long getMinsSinceUpdate();
}
