package main.java.m3.model.proxy;

import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.observer.AsyncSubject;
import main.java.m3.model.strategy.AlgoDiffusion;

import java.util.ArrayList;

public class Generateur implements AsyncSubject<Generateur> {

    ArrayList<AsyncObserver<Generateur>> canaux = new ArrayList<>();
    AlgoDiffusion algo;
    
    private int value = 0;
    
    public void setValue(int value) {
    	this.value = value;
    }
    
    public int getValue() {
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
			canal.update(this);
		}
	}
	
	public ArrayList<AsyncObserver<Generateur>> getCanaux(){
		return this.canaux;
	}
	
	public void setAlgo(AlgoDiffusion algo) {
		this.algo = algo;
	}

	public void genererValue() {
		try {
			Thread.sleep(2000);
			this.value++;
			this.algo.execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
