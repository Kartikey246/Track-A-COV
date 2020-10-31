package com.web;

public class StateTable {
    Object State,Cnft,Cnfnw,Rcvt,Rcvnw,Dect,Decnw;

    public void setState(Object state) {
        State = state;
    }

    public void setCnft(Object cnft) {
        Cnft = cnft;
    }

    public void setCnfnw(Object cnfnw) {
        Cnfnw = cnfnw;
    }

    public void setRcvt(Object rcvt) {
        Rcvt = rcvt;
    }

    public void setRcvnw(Object rcvnw) {
        Rcvnw = rcvnw;
    }

    public void setDect(Object dect) {
        Dect = dect;
    }

    public void setDecnw(Object decnw) {
        Decnw = decnw;
    }

    public Object getState() {
        return State;
    }

    public Object getCnft() {
        return Cnft;
    }

    public Object getCnfnw() {
        return Cnfnw;
    }

    public Object getRcvt() {
        return Rcvt;
    }

    public Object getRcvnw() {
        return Rcvnw;
    }

    public Object getDect() {
        return Dect;
    }

    public Object getDecnw() {
        return Decnw;
    }

    public StateTable(Object State, Object Cnft, Object Cnfnw, Object Rcvt, Object Rcvnw, Object Dect, Object Decnw){
        this.State=State;
        this.Cnft=Cnft;
        this.Cnfnw=Cnfnw;
        this.Rcvt=Rcvt;
        this.Rcvnw=Rcvnw;
        this.Dect=Dect;
        this.Decnw=Decnw;
    }

}