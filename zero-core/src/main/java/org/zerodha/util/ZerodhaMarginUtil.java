package org.zerodha.util;

import org.zerodha.domain.Brokerage;

public class ZerodhaMarginUtil {
	
	public static double fetchTurnOver(Brokerage brokerage) {
		if(brokerage!=null) {
			return NumberUtil.round(brokerage.getBuyAmt()+brokerage.getSellAmt());
		}
		return 0.0;
	}
	
	public static double fetchTotalSell(Brokerage brokerage) {
		if(brokerage!=null) {
			return NumberUtil.round(brokerage.getSellAmt() * brokerage.getQuantity());
		}
		return 0.0;
	}
	
	public static double fetchTotalBuy(Brokerage brokerage) {
		if(brokerage!=null) {
			return NumberUtil.round(brokerage.getBuyAmt() * brokerage.getQuantity());
		}
		return 0.0;
	}
}
