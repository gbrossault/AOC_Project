package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GenerateurImpl;
import model.proxy.Afficheur;
import model.proxy.Canal;
import model.proxy.Generateur;

public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("../view/afficheurs.fxml"));
//        primaryStage.setTitle("Afficheurs");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
    }


    public static void main(String[] args) throws InterruptedException {
//        launch(args);
    	GenerateurImpl generateur = new GenerateurImpl();
    	Afficheur afficheur = new Afficheur();
    	Canal canal = new Canal();
    	canal.attach(afficheur);
    	generateur.attach(canal);
    	generateur.genererValue();
    }
}
