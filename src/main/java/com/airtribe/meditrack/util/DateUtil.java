package com.airtribe.meditrack.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility for date/time formatting and parsing.
 * Demonstrates static methods, exception handling, and Java 8 Time API.
 */
public final class DateUtil {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private DateUtil() {}

    public static String formatDate(LocalDate date) {
        if (date == null) return "";
        return date.format(DATE_FORMATTER);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return "";
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    public static LocalDate parseDate(String dateStr) throws DateTimeParseException {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) throws DateTimeParseException {
        return LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER);
    }

    public static boolean isFuture(LocalDateTime dateTime) {
        return dateTime.isAfter(LocalDateTime.now());
    }

    public static boolean isPast(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalDateTime addHours(LocalDateTime dateTime, int hours) {
        return dateTime.plusHours(hours);
    }

    public static LocalDateTime addDays(LocalDateTime dateTime, int days) {
        return dateTime.plusDays(days);
    }
}