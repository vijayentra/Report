package com.controller.Report.service;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


import com.medistock.report.entity.SalesReport;
import com.medistock.report.exception.ReportException;
import com.medistock.report.repository.SalesRepository;
import com.medistock.report.serviceimplementation.ReportServiceImpl;


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SalesTest {

    @Mock
    private SalesRepository salesRepository;

    @InjectMocks
    private ReportServiceImpl reportService;

    private SalesReport salesreport;

    @BeforeEach
    public void setup(){
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
    	salesreport = SalesReport.builder()
                .salesId(1)
                .batchCode(101)
                .custCode(10)
                .date(LocalDate.of(2020, 1, 8))
                .quantity(10)
                .price(45).build();
    }


    // JUnit test for createNewStock method
    @DisplayName("JUnit test for create new sales report")
    @Test
    public void givenPurchaseObject_whencreateNewPurchase_thenReturnPurchaseObject(){
        // given - precondition or setup
        given(salesRepository.findById(salesreport.getSalesId()))
                .willReturn(Optional.empty());

        given(salesRepository.save(salesreport)).willReturn(salesreport);

        System.out.println(salesRepository);
        System.out.println(reportService);

        // when -  action or the behaviour that we are going test
        ResponseEntity<SalesReport> savedSalesReport = reportService.createNewSalesReport(salesreport);

        System.out.println(savedSalesReport);
        // then - verify the output
        assertThat(savedSalesReport).isNotNull();
    }

    // JUnit test for saveEmployee method
    @DisplayName("JUnit test for createNewSalesReport method which throws exception")
    @Test
    public void givenExistingId_whenSaveSalesReport_thenThrowsException(){
        // given - precondition or setup
        given(salesRepository.findById(salesreport.getSalesId()))
                .willReturn(Optional.of(salesreport));

        System.out.println(salesRepository);
        System.out.println(reportService);

        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(ReportException.class, () -> {
        	reportService.createNewSalesReport(salesreport);
        });

        // then
        verify(salesRepository, never()).save(any(SalesReport.class));
    }


    // JUnit test for getAllEmployees method
    @DisplayName("JUnit test for getAllSalesReport method (negative scenario)")
    @Test
    public void givenEmptyPuchaseList_whenGetAllPurchaseReport_thenReturnEmptyPurchaseList(){
        // given - precondition or setup
    	
        given(salesRepository.findAll()).willReturn(Collections.emptyList());

        // when -  action or the behaviour that we are going test
        List<SalesReport> salesList = reportService.getAllSalesReport();

        // then - verify the output
        assertThat(salesList).isEmpty();
        assertThat(salesList.size()).isEqualTo(0);
    }

    // JUnit test for upsateSelected purchase report method
//    @DisplayName("JUnit test for updateSelectedPurchaseReport method")
//    @Test
//    public void givenStockId_whenGetStockById_thenReturnStockObject(){
//        // given
//        given(purchaseRepository.findById(1)).willReturn(Optional.of(salesreport));
//
//        // when
//        ResponseEntity<PurchaseReport> savedPurchaseReport = reportService.updateSelectedPurchaseReport(purchasereport.getPurchaseId()).get();
//
//        // then
//        assertThat(savedPurchaseReport).isNotNull();
//
//    }

    // JUnit test for deleteSelectedStock method
    @DisplayName("JUnit test for deleteSelectedSalesReport method")
    @Test
    public void givenStockId_whenDeleteStock_thenNothing() throws ReportException{
        // given - precondition or setup
        int id = 1;

        willDoNothing().given(salesRepository).deleteById(id);

        // when -  action or the behaviour that we are going test
        reportService.deleteSelectedSalesReport(id);

        // then - verify the output
        verify(salesRepository, times(1)).deleteById(id);
    }
}