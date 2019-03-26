package com.example.androidproject.model;

import com.example.androidproject.model.Technologies;

import java.util.List;

public class RestTechnologiesResponse {

    private int count;
    private String next;
    private String previous;
    private List<Technologies> results;

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

    public List<Technologies> getResults() {
        return results;
    }

    public void setResults(List<Technologies> results) {
        this.results = results;
    }
}
