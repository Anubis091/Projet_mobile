package com.vogella.android.projet_mobile.model;

import java.util.List;

public class RestHerosResponse {
    private int count;
    private List<Hero> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Hero> getResults() {
        return results;
    }

    public void setResults(List<Hero> results) {
        this.results = results;
    }
}


