package main.java.m3.model;

import main.java.m3.model.observer.Observateur;
import main.java.m3.model.proxy.Generateur;

public class GenerateurAsync implements Generateur {

	private Object executorService;
	private GenerateurImpl generateur;
	
	@Override
	public void attach(Observateur o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(Observateur o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Future<Integer> getValue() {
		return executorService.submit(()->{
			return generator.getValue();
		});
	}

}
