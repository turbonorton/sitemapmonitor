package sitemap.monitor.domain;

import org.joda.time.DateTime;

public class SitemapEntry {
	
	private DateTime lastmod;
	
	public SitemapEntry(final String modified) {
		lastmod = new DateTime(DateTime.parse(modified));
	}
	
	public boolean isBefore(final SitemapEntry other) {
		return lastmod.isBefore(other.lastmod);
	}
	
	public boolean isAfter(final SitemapEntry other) {
		return lastmod.isAfter(other.lastmod);
	}
	
	public long millsSinceUpdate() {
		DateTime diff = new DateTime().minus(lastmod.getMillis());
		return diff.getMillis();
	}
	
	@Override
	public String toString() {
		return lastmod.toString();
	}
}
