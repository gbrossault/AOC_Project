package main.java.m3.model.proxy;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import main.java.m3.model.GenerateurAsync;
import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.observer.Observateur;
import main.java.m3.model.observer.Subject;

public class Canal implements Subject<GenerateurAsync>, AsyncObserver<Generateur>, GenerateurAsync {
	
	private Generateur generateur;
	private Observateur afficheur;
	private ScheduledExecutorService executorService;
	private long latency;
	
	public Canal(Generateur generateur, int latency) {
		this.executorService = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
		this.generateur = generateur;
		this.latency = latency;
	}
	
	@Override
	public Future<Integer> getValue() {
		return executorService.submit(()->{
			return this.generateur.getValue();
		});
	}

	@Override
	public Future<Void> update(Generateur g) {
		return executorService.schedule(()->{
			notifyObservers();
			return null;
		}, this.latency, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public void attach(Observateur o) {
		this.afficheur = o;
	}

	@Override
	public void detach(Observateur o) {
		this.afficheur = null;
	}

	@Override
	public void notifyObservers() {
		this.afficheur.update(this);
	}

}
