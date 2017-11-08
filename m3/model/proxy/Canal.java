package model.proxy;

import model.observer.ObservateurGenerateur;
import model.observer.Observateur;

public class Canal implements Generateur, ObservateurGenerateur {
	
	private Afficheur afficheur = new Afficheur();
	private Generateur subject;
	
	public Afficheur getAfficheur() {
		return this.afficheur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}
	
	public int getValue() {
		System.out.println("Get value of generator");
		return this.subject.getValue();
	}

	@Override
	public void attach(Observateur o) {
	}

	@Override
	public void detach(Observateur o) {
	}

	@Override
	public void update(Generateur subject) {
		this.subject = subject;
		if(this.afficheur != null) {
			System.out.println("Update afficheur");
			this.afficheur.update(this);
		}
	}
}
