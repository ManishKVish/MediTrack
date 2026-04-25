package com.airtribe.meditrack.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Generic in‑memory data store for any entity type.
 * Demonstrates generics, collections, and CRUD operations.
 */
public class DataStore<T> {
    private final Map<String, T> storage = new HashMap<>();
    private final IdGenerator idGenerator;

    public DataStore(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public String add(T item, String prefix) {
        String id = idGenerator.generateId(prefix);
        // Assume T has a setId method? Not generic; we'll need reflection or interface.
        // For simplicity, we'll just store with generated ID.
        // In real usage, we'd need to set ID on the entity.
        storage.put(id, item);
        return id;
    }

    public void addWithId(String id, T item) {
        storage.put(id, item);
    }

    public T get(String id) {
        return storage.get(id);
    }

    public List<T> getAll() {
        return new ArrayList<>(storage.values());
    }

    public boolean update(String id, T updatedItem) {
        if (storage.containsKey(id)) {
            storage.put(id, updatedItem);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        return storage.remove(id) != null;
    }

    public List<T> search(Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T item : storage.values()) {
            if (predicate.test(item)) {
                results.add(item);
            }
        }
        return results;
    }

    public int size() {
        return storage.size();
    }

    public void clear() {
        storage.clear();
    }

    public Map<String, T> getStorage() {
        return new HashMap<>(storage);
    }
}