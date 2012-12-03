package sitemap.monitor.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sitemap.monitor.external.SitemapEmptyException;
import sitemap.monitor.util.UpdateTimeComparator;
import sitemap.monitor.util.Utils;

public class Sitemap {

	private List<SitemapEntry> elements;
	
	public Sitemap(List<SitemapEntry> entries) {
		if (null == entries || entries.isEmpty()) {
			throw new SitemapEmptyException("Sitemap empty");
		}
		elements = new ArrayList<SitemapEntry>(entries);
		Collections.sort(elements, new UpdateTimeComparator());
	}

	public boolean hasEntries() {
		return !elements.isEmpty();
	}
	
	public long lastupdate() {
		SitemapEntry mostRecent = elements.get(elements.size()-1);
		return Utils.Time.millsToMin(mostRecent.millsSinceUpdate());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Element Count" + elements.size());
		return sb.toString();
	}
}
