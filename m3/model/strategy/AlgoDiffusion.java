package model.strategy;

import model.GenerateurImpl;

public interface AlgoDiffusion {
	
	public GenerateurImpl genImpl = new GenerateurImpl();
	
	public void configure();
	
	public void execute();
}
