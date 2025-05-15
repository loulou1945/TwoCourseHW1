package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    LinkedList<Searchable> searchables = new LinkedList<>();
    TreeMap<String, Searchable> result = new TreeMap<>();

    public void add(Searchable engine) {
        searchables.add(engine);
    }

    public TreeMap<String, Searchable> search(String term) {
        for (Searchable searchable : searchables){
            if (searchable.getName().contains(term)){
                result.putIfAbsent(searchable.getName(), searchable);
            }
        }
        return result;
    }

    public void printResult() {
        for (Map.Entry<String, Searchable> entry : result.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
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
