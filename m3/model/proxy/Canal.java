package model.proxy;

import model.observer.ObservateurGenerateur;
import model.observer.Observateur;

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
		if(this.afficheur != null) {
			System.out.println("Update afficheur");
			this.afficheur.update(this);
		}
	}
}
