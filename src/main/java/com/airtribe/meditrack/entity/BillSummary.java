package com.airtribe.meditrack.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Immutable summary of a bill.
 * Demonstrates immutability, final fields, and thread safety.
 */
public final class BillSummary {
    private final String billId;
    private final String appointmentId;
    private final double subtotal;
    private final double tax;
    private final double total;
    private final LocalDate issueDate;
    private final boolean paid;

    public BillSummary(String billId, String appointmentId, double subtotal,
                       double tax, double total, LocalDate issueDate, boolean paid) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
        this.issueDate = issueDate;
        this.paid = paid;
    }

    public String getBillId() {
        return billId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public boolean isPaid() {
        return paid;
    }

    // No setters - immutable

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillSummary that = (BillSummary) o;
        return Double.compare(that.subtotal, subtotal) == 0 &&
                Double.compare(that.tax, tax) == 0 &&
                Double.compare(that.total, total) == 0 &&
                paid == that.paid &&
                Objects.equals(billId, that.billId) &&
                Objects.equals(appointmentId, that.appointmentId) &&
                Objects.equals(issueDate, that.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, appointmentId, subtotal, tax, total, issueDate, paid);
    }

    @Override
    public String toString() {
        return "BillSummary{" +
                "billId='" + billId + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", total=" + total +
                ", issueDate=" + issueDate +
                ", paid=" + paid +
                '}';
    }
}