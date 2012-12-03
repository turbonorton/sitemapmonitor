package sitemap.monitor.util;

import static org.junit.Assert.*;

import org.junit.Test;

import sitemap.monitor.util.Utils;

public class PojoUtilsTest {

	@Test
	public void testEqual() {
		assertEquals(0, Utils.Pojo.nullCompare(null, null));
		assertEquals(0, Utils.Pojo.nullCompare(new Object(), new Object()));
	}

	@Test
	public void testNotEqual() {
		assertEquals(-1, Utils.Pojo.nullCompare(null, new Object()));
		assertEquals(1, Utils.Pojo.nullCompare(new Object(), null));
	}
}
