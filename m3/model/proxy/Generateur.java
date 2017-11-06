package model.proxy;

import java.util.ArrayList;

import model.observer.Subject;

public interface Generateur extends Subject {
	
	ArrayList<Canal> canaux = new ArrayList<>();
	
	public int getValue();
}
