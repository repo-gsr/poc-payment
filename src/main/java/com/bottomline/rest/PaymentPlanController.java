package com.bottomline.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bottomline.model.PaymentPlan;
import com.bottomline.rest.dto.PaymentPlanDto;
import com.bottomline.service.PaymentPlanService;

@RestController("/v1/payment")
public class PaymentPlanController {

	@Autowired
	PaymentPlanService paymentPlanService;

	@PostMapping
	public ResponseEntity<PaymentPlan> preparePaymentPlan(@RequestBody PaymentPlanDto paymentPlan) {
		return new ResponseEntity<>(paymentPlanService.createPaymentPlan(paymentPlan.toModel()), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<PaymentPlan> getPaymentPlanByPaymentId(@RequestParam("paymentId") String paymentId) {

		Optional<PaymentPlan> paymentPlanDetails = paymentPlanService.paymentPlanByPaymentId(Long.parseLong(paymentId));
		if (paymentPlanDetails.isPresent()) {
			return new ResponseEntity<>(paymentPlanDetails.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllPaymentPlans")
	public ResponseEntity<List<PaymentPlan>> getPaymentPlans() {
		return new ResponseEntity<>(paymentPlanService.paymentPlans(), HttpStatus.OK);
	}
}
