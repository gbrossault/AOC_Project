package main.java.m3.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.java.m3.model.proxy.Afficheur;
import main.java.m3.model.proxy.Canal;
import main.java.m3.model.proxy.Generateur;
import main.java.m3.model.strategy.AlgoDiffusion;
import main.java.m3.model.strategy.DiffusionAtomique;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

public class Controller implements Initializable {

    @FXML
    private Label a1;
    @FXML
    private Label a2;
    @FXML
    private Label a3;
    @FXML
    private Label a4;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	Generateur generateur = new Generateur();
    	AlgoDiffusion algo = new DiffusionAtomique(generateur);
    	generateur.setAlgo(algo);
        Afficheur afficheur1 = new Afficheur("Afficheur 1", a1);
        Afficheur afficheur2 = new Afficheur("Afficheur 2", a2);
        Afficheur afficheur3 = new Afficheur("Afficheur 3", a3);
        Afficheur afficheur4 = new Afficheur("Afficheur 4", a4);
        Canal canal1 = new Canal(generateur);
        Canal canal2 = new Canal(generateur);
        Canal canal3 = new Canal(generateur);
        Canal canal4 = new Canal(generateur);
        canal1.attach(afficheur1);
        canal2.attach(afficheur2);
        canal3.attach(afficheur3);
        canal4.attach(afficheur4);
        generateur.attach(canal1);
        generateur.attach(canal2);
        generateur.attach(canal3);
        generateur.attach(canal4);
        int i = 0;
        while(i<=4) {
	        try {
				generateur.genererValue();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        i++;
        }
    }
}
