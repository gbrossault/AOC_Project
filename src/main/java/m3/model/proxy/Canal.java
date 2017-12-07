package main.java.m3.model.proxy;

import java.util.concurrent.Future;

import main.java.m3.model.GenerateurAsync;
import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.observer.Observateur;
import main.java.m3.model.observer.Subject;

public class Canal implements Subject<GenerateurAsync>, AsyncObserver<Generateur>, GenerateurAsync {

	@Override
	public Future<Integer> getValue() {
		return null;
	}

	@Override
	public Future<Void> update(Generateur t) {
		return null;
	}
	
	@Override
	public void attach(Observateur o) {
	}

	@Override
	public void detach(Observateur o) {
	}

	@Override
	public void notifyObservers() {		
	}

}
