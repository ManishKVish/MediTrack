package com.airtribe.meditrack.interfaces;

/**
 * Interface for entities that can be searched.
 * Demonstrates default methods and functional interface.
 */
public interface Searchable {
    /**
     * Returns a unique identifier for the entity.
     */
    String getId();

    /**
     * Returns a display name for the entity.
     */
    String getName();

    /**
     * Default method to check if entity matches a keyword.
     */
    default boolean matches(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return false;
        }
        String lowerKeyword = keyword.toLowerCase();
        return getId().toLowerCase().contains(lowerKeyword) ||
               getName().toLowerCase().contains(lowerKeyword);
    }

    /**
     * Default method to provide a search summary.
     */
    default String getSearchSummary() {
        return "ID: " + getId() + ", Name: " + getName();
    }
}