package com.vogella.android.projet_mobile.model;

import java.util.List;

public class RestMapResponse {
    private int count;
    private List<Map> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public List<Map> getResults() {
        return results;
    }

    public void setResults(List<Map> results) {
        this.results = results;
    }
}
