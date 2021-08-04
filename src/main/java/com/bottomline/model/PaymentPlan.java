package com.bottomline.model;

import java.math.BigDecimal;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentplan")
public class PaymentPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentId", unique = true)
	private Long paymentId;

	@Column(name = "totalAmount")
	private BigDecimal totalAmount;

	@Column(name = "numberOfPayments")
	private int numberOfPayments;

	@Column(name = "regularPaymentAmount", nullable = true)
	private BigDecimal regularPaymentAmount;

	@Column(name = "lastAmount", nullable = true)
	private BigDecimal lastAmount;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

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

	public Optional<BigDecimal> getRegularPaymentAmount() {
		return Optional.ofNullable(regularPaymentAmount);
	}

	public void setRegularPaymentAmount(BigDecimal regularPaymentAmount) {
		this.regularPaymentAmount = regularPaymentAmount;
	}

	public Optional<BigDecimal> getLastAmount() {
		return Optional.ofNullable(lastAmount);
	}

	public void setLastAmount(BigDecimal lastAmount) {
		this.lastAmount = lastAmount;
	}
}
