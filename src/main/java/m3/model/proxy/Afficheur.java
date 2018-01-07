package main.java.m3.model.proxy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import main.java.m3.model.GenerateurAsync;
import main.java.m3.model.observer.Observateur;
import main.java.m3.model.observer.ObservateurGenerateur;
import javafx.scene.control.Label;

public class Afficheur implements Observateur<GenerateurAsync> {

    private IntegerProperty value;
    private String name;
    private Label label;

    public Afficheur(String name, Label label) {
        this.value = new SimpleIntegerProperty();
        this.value.set(0);
        this.name = name;
        this.label = label;
    }

	@Override
	public void update(GenerateurAsync s) {
		System.out.println("Afficheur "+name+" -> update : " + this.value.get());
		Future<Integer> newValue = s.getValue();
		try {
			this.value.set(newValue.get());
			this.label.setText(value.getValue().toString());
			System.out.println("Value "+name+"  : " + this.value.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
