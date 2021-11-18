package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	
	// Stage
	private static Stage primaryStage;
	
	//Métodos get e set do primaryStage
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
	
	public static void telaAlugueis() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Alugueis.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaAlugueisPesquisa() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/AlugueisPesquisa.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaAlugueisUpdate() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/AlugueisUpdate.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaClientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Clientes.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaClientesPesquisa() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/ClientesPesquisa.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaClientesUpdate() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/ClientesUpdate.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaDiscos() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Discos.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaDiscosPesquisa() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/DiscosPesquisa.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaDiscosUpdate() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/DiscosUpdate.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaLivros() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Livros.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaLivrosPesquisa() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/LivrosPesquisa.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaLivrosUpdate() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/LivrosUpdate.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}

	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Login.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaMenuInicial() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/MenuInicial.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaRelatorio() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Relatorio.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaRelatorioMenu() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/RelatorioMenu.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaRelatorioMenuClientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/RelatorioMenuClientes.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void telaRelatorioMenuTodos() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/RelatorioMenuTodos.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		
	}
	
	public static void main(String[] args) {
		launch();

	}

}
