package com.medistock.report.service;

import java.util.*;

import org.springframework.http.ResponseEntity;
import com.medistock.report.entity.PurchaseReport;
import com.medistock.report.entity.SalesReport;
import com.medistock.report.exception.ReportException;

public interface ReportService {

	List<SalesReport> getAllSalesReport();
	ResponseEntity<SalesReport> createNewSalesReport(SalesReport sales);
	ResponseEntity<SalesReport> updateSelectedSalesReport(SalesReport sales);
	ResponseEntity<?> deleteSelectedSalesReport(int Id) throws ReportException;
	
	List<PurchaseReport> getAllPurchaseReport();
	ResponseEntity<PurchaseReport> createNewPurchaseReport(PurchaseReport purchase);
	ResponseEntity<PurchaseReport> updateSelectedPurchaseReport(PurchaseReport purchase);
	ResponseEntity<?> deleteSelectedPurchaseReport(int Id) throws ReportException;

}
