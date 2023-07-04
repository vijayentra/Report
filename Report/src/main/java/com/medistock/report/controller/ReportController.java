package com.medistock.report.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medistock.report.entity.PurchaseReport;
import com.medistock.report.entity.SalesReport;
import com.medistock.report.exception.ReportException;
import com.medistock.report.service.ReportService;


@RestController
@RequestMapping("/report")
public class ReportController  {

	
	@Autowired
	
	private ReportService reportService;

	public ReportController(ReportService reportService) {
		super();
		this.reportService = reportService;
	}
	
	
	@GetMapping("/all-salesreport")
	List<SalesReport> getAllSalesReport(){
		return reportService.getAllSalesReport();
	}
	
	@PostMapping("/add-salesreport")
	ResponseEntity<SalesReport> createNewSalesReport(@Validated @RequestBody SalesReport sales){
		return reportService.createNewSalesReport(sales);
	}
	
	@PutMapping("/update-salesreport/{id}")
	ResponseEntity<SalesReport> updateExpense(@Validated @RequestBody SalesReport sales){
		return reportService.updateSelectedSalesReport(sales);
	}
	
	@DeleteMapping("/delete-salesreport/{id}")
	ResponseEntity<?> deleteSelectedSalesReport(@PathVariable int id) throws ReportException{
		return reportService.deleteSelectedSalesReport(id);
	}
	
	//purchase controller
	
	@GetMapping("/all-purchasereport")
	List<PurchaseReport> getAllPurchaseReport(){
		return reportService.getAllPurchaseReport();
	}
	
	@PostMapping("/add-purchasereport")
	ResponseEntity<PurchaseReport> createNewPurchaseReport(@Validated @RequestBody PurchaseReport purchase){
		return reportService.createNewPurchaseReport(purchase);
	}
	
	@PutMapping("/update-purchasereport/{id}")
	ResponseEntity<PurchaseReport> updateSelectedPurchaseReport(@Validated @RequestBody PurchaseReport purchase){
		return reportService.updateSelectedPurchaseReport(purchase);
	}
	
	@DeleteMapping("/delete-purchasereport/{id}")
	ResponseEntity<?> deleteSelectedPurchaseReport(@PathVariable int id) throws ReportException{
		return reportService.deleteSelectedPurchaseReport(id);
	}
	
}

