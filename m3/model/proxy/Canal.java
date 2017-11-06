package model.proxy;

import model.observer.ObservateurGenerateur;
import model.observer.Observateur;

public class Canal implements Generateur, ObservateurGenerateur {
	
	private Afficheur afficheur = new Afficheur();

	public Afficheur getAfficheur() {
		return this.afficheur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}
	
	public int getValue() {
		return 0;
	}

	@Override
	public void attach(Observateur o) {
	}

	@Override
	public void detach(Observateur o) {
	}

	@Override
	public void update(Generateur subject) {
		if(this.afficheur != null) {
			this.afficheur.update(subject);
		}
	}
}
