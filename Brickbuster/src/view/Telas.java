package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Telas extends Application {

	private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Telas.primaryStage = primaryStage;
    }

    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setTitle("Brickbuster");
        primaryStage.show();
        telaLogin();
        
    }
	
    public static void main(String[] args) 
    {
    	launch();
    	
    }
    
    public static void telaLogin() throws Exception 
    {
    	Parent root = FXMLLoader.load(Telas.class.getResource("VE/Login.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
    }
    
    public static void telaMenuInicial() throws Exception 
    {
    	Parent root = FXMLLoader.load(Telas.class.getResource("VE/MenuInicial.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
    }
}
