package sitemap.monitor.util;

import static org.junit.Assert.*;

import org.junit.Test;

import sitemap.monitor.util.Utils;

public class TimeUtilsTest {
	
	@Test
	public void testMillsToMins() {
		assertTrue("Zero ms is Zero Mins", Utils.Time.millsToMin(0) == 0);
		assertTrue("500 ms is Zero Mins", Utils.Time.millsToMin(500) == 0);
		assertTrue("1000 ms is Zero Mins",  Utils.Time.millsToMin(1000) == 0);
		
		assertTrue("29999 ms is Zero Mins",  Utils.Time.millsToMin(29999) == 0);
		assertTrue("30000 ms is 1 min", Utils.Time.millsToMin(30000) == 1);
		assertTrue("60000 ms is 1 min", Utils.Time.millsToMin(60000) == 1);
		assertTrue("60001 ms is 1 min", Utils.Time.millsToMin(60001) == 1);
	}

}
