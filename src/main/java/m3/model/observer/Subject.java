package main.java.m3.model.observer;

import main.java.m3.model.observer.Observateur;

public interface Subject<T> {
	
	public void attach(Observateur o);
	
	public void detach(Observateur o);
	
	public void notifyObservers();
	
	//public ListcAsync getObserver();
	
}
