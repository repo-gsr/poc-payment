package com.bottomline.rest.dto;

import java.math.BigDecimal;

import com.bottomline.model.PaymentPlan;

public class PaymentPlanDto {
	private BigDecimal totalAmount;
	private int numberOfPayments;

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getNumberOfPayments() {
		return numberOfPayments;
	}

	public void setNumberOfPayments(int numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
	}
	
	public PaymentPlan toModel() {
		PaymentPlan paymentPlan = new PaymentPlan();
		paymentPlan.setTotalAmount(this.totalAmount);
		paymentPlan.setNumberOfPayments(this.numberOfPayments);
		return paymentPlan;
	}
}
