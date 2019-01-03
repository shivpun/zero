package org.zerodha.domain;

import java.io.Serializable;
import java.util.Date;

public class Brokerage implements Serializable {

	private static final long serialVersionUID = -347091148067097850L;

	private String orderId;
	
	private String userId;
	
	private String broker;
	
	private String exchange;
	
	private double buyAmt;
	
	private double sellAmt;
	
	private double quantity;
	
	private Date tradeTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public double getBuyAmt() {
		return buyAmt;
	}

	public void setBuyAmt(double buyAmt) {
		this.buyAmt = buyAmt;
	}

	public double getSellAmt() {
		return sellAmt;
	}

	public void setSellAmt(double sellAmt) {
		this.sellAmt = sellAmt;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brokerage other = (Brokerage) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brokerage [orderId=" + orderId + ", userId=" + userId + ", broker=" + broker + ", exchange=" + exchange
				+ ", buyAmt=" + buyAmt + ", sellAmt=" + sellAmt + ", quantity=" + quantity + ", tradeTime=" + tradeTime
				+ "]";
	}
}
