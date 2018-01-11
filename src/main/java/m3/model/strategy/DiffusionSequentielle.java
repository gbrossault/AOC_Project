package main.java.m3.model.strategy;

import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.proxy.Generateur;

public class DiffusionSequentielle implements AlgoDiffusion {

	private Generateur generateur;
	private Generateur copieGenerateur;
	private int i;
	
	public DiffusionSequentielle(Generateur generateur) {
		this.generateur = generateur;
		this.copieGenerateur = new Generateur();
	}
	
	@Override
	public void configure() {
		this.i = 0;
	}

	@Override
	public void execute() {
		this.copieGenerateur.setValue(this.generateur.getValue());
		if(i<4) {
			for(AsyncObserver<Generateur> canal : this.generateur.getCanaux()) {
				canal.update(this.copieGenerateur);
				this.i++;
			}
		}
	}

}
