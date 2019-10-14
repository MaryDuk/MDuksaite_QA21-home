package com.telran.selenium.model;

public class SearchData {
    public String searchTitle;

    public String getSearchTitle() {
        return searchTitle;
    }

    public SearchData setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
        return this;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "searchTitle='" + searchTitle + '\'' +
                '}';
    }
}
