package main.java.m3.model.proxy;

import main.java.m3.model.observer.Observateur;
import main.java.m3.model.observer.ObservateurGenerateur;

public class Canal implements Generateur, ObservateurGenerateur {

    private Afficheur afficheur = null;
    private Generateur subject;


    public int getValue() {
        System.out.println("Get value of generator");
        return this.subject.getValue();
    }

    @Override
    public void attach(Observateur o) {
        this.afficheur = (Afficheur) o;
    }

    @Override
    public void detach(Observateur o) {
        this.afficheur = null;
    }

    @Override
    public void update(Generateur subject) {
        this.subject = subject;
        if (this.afficheur != null) {
            System.out.println("Update afficheur");
            this.afficheur.update(this);
        }
    }
}
