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

import com.medistock.report.entity.PurchaseReport;
import com.medistock.report.exception.ReportException;
import com.medistock.report.repository.PurchaseRepository;
import com.medistock.report.serviceimplementation.ReportServiceImpl;

import lombok.Builder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PurchaseTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private ReportServiceImpl reportService;

    private PurchaseReport purchasereport;

    @BeforeEach
    public void setup(){
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
    	purchasereport = PurchaseReport.builder()
                .purchaseId(1)
                .batchcode(101)
                .purchasedate(LocalDate.of(2020, 1, 8))
                .quantity(10)
                .price(45).build();
    }


    // JUnit test for createNewStock method
    @DisplayName("JUnit test for create new purchase report")
    @Test
    public void givenPurchaseObject_whencreateNewPurchase_thenReturnPurchaseObject(){
        // given - precondition or setup
        given(purchaseRepository.findById(purchasereport.getPurchaseId()))
                .willReturn(Optional.empty());

        given(purchaseRepository.save(purchasereport)).willReturn(purchasereport);

        System.out.println(purchaseRepository);
        System.out.println(reportService);

        // when -  action or the behaviour that we are going test
        ResponseEntity<PurchaseReport> savedPurchaseReport = reportService.createNewPurchaseReport(purchasereport);

        System.out.println(savedPurchaseReport);
        // then - verify the output
        assertThat(savedPurchaseReport).isNotNull();
    }

    // JUnit test for saveEmployee method
    @DisplayName("JUnit test for createNewPurchaseReport method which throws exception")
    @Test
    public void givenExistingId_whenSavePurchaseReport_thenThrowsException(){
        // given - precondition or setup
        given(purchaseRepository.findById(purchasereport.getPurchaseId()))
                .willReturn(Optional.of(purchasereport));

        System.out.println(purchaseRepository);
        System.out.println(reportService);

        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(ReportException.class, () -> {
        	reportService.createNewPurchaseReport(purchasereport);
        });

        // then
        verify(purchaseRepository, never()).save(any(PurchaseReport.class));
    }


    // JUnit test for getAllEmployees method
    @DisplayName("JUnit test for getAllPurchaseReport method (negative scenario)")
    @Test
    public void givenEmptyPuchaseList_whenGetAllPurchaseReport_thenReturnEmptyPurchaseList(){
        // given - precondition or setup
    	
        given(purchaseRepository.findAll()).willReturn(Collections.emptyList());

        // when -  action or the behaviour that we are going test
        List<PurchaseReport> purchaseList = reportService.getAllPurchaseReport();

        // then - verify the output
        assertThat(purchaseList).isEmpty();
        assertThat(purchaseList.size()).isEqualTo(0);
    }

    // JUnit test for upsateSelected purchase report method
//    @DisplayName("JUnit test for updateSelectedPurchaseReport method")
//    @Test
//    public void givenStockId_whenGetStockById_thenReturnStockObject(){
//        // given
//        given(purchaseRepository.findById(1)).willReturn(Optional.of(purchasereport));
//
//        // when
//        ResponseEntity<PurchaseReport> savedPurchaseReport = reportService.updateSelectedPurchaseReport(purchasereport.getPurchaseId()).get();
//
//        // then
//        assertThat(savedPurchaseReport).isNotNull();
//
//    }

    // JUnit test for deleteSelectedStock method
    @DisplayName("JUnit test for deleteSelectedPurchaseReport method")
    @Test
    public void givenStockId_whenDeleteStock_thenNothing() throws ReportException{
        // given - precondition or setup
        int id = 1;

        willDoNothing().given(purchaseRepository).deleteById(id);

        // when -  action or the behaviour that we are going test
        reportService.deleteSelectedPurchaseReport(id);

        // then - verify the output
        verify(purchaseRepository, times(1)).deleteById(id);
    }
}