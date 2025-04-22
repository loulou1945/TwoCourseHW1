package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();

    String getTypeContent();

    default String getStringRepresentation() {
        return getSearchTerm() + " " + getTypeContent();
    }

}
