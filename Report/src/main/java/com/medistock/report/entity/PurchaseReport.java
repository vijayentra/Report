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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "purchase_report")
public class PurchaseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PurchaseId", nullable = false)
    private int purchaseId;

    private int batchcode;

    private LocalDate purchasedate;

    private int quantity;

    private double price;


    
//    public PurchaseReport() {
//        super();
//    }
//
//	public PurchaseReport(int purchaseId, int batchcode, LocalDate purchasedate, int quantity, double price) {
//		super();
//		this.purchaseId = purchaseId;
//		this.batchcode = batchcode;
//		this.purchasedate = purchasedate;
//		this.quantity = quantity;
//		this.price = price;
//	}
//
//	public int getPurchaseId() {
//		return purchaseId;
//	}
//
//	public void setPurchaseId(int purchaseId) {
//		this.purchaseId = purchaseId;
//	}
//
//	public int getbatchcode() {
//		return batchcode;
//	}
//
//	public void setbatchcode(int batchcode) {
//		this.batchcode = batchcode;
//	}
//
//	public LocalDate getPurchasedate() {
//		return purchasedate;
//	}
//
//	public void setPurchasedate(LocalDate purchasedate) {
//		this.purchasedate = purchasedate;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	@Override
//    public String toString() {
//        return "Purchase{" +
//                "purchaseId=" + purchaseId +
//                ", batchcode=" + batchcode +
//                ", purchasedate=" + purchasedate +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }
}