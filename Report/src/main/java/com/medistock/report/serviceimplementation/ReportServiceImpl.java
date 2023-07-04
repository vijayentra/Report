package com.medistock.report.serviceimplementation;

import java.util.Collection;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medistock.report.entity.PurchaseReport;
import com.medistock.report.entity.SalesReport;
import com.medistock.report.exception.ReportException;
import com.medistock.report.repository.PurchaseRepository;
import com.medistock.report.repository.SalesRepository;
import com.medistock.report.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Override
	public List<PurchaseReport> getAllPurchaseReport() {
		logger.info("The Purchase Report data is received");
		return purchaseRepository.findAll();
	}

	@Override
	public ResponseEntity<PurchaseReport> createNewPurchaseReport(PurchaseReport purchase) {
		PurchaseReport result = purchaseRepository.save(purchase);
		logger.info("New Purchase Report data is added");
		return ResponseEntity.ok().body(result);
	}

	@Override
	public ResponseEntity<PurchaseReport> updateSelectedPurchaseReport(PurchaseReport purchase) {
		PurchaseReport result = purchaseRepository.saveAndFlush(purchase);
		logger.info("The Purchase Report is successfully updated");
		return ResponseEntity.ok().body(result);
	}

	@Override
	public ResponseEntity<?> deleteSelectedPurchaseReport(int id) throws ReportException {
		purchaseRepository.deleteById(id);
		logger.info("The Stock with Id : "+id+" is successfully deleted");
		return ResponseEntity.ok().build();
	}


	public List<SalesReport> getAllSalesReport() {
		logger.info("The Sales Report data is received");
		return salesRepository.findAll();
	}

	@Override
	public ResponseEntity<SalesReport> createNewSalesReport(SalesReport sales) {
		SalesReport result = salesRepository.save(sales);
		logger.info("New Sales Report data is added");
		return ResponseEntity.ok().body(result);
	}

	@Override
	public ResponseEntity<SalesReport> updateSelectedSalesReport(SalesReport sales) {
		SalesReport result = salesRepository.saveAndFlush(sales);
		logger.info("The Sales Report is successfully updated");
		return ResponseEntity.ok().body(result);
	}

	@Override
	public ResponseEntity<?> deleteSelectedSalesReport(int id) throws ReportException  {
		java.util.Optional<SalesReport> fromRepo = salesRepository.findById(id);
		SalesReport user = fromRepo.orElseThrow(() -> new ReportException("Sales Report not found"));
        salesRepository.delete(user);
        logger.info("The Sales Report with Id : "+id+" is successfully deleted");
		return ResponseEntity.ok().build();
	}


	
	




	

	
	
}
