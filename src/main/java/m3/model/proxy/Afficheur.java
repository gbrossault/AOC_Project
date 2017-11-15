package m3.model.proxy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import m3.model.observer.ObservateurGenerateur;

public class Afficheur implements ObservateurGenerateur {

    private IntegerProperty value;

    public Afficheur() {
        this.value = new SimpleIntegerProperty();
        this.value.set(0);
    }

    @Override
    public void update(Generateur subject) {
        System.out.println("Canal get value");
        this.value.set(subject.getValue());
        System.out.println("Value : " + value);
    }
}
