package org.skypro.skyshop.search;

public class SearchEngine {
    public int capacity;
    public Searchable[] searchables;
    Searchable[] result = new Searchable[5];

    public SearchEngine (int capacity) {
        
        this.capacity = capacity;
        this.searchables = new Searchable[capacity];

    }

    public Searchable[] search(String term) {

        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            if (searchable.getSearchTerm().contains(term)) {
                result [count++] = searchable;
                if (count == 5) break;
            }
        }
        return result;
        
    }

    public void printResult() {
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                System.out.println(result[i]);
            }
        }
    }

    public void add(Searchable engine) {

        for (int i = 0; i < capacity; i++) {
            if (searchables[i] == null) {
                searchables[i] = engine;
                break;
            }
        }

    }
}
