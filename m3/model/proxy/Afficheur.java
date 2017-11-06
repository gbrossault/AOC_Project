package model.proxy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.observer.ObservateurGenerateur;

public class Afficheur implements ObservateurGenerateur {
	
	private IntegerProperty value;
	
	public Afficheur() {
		this.value = new SimpleIntegerProperty();
		this.value.set(0);
	}
	
	@Override
	public void update(Generateur subject) {
		this.value.set(subject.getValue());
	}

}
