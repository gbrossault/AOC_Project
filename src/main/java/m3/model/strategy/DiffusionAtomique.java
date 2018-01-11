package main.java.m3.model.strategy;

import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.proxy.Generateur;

public class DiffusionAtomique implements AlgoDiffusion {

	private Generateur generateur;
	private int i;
	
	public DiffusionAtomique(Generateur generateur) {
		this.generateur = generateur;
	}
	
	@Override
	public void configure() {
		this.i = 0;
	}

	@Override
	public void execute() {
		if(i<4) {
			for(AsyncObserver<Generateur> canal : this.generateur.getCanaux()) {
				canal.update(this.generateur);
				this.i++;
			}
		}
	}

}
