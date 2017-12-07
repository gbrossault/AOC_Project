package main.java.m3.model.proxy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import main.java.m3.model.GenerateurAsync;
import main.java.m3.model.observer.Observateur;
import main.java.m3.model.observer.ObservateurGenerateur;

public class Afficheur implements Observateur<GenerateurAsync> {

    private IntegerProperty value;

    public Afficheur() {
        this.value = new SimpleIntegerProperty();
        this.value.set(0);
    }

	@Override
	public void update(GenerateurAsync s) {
		System.out.println("Afficheur -> update : " + this.value.get());
		Future<Integer> newValue = s.getValue();
		try {
			this.value.set(newValue.get());
			System.out.println("Value : " + this.value.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
