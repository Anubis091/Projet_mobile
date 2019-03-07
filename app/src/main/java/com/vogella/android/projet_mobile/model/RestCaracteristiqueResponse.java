package com.vogella.android.projet_mobile.model;

import java.util.List;

public class RestCaracteristiqueResponse {
    private List<Caracteristique> results;

    public List<Caracteristique> getResults() {
        return results;
    }

    public void setResults(List<Caracteristique> results) {
        this.results = results;
    }
}
