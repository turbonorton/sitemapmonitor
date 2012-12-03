package sitemap.monitor.util;


import java.util.Comparator;

import sitemap.monitor.domain.SitemapEntry;

public class UpdateTimeComparator implements Comparator<SitemapEntry> {

	public int compare(SitemapEntry o1, SitemapEntry o2) {
		int result = Utils.Pojo.nullCompare(o1, o2);
		if (0 == result && null != o1) {
			result = o1.isBefore(o2) ? -1 : o1.isAfter(o2) ? 1 : 0; 
		}
		return result;
	}
	
	
}