package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();

    String getTypeContent();

    String getName();

    default String getStringRepresentation() {
        return getSearchTerm() + " " + getTypeContent();
    }

}
