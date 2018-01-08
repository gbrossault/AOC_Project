package main.java.m3.model.strategy;

import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.proxy.Generateur;

public class DiffusionSequentielle implements AlgoDiffusion {

	private Generateur generateur;
	private Generateur copieGenerateur;
	
	public DiffusionSequentielle(Generateur generateur) {
		this.generateur = generateur;
		this.copieGenerateur = new Generateur();
	}
	
	@Override
	public void configure() {
	}

	@Override
	public void execute() {
		this.copieGenerateur.setValue(this.generateur.getValue());
		for(AsyncObserver<Generateur> canal : this.generateur.getCanaux()) {
			canal.update(this.copieGenerateur);
		}
	}

}
