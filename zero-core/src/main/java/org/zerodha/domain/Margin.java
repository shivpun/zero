package org.zerodha.domain;

import java.io.Serializable;

import org.zerodha.util.ZerodhaMarginUtil;

public class Margin implements Serializable {

	private static final long serialVersionUID = 1666185124503742292L;

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
		this.turnover = ZerodhaMarginUtil.fetchTurnOver(broker);
		this.totalBuy = ZerodhaMarginUtil.fetchTotalBuy(broker);
		this.totalSell = ZerodhaMarginUtil.fetchTotalSell(broker);
		this.profit = this.totalSell - this.totalBuy;
		this.brokerage = ZerodhaMarginUtil.fetchBrokerage(this.turnover);
		this.etc = ZerodhaMarginUtil.fetchExchangeTnx(broker.getExchange(), turnover);
		this.gst = ZerodhaMarginUtil.fetchGST(brokerage, etc);
		this.stt = ZerodhaMarginUtil.fetchSTT(totalSell);
		this.sebiCharge = ZerodhaMarginUtil.fetchSEBICharge(turnover);
		this.stampDuty = ZerodhaMarginUtil.fetchStampDuty(turnover);
	}

	public double getBrokerage() {
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
		return etc;
	}

	public double getGst() {
		return gst;
	}

	public double getStt() {
		return stt;
	}

	public double getSebiCharge() {
		return sebiCharge;
	}

	public double getStampDuty() {
		return stampDuty;
	}

	public double getNetPayable() {
		return profit - (getBrokerage() + getEtc() + getGst() + getSebiCharge() + getStampDuty() + getStt());
	}
}
