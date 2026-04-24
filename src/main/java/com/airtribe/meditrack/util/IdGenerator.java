package com.airtribe.meditrack.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generates unique IDs with a prefix.
 * Demonstrates Singleton pattern (eager and lazy), static blocks, and AtomicInteger.
 */
public class IdGenerator {
    // Singleton instance (eager initialization)
    private static final IdGenerator INSTANCE = new IdGenerator();

    // Counters per prefix
    private final java.util.Map<String, AtomicInteger> counters = new java.util.HashMap<>();

    // Static block for demonstration
    static {
        System.out.println("IdGenerator class loaded.");
    }

    // Private constructor for Singleton
    private IdGenerator() {
        // Initialize with some default prefixes
        counters.put("PAT", new AtomicInteger(1000));
        counters.put("DOC", new AtomicInteger(2000));
        counters.put("APT", new AtomicInteger(3000));
        counters.put("BIL", new AtomicInteger(4000));
    }

    // Eager Singleton accessor
    public static IdGenerator getInstance() {
        return INSTANCE;
    }

    // Lazy Singleton alternative (optional)
    private static class LazyHolder {
        private static final IdGenerator LAZY_INSTANCE = new IdGenerator();
    }

    public static IdGenerator getLazyInstance() {
        return LazyHolder.LAZY_INSTANCE;
    }

    public String generateId(String prefix) {
        AtomicInteger counter = counters.computeIfAbsent(prefix, p -> new AtomicInteger(1));
        int next = counter.incrementAndGet();
        return prefix + "-" + next;
    }

    public void resetCounter(String prefix) {
        counters.put(prefix, new AtomicInteger(0));
    }

    public int getCurrentCount(String prefix) {
        AtomicInteger counter = counters.get(prefix);
        return counter != null ? counter.get() : 0;
    }
}