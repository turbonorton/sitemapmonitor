package sitemap.monitor.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sitemap.monitor.util.Utils;

public class StringsUtilsTest {

	private Object testObject;
	
	@Before
	public void setUp() {
		 testObject = new Object() { 
				@Override
				public String toString() {
					return "wibble";
				}
			};
	}
	
	@Test
	public void testNull() {
		assertEquals("", Utils.Strings.safe(null));
	}

	@Test
	public void testNotChanged() {
		assertEquals("t", Utils.Strings.safe("t"));
	}
	
	@Test
	public void testToStringNotChanged() {
		assertEquals("wibble", Utils.Strings.safe(testObject));
	}
}
