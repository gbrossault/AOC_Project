package model;

import java.util.ArrayList;

import model.observer.Observateur;
import model.proxy.Generateur;
import model.strategy.AlgoDiffusion;

public class GenerateurImpl implements Generateur {

	private int value;
	private ArrayList<AlgoDiffusion> algo;
	
	public GenerateurImpl() {
		this.algo = new ArrayList<>();
	}
	
	public void genererValue() throws InterruptedException {
		while(true) {
			this.value++;
			Thread.sleep(2000);
			for(Observateur o : this.observateurs) {
				o.update(this);
			}
		}
	}
	
	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void attach(Observateur o) {
		this.observateurs.add(o);
	}

	@Override
	public void detach(Observateur o) {
		this.observateurs.remove(o);
	}

	public void addAlgo(AlgoDiffusion a) {
		this.algo.add(a);
	}
	
	public void removeAlgo(AlgoDiffusion a) {
		this.algo.remove(a);
	}
}
