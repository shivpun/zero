package org.zerodha.domain;

import java.io.Serializable;

import org.zerodha.util.NumberUtil;
import org.zerodha.util.ZerodhaMarginUtil;

public class Margin implements Serializable {
	
	private static final long serialVersionUID = 1666185124503742292L;

	private Brokerage broker;
	
	private double brokerage;
	
	private double turnover;
	
	private double totalBuy;
	
	private double totalSell;
	
	private double etc;
	
	private double gst;
	
	private double stt;
	
	private double sebiCharge;
	
	private double stampDuty;
	
	private double profit;
	
	public Margin(Brokerage broker) {
		this.broker = broker;
		this.turnover = ZerodhaMarginUtil.fetchTurnOver(broker);
		this.totalBuy = ZerodhaMarginUtil.fetchTotalBuy(broker);
		this.totalSell = ZerodhaMarginUtil.fetchTotalSell(broker);
		this.profit = this.totalSell - this.totalBuy;
	}

	public double getBrokerage() {
		this.brokerage = NumberUtil.percent(getTurnover(), 0.01);
		this.brokerage = Math.min(this.brokerage, 20);
		return brokerage;
	}

	public double getTurnover() {
		return turnover;
	}

	public double getTotalBuy() {
		return totalBuy;
	}

	public double getTotalSell() {
		return totalSell;
	}

	public double getEtc() {
		if("NSE".equalsIgnoreCase(broker.getExchange())) {
			this.etc = NumberUtil.percent(getTurnover(), 0.00325);
		} else if("BSE".equalsIgnoreCase(broker.getBroker())) {
			this.etc = NumberUtil.percent(getTurnover(), 0.003);
		}
		return etc;
	}

	public double getGst() {
		this.gst = NumberUtil.percent(getBrokerage()+getGst(), 18);
		return gst;
	}

	public double getStt() {
		this.stt = NumberUtil.percent(getTotalSell(), 0.025);
		return stt;
	}

	public double getSebiCharge() {
		this.sebiCharge = NumberUtil.percent(getTurnover(), 0.0015);
		return sebiCharge;
	}

	public double getStampDuty() {
		this.stampDuty = NumberUtil.percent(getTurnover(), 0.002);
		return stampDuty;
	}
	
	public double getNetPayable() {
		return profit - (getBrokerage()+getEtc()+getGst()+getSebiCharge()+getStampDuty()+getStt());
	}
}
