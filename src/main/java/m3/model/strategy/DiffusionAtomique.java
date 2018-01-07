package main.java.m3.model.strategy;

import main.java.m3.model.GenerateurAsync;
import main.java.m3.model.observer.AsyncObserver;
import main.java.m3.model.proxy.Generateur;

public class DiffusionAtomique implements AlgoDiffusion {

	private Generateur generateur;
	
	public DiffusionAtomique(Generateur generateur) {
		this.generateur = generateur;
	}
	
	@Override
	public void configure() {
	}

	@Override
	public void execute() {
		try {
			Thread.sleep(2000);
			for(AsyncObserver<Generateur> canal : this.generateur.getCanaux()) {
				canal.update(this.generateur);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
