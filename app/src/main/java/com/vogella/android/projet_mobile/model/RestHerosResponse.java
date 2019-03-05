package com.vogella.android.projet_mobile.model;

import java.util.List;

public class RestHerosResponse {
    private int count;
    private String next;
    private String previous;
    private List<Hero> results;  //faux changer results

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Hero> getResults() {
        return results;
    }

    public void setResults(List<Hero> results) {
        this.results = results;
    }
}


