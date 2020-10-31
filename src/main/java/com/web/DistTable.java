package com.web;

public class DistTable {
    Object Dist,State,ConfW,ConfT,Info;

    public Object getDist() {
        return Dist;
    }

    public void setDist(Object dist) {
        this.Dist = dist;
    }

    public Object getState() {
        return State;
    }

    public void setState(Object state) {
        this.State = state;
    }

    public Object getConfW() {
        return ConfW;
    }

    public void setConfW(Object confW) {
        this.ConfW = confW;
    }

    public Object getConfT() {
        return ConfT;
    }

    public void setConfT(Object confT) {
        this.ConfT = confT;
    }

    public Object getInfo() {
        return Info;
    }

    public void setInfo(Object info) {
        this.Info = info;
    }

    public DistTable(Object dist, Object state, Object confW, Object confT, Object info) {
        this.Dist = dist;
        this.State = state;
        this.ConfW = confW;
        this.ConfT = confT;
        this.Info = info;
    }
}

