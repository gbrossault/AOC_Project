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
    }
}
