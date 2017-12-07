package main.java.m3.model.proxy;

import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.observer.AsyncSubject;

import java.util.ArrayList;

public class Generateur implements AsyncSubject<Generateur> {

    ArrayList<AsyncObserver<Generateur>> canaux = new ArrayList<>();

    private int value = 0;
    
    public int getValue() {
    	System.out.println("Generateur -> getValue : " +this.value);
    	return value;
    }

	@Override
	public void attach(AsyncObserver<Generateur> o) {
		this.canaux.add(o);
	}

	@Override
	public void detach(AsyncObserver<Generateur> o) {
		this.canaux.remove(o);
	}

	@Override
	public void notifyAsyncObservers() {
		for(AsyncObserver<Generateur> canal : this.canaux) {
			System.out.println("Update canal");
			canal.update(this);
		}
	}

	public void genererValue() throws InterruptedException {
		this.value++;
		System.out.println("New generated value");
		this.notifyAsyncObservers();
	}
	
	//public setStrategy();
}
