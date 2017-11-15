package m3.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import m3.model.GenerateurImpl;
import m3.model.proxy.Afficheur;
import m3.model.proxy.Canal;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/afficheurs.fxml"));
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
