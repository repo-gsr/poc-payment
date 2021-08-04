package com.bottomline.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bottomline.model.PaymentPlan;
import com.bottomline.repo.PaymentPlanRepo;

@Service
public class PaymentPlanService implements IPaymentPlanService {

	@Autowired
	private PaymentPlanRepo paymentPlanRepo;
	
	/*
	 * (non-Javadoc)
	 * @see com.bottomline.service.IPaymentPlanService#createPaymentPlan(com.bottomline.model.PaymentPlan)
	 */

	@Override
	public PaymentPlan createPaymentPlan(PaymentPlan paymentplan) {
		
		BigDecimal regularPaymentAmount = paymentplan.getTotalAmount()
				.divide(BigDecimal.valueOf(paymentplan.getNumberOfPayments()), 2, RoundingMode.HALF_UP);
		
		BigDecimal mainPayment = paymentplan.getTotalAmount().divide(BigDecimal.valueOf(paymentplan.getNumberOfPayments()),10, RoundingMode.HALF_UP);
		
		BigDecimal differenceAmount = mainPayment.subtract(regularPaymentAmount).multiply(BigDecimal.valueOf(paymentplan.getNumberOfPayments()));
		
		BigDecimal lastAmount = differenceAmount.add(regularPaymentAmount);
			
		paymentplan.setRegularPaymentAmount(regularPaymentAmount);

		paymentplan.setLastAmount(lastAmount.setScale(2, BigDecimal.ROUND_HALF_UP));
		return paymentPlanRepo.save(paymentplan);
	}

	@Override
	public Optional<PaymentPlan> paymentPlanByPaymentId(Long paymentId) {
		return paymentPlanRepo.findById(paymentId);
	}

	@Override
	public List<PaymentPlan> paymentPlans() {
		return paymentPlanRepo.findAll();
	}

}
