package main.java.m3.model.proxy;

import main.java.m3.model.observer.Subject;

import java.util.ArrayList;

public interface Generateur extends Subject {

    ArrayList<Canal> canaux = new ArrayList<>();

    public int getValue();
}
