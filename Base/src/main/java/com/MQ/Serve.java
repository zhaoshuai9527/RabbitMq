package com.MQ;

import java.io.Serializable;

public class Serve implements Serializable {
    private int id;
    private String name;

    public Serve(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Serve() {
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
}
