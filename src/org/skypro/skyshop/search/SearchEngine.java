package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable engine) {
        searchables.add(engine);
    }

    public TreeSet<Searchable> search(String term) {
        return searchables.stream()
                .filter(i -> i.getName().toLowerCase().contains(term.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparable())));
    }

    public static class SearchableComparable implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s2.getName().compareToIgnoreCase(s1.getName());
        }
    }

    public Searchable foundBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxFound = 0;
        int score;
        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            if (searchable.getSearchTerm().contains(search)) {
                String str = searchable.getSearchTerm();
                score = resultMaxFound(str, search);
                if (score > maxFound) {
                    maxFound = score;
                    bestResult = searchable;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound("Объект не найден");
        }
        return bestResult;
    }


    private int resultMaxFound(String str, String subStr) {
        int score = 0;
        int index = 0;
        int indexSubStr = str.indexOf(subStr, index);
        while (indexSubStr != -1) {
            score++;
            index = indexSubStr + subStr.length();
            indexSubStr = str.indexOf(subStr, index);
        }
        return score;
    }

}
