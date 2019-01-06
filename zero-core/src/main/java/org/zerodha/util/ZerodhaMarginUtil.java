package org.zerodha.util;

import org.zerodha.domain.Brokerage;

public class ZerodhaMarginUtil {

	public static double fetchTurnOver(Brokerage brokerage) {
		if (brokerage != null) {
			return NumberUtil.round(brokerage.getBuyAmt() + brokerage.getSellAmt());
		}
		return 0.0;
	}

	public static double fetchTotalSell(Brokerage brokerage) {
		if (brokerage != null) {
			return NumberUtil.round(brokerage.getSellAmt() * brokerage.getQuantity());
		}
		return 0.0;
	}

	public static double fetchTotalBuy(Brokerage brokerage) {
		if (brokerage != null) {
			return NumberUtil.round(brokerage.getBuyAmt() * brokerage.getQuantity());
		}
		return 0.0;
	}

	public static double fetchBrokerage(double turnover) {
		double brokerage = NumberUtil.percent(turnover, 0.01);
		return Math.min(brokerage, 20);
	}

	public static double fetchExchangeTnx(String exchange, double turnover) {
		double exchangeTnx = 0.00;
		if ("NSE".equalsIgnoreCase(exchange)) {
			exchangeTnx = NumberUtil.percent(turnover, 0.00325);
		} else if ("BSE".equalsIgnoreCase(exchange)) {
			exchangeTnx = NumberUtil.percent(turnover, 0.003);
		}
		return exchangeTnx;
	}

	public static double fetchGST(double brokerage, double exchangeTnx) {
		return NumberUtil.percent(brokerage + exchangeTnx, 18);
	}

	public static double fetchSTT(double totalSell) {
		return NumberUtil.percent(totalSell, 0.025);
	}

	public static double fetchStampDuty(double turnover) {
		return NumberUtil.percent(turnover, 0.002);
	}
	
	public static double fetchSEBICharge(double turnover) {
		return NumberUtil.percent(turnover, 0.0015);
	}
}
