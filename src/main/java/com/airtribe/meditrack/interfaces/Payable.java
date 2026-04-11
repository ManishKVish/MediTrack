package com.airtribe.meditrack.interfaces;

import com.airtribe.meditrack.entity.Bill;

/**
 * Interface for entities that can be paid.
 * Demonstrates multiple inheritance and default methods.
 */
public interface Payable {
    /**
     * Returns the total amount to be paid.
     */
    double getAmount();

    /**
     * Returns the currency (default: INR).
     */
    default String getCurrency() {
        return "INR";
    }

    /**
     * Default method to check if payment is overdue.
     */
    default boolean isOverdue() {
        return false;
    }

    /**
     * Default method to apply a discount.
     */
    default double applyDiscount(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        double amount = getAmount();
        return amount - (amount * discountPercent / 100.0);
    }

    /**
     * Static method to create a payment summary.
     */
    static String createPaymentSummary(Payable payable) {
        return String.format("Amount: %.2f %s, Overdue: %s",
                payable.getAmount(),
                payable.getCurrency(),
                payable.isOverdue());
    }

    /**
     * Convert to Bill entity.
     */
    default Bill toBill(String patientId, String description) {
        return new Bill(
                patientId,
                description,
                getAmount(),
                getCurrency()
        );
    }
}