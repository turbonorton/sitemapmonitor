package sitemap.monitor.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sitemap.monitor.domain.SitemapEntry;
import sitemap.monitor.util.UpdateTimeComparator;

public class UpdateTimeComparatorTests {

	private static final String TEST_TIME= "2012-12-02T13:53:29+00:00";
	private static final String TEST_TIME_A = "2012-12-02T13:53:28+00:00";
	
	private static final String TEST_TIME_B = "2012-12-02T14:53:28+01:00";
	
	private UpdateTimeComparator toTest;
	
	@Before
	public void setUp() throws Exception {
		toTest = new UpdateTimeComparator();
	}

	@Test
	public void testNulls() {
		assertTrue("Nulls should be 0", toTest.compare(null, null) == 0);
		assertTrue("Null should be less than Obj", toTest.compare(null, new SitemapEntry(TEST_TIME)) < 0);
		assertTrue("Obj should be greater than Obj", toTest.compare(new SitemapEntry(TEST_TIME), null) > 0);
	}

	@Test
	public void testCompareEqualTimesSameTimeZone() {
		assertTrue("Should be 0", toTest.compare(new SitemapEntry(TEST_TIME),new SitemapEntry(TEST_TIME)) == 0);
	}
	
	@Test
	public void testCompareLessSameTimeZone() {
		assertTrue("Should be < 0", toTest.compare(new SitemapEntry(TEST_TIME_A),new SitemapEntry(TEST_TIME)) < 0);
	}
	
	@Test
	public void testCompareGreaterSameTimeZone() {
		assertTrue("Should be > 0", toTest.compare(new SitemapEntry(TEST_TIME),new SitemapEntry(TEST_TIME_A)) > 0);
	}
	
	@Test
	public void testCompareEqualTimesDiffOffset() {
		assertTrue("Should be 0", toTest.compare(new SitemapEntry(TEST_TIME_B),new SitemapEntry(TEST_TIME_B)) == 0);
		
		assertTrue("Should be 0", toTest.compare(new SitemapEntry(TEST_TIME_A),new SitemapEntry(TEST_TIME_B)) == 0);
	}
	
}
