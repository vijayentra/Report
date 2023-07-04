package com.medistock.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.medistock.report.entity.PurchaseReport;


public interface PurchaseRepository extends JpaRepository<PurchaseReport, Integer> {
	
}
