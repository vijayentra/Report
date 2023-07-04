package com.medistock.report.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sales_report")
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "salesId", nullable = false)
    private int salesId;

    private int batchCode;

    private int custCode;

    private LocalDate date;

    private int quantity;

    private double price;
}

//    public SalesReport() {
//        super();
//    }
//
//    public SalesReport(int salesId, int batchCode, int custCode, LocalDate date, int quantity, double price) {
//        this.salesId = salesId;
//        this.batchCode = batchCode;
//        this.custCode = custCode;
//        this.date = date;
//        this.quantity = quantity;
//        this.price = price;
//    }
//
//    public int getSalesId() {
//        return salesId;
//    }
//
//    public void setSalesId(int salesId) {
//        this.salesId = salesId;
//    }
//
//    public int getBatchCode() {
//        return batchCode;
//    }
//
//    public void setBatchCode(int batchCode) {
//        this.batchCode = batchCode;
//    }
//
//    public int getCustCode() {
//        return custCode;
//    }
//
//    public void setCustCode(int custCode) {
//        this.custCode = custCode;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Sales{" +
//                "salesId=" + salesId +
//                ", batchCode=" + batchCode +
//                ", custCode=" + custCode +
//                ", date=" + date +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }
//}