package main.java.m3.model.proxy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import main.java.m3.model.GenerateurAsync;
import main.java.m3.model.observer.Observateur;
import main.java.m3.view.Controller;

public class Afficheur implements Observateur<GenerateurAsync> {

    private int value;
    private Controller controller;
    private int label;

    public Afficheur(Controller controller, int label) {
        this.value = 0;
        this.controller = controller;
        this.label = label;
    }

	@Override
	public void update(GenerateurAsync s) {
		Future<Integer> newValue = s.getValue();
		try {
			this.value = newValue.get();
			this.controller.updateLabel(label, value);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
