package catalog;

import model.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog<T extends LibraryItem> {

    private List<T> items;

    public LibraryCatalog() {
        items = new ArrayList<>();
    }

    // Add item
    public void add(T item) {
        items.add(item);
    }

    // Remove item
    public void remove(T item) {
        items.remove(item);
    }

    // Find by ID
    public T findById(String id) {

        for (T item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

        return null;
    }

    // Get all items
    public List<T> getItems() {
        return items;
    }
}