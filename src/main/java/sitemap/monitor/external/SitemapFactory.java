package sitemap.monitor.external;


import java.net.URL;
import java.util.List;

import sitemap.monitor.domain.Sitemap;
import sitemap.monitor.domain.SitemapEntry;

/**
 * Reads a Sitemap XML file in to a {@link Sitemap}
 * @author RNOR
 *
 */
public class SitemapFactory {

	public Sitemap create(final URL location) {
		List<SitemapEntry> entries = new SitemapDOM(location).build();
		return new Sitemap(entries);
	}
}
