package me.cepi.gameplay.modules.util;

public class Pair<A, B> {
    private A first = null;
    private B second = null;
    
    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
    
    public void set(A first, B second) {
    	this.first = first;
    	this.second = second;
    }

}