package com.bottomline.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bottomline.model.PaymentPlan;

public interface PaymentPlanRepo extends JpaRepository<PaymentPlan, Long>{
	
}
