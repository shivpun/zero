package org.zerodha.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {
	
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
	
	public static double round(double value) {
		BigDecimal decimal = new BigDecimal(value);
		return decimal.setScale(2, RoundingMode.UP).doubleValue();
	}
	
	public static double percent(double value, double percent) {
		BigDecimal percentDecimal = new BigDecimal(percent);
		BigDecimal decimal = new BigDecimal(value);
		decimal.multiply(percentDecimal).divide(ONE_HUNDRED);
		return round(decimal.doubleValue());
	}
}
