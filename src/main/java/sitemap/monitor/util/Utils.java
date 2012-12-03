package sitemap.monitor.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Place conversions here that may be of use across the app.
 * 
 * @author RNOR
 *
 */
public class Utils {

	public static class Time {
		
		public static int MILLS_PER_MIN = 60000 ;
		
		/**
		 * @param mills mills to convert
		 * @return Minutes (Rounding half up)
		 */
		public static long millsToMin(long mills) {
			return new BigDecimal(mills).divide(BigDecimal.valueOf(MILLS_PER_MIN), RoundingMode.HALF_UP).longValue();
		}
	}
	
	public static class Strings {
		
		public static String safe(final Object str) {
			return null == str ? "" : str.toString();
		}
	}
	
	public static class Pojo {
		
		public static int nullCompare(Object o1, Object o2) {
			return null == o1 && null != o2 ? -1 : (null != o1 && null == o2) ? 1 : 0;
		}
	}
}
