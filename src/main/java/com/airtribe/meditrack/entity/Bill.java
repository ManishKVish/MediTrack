package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.constants.Constants;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Bill entity representing a medical bill.
 * Demonstrates composition with BillSummary, equals/hashCode, and tax calculation.
 */
public class Bill {
    private String id;
    private String appointmentId;
    private double consultationFee;
    private double medicationCost;
    private double taxRate; // percentage
    private LocalDate issueDate;
    private boolean paid;

    public Bill(String id, String appointmentId, double consultationFee,
                double medicationCost, double taxRate, LocalDate issueDate, boolean paid) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.consultationFee = consultationFee;
        this.medicationCost = medicationCost;
        this.taxRate = taxRate;
        this.issueDate = issueDate;
        this.paid = paid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double getMedicationCost() {
        return medicationCost;
    }

    public void setMedicationCost(double medicationCost) {
        this.medicationCost = medicationCost;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    // Business logic methods
    public double calculateSubtotal() {
        return consultationFee + medicationCost;
    }

    public double calculateTax() {
        return calculateSubtotal() * (taxRate / 100.0);
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    // Create an immutable BillSummary
    public BillSummary generateBillSummary() {
        return new BillSummary(id, appointmentId, calculateSubtotal(),
                calculateTax(), calculateTotal(), issueDate, paid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", consultationFee=" + consultationFee +
                ", medicationCost=" + medicationCost +
                ", taxRate=" + taxRate +
                ", issueDate=" + issueDate +
                ", paid=" + paid +
                ", total=" + calculateTotal() +
                '}';
    }
}