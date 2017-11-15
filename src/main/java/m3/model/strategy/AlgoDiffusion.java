package main.java.m3.model.strategy;

import main.java.m3.model.GenerateurImpl;

public interface AlgoDiffusion {

    public GenerateurImpl genImpl = new GenerateurImpl();

    public void configure();

    public void execute();
}
