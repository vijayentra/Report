package com.medistock.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.medistock.report.entity.SalesReport;


public interface SalesRepository extends JpaRepository<SalesReport, Integer> {
	
	
	
}

