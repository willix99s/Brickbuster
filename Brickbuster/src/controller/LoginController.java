package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.Telas;

public class LoginController {

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    void logar(ActionEvent event) throws Exception {
    	Telas.telaMenuInicial();
    }

}
