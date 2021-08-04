package com.bottomline.service;

import java.util.List;
import java.util.Optional;

import com.bottomline.model.PaymentPlan;

public interface IPaymentPlanService {
	PaymentPlan createPaymentPlan(PaymentPlan paymentplan);	
	Optional<PaymentPlan> paymentPlanByPaymentId(Long paymentId);
	List<PaymentPlan> paymentPlans();
}
