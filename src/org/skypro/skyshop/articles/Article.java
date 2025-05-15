package org.skypro.skyshop.articles;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private final String titleArticle;
    private final String textArticle;

    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }

    @Override
    public String toString() {
        return "Название статьи: " + titleArticle + "\n"
                + "Текст статьи: " + textArticle;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }

    @Override
    public String getName() {
        return titleArticle;
    }
}

