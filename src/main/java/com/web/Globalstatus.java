package com.web;

public class Globalstatus {
    public Object cases;
    public Object deaths;
    public Object recovered;

    public Globalstatus(Object cases, Object deaths, Object recovered) {
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public Object getCases() {
        return cases;
    }

    public void setCases(Object cases) {
        this.cases = cases;
    }

    public Object getDeaths() {
        return deaths;
    }

    public void setDeaths(Object deaths) {
        this.deaths = deaths;
    }

    public Object getRecovered() {
        return recovered;
    }

    public void setRecovered(Object recovered) {
        this.recovered = recovered;
    }
}



