package main.java.m3.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.m3.model.proxy.Afficheur;
import main.java.m3.model.proxy.Canal;
import main.java.m3.model.proxy.Generateur;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/afficheurs.fxml"));
        primaryStage.setTitle("Afficheurs");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws InterruptedException {
        launch(args);
//        Generateur generateur = new Generateur();
//        Afficheur afficheur1 = new Afficheur("Afficheur 1");
//        Afficheur afficheur2 = new Afficheur("Afficheur 2");
//        Afficheur afficheur3 = new Afficheur("Afficheur 3");
//        Afficheur afficheur4 = new Afficheur("Afficheur 4");
//        Canal canal1 = new Canal(generateur);
//        Canal canal2 = new Canal(generateur);
//        Canal canal3 = new Canal(generateur);
//        Canal canal4 = new Canal(generateur);
//        canal1.attach(afficheur1);
//        canal2.attach(afficheur2);
//        canal3.attach(afficheur3);
//        canal4.attach(afficheur4);
//        generateur.attach(canal1);
//        generateur.attach(canal2);
//        generateur.attach(canal3);
//        generateur.attach(canal4);
//        int i = 0;
//        while(i<4) {
//        	generateur.genererValue();
//        	i++;
//        }
    }
}
