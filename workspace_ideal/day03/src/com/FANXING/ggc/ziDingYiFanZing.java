package com.FANXING.ggc;

public class ziDingYiFanZing<T>{
    private int id;
    private String name;
    private T doc;

    public ziDingYiFanZing() {
    }

    public ziDingYiFanZing(int id, String name, T doc) {
        this.id = id;
        this.name = name;
        this.doc = doc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getDoc() {
        return doc;
    }

    public void setDoc(T doc) {
        this.doc = doc;
    }
}
