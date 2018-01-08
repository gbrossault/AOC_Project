package main.java.m3.model.strategy;

import main.java.m3.model.proxy.Generateur;

public class DiffusionAEpoque implements AlgoDiffusion {
	
	private Generateur generateur;
	
	public DiffusionAEpoque(Generateur generateur) {
		this.generateur = generateur;
	}
	
	@Override
	public void configure() {
	}

	@Override
	public void execute() {
	}
}
