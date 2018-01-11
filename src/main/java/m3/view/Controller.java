package main.java.m3.view;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.beans.property.*;
import javafx.concurrent.*;

import main.java.m3.model.proxy.Afficheur;
import main.java.m3.model.proxy.Canal;
import main.java.m3.model.proxy.Generateur;
import main.java.m3.model.strategy.AlgoDiffusion;
import main.java.m3.model.strategy.DiffusionAEpoque;
import main.java.m3.model.strategy.DiffusionAtomique;
import main.java.m3.model.strategy.DiffusionSequentielle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label a1;
    @FXML
    private Label a2;
    @FXML
    private Label a3;
    @FXML
    private Label a4;
    
    Property<String> valueA1 = new SimpleStringProperty("0");
    Property<String> valueA2 = new SimpleStringProperty("0");
    Property<String> valueA3 = new SimpleStringProperty("0");
    Property<String> valueA4 = new SimpleStringProperty("0");
    
    @FXML
    private RadioButton atomiqueButton;
    @FXML
    private RadioButton seqButton;
    @FXML
    private RadioButton epoqueButton;
    
    @FXML
    private Button startButton;
    
    private Generateur generateur;
    private AlgoDiffusion algo;
    private ControllerService service;
    
    private int max = 1500;
    private int min = 500; 
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	a1.textProperty().bindBidirectional(this.valueA1);
    	a2.textProperty().bindBidirectional(this.valueA2);
    	a3.textProperty().bindBidirectional(this.valueA3);
    	a4.textProperty().bindBidirectional(this.valueA4);
    	this.generateur = new Generateur();
    	startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(atomiqueButton.isSelected()) {
			    	algo = new DiffusionAtomique(generateur);
				} else if(seqButton.isSelected()) {
			    	algo = new DiffusionSequentielle(generateur);
				} else {
			    	algo = new DiffusionAEpoque(generateur);
				}
				genererValues();
			}
		});
    }
    
    public void genererValues() {    	
    	generateur.setAlgo(algo);
        Afficheur afficheur1 = new Afficheur(this, 1);
        Afficheur afficheur2 = new Afficheur(this, 2);
        Afficheur afficheur3 = new Afficheur(this, 3);
        Afficheur afficheur4 = new Afficheur(this, 4);
        int latency = this.min + ((int)(Math.random()*(this.max-this.min)+1));
        Canal canal1 = new Canal(generateur, latency);
        latency = this.min + ((int)(Math.random()*(this.max-this.min)+1));
        Canal canal2 = new Canal(generateur, latency);
        latency = this.min + ((int)(Math.random()*(this.max-this.min)+1));
        Canal canal3 = new Canal(generateur, latency);
        latency = this.min + ((int)(Math.random()*(this.max-this.min)+1));
        Canal canal4 = new Canal(generateur, latency);
        canal1.attach(afficheur1);
        canal2.attach(afficheur2);
        canal3.attach(afficheur3);
        canal4.attach(afficheur4);
        generateur.attach(canal1);
        generateur.attach(canal2);
        generateur.attach(canal3);
        generateur.attach(canal4);
    	
        service = new ControllerService(generateur, algo);
        service.start();
    }
    
    public void updateLabel(int label, int value) {
    	switch(label) {
    	case 1:
    		Platform.runLater(new Runnable() {
				@Override
				public void run() {
					valueA1.setValue(Integer.toString(value));
				}
			});
    		break;
    	case 2:
    		Platform.runLater(new Runnable() {
				@Override
				public void run() {
					valueA2.setValue(Integer.toString(value));
				}
			});
    		break;
    	case 3:
    		Platform.runLater(new Runnable() {
				@Override
				public void run() {
					valueA3.setValue(Integer.toString(value));
				}
			});
    		break;
    	case 4:
    		Platform.runLater(new Runnable() {
				@Override
				public void run() {
					valueA4.setValue(Integer.toString(value));
				}
			});
    		break;
    	}
    }
    
  private static class ControllerService extends Service<String> {
        
        private Generateur generateur;
        private AlgoDiffusion algo;
        
        public ControllerService(Generateur generateur, AlgoDiffusion algo) {
            this.generateur = generateur;
            this.algo = algo;
        }

        @Override
        protected Task<String> createTask() {
            return new Task<String>() {
                @Override
                protected String call() throws IOException, MalformedURLException {
                    int i = 0;
                    while(i<20) {
                    	algo.configure();
                        generateur.genererValue();
                        i++;
                    }
                    return null;
                }
            };
        }
    }
}
