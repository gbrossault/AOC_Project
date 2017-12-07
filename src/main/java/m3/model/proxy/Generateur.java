package main.java.m3.model.proxy;

import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.observer.AsyncSubject;

import java.util.ArrayList;

public class Generateur implements AsyncSubject<Generateur> {

    ArrayList<Canal> canaux = new ArrayList<>();

    public int getValue() {
    	return 0;
    }

	@Override
	public void attach(AsyncObserver<Generateur> o) {
	}

	@Override
	public void detach(AsyncObserver<Generateur> o) {
	}

	@Override
	public void notifyAsyncObserver() {
	}

	public void genererValue() {
	}
	
	//public setStrategy();
}
