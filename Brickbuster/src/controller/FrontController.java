package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.AdminBO;
import model.bo.ClientesBO;
import model.bo.DiscoBO;
import model.vo.AdminVO;
import model.vo.ClientesVO;
import model.vo.DiscoVO;
import view.Telas;

public class FrontController {

	// Componentes da Telas
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private Label erroAut;

	// Componentes da TelaClientesUpdate
	@FXML
	private TextField nomeCliente;
	@FXML
	private TextField enderecoCliente;
	@FXML
	private TextField cpfCliente;

	// Componentes da TelaDiscosUpdate
	@FXML
	private TextField tituloDisco;
	@FXML
	private TextField bandaDisco;
	@FXML
	private TextField estiloDisco;
	@FXML
	private TextField exemplaresDisco;
	@FXML
	private TextField valorDisco;

	// BOs
	AdminBO admBO = new AdminBO();
	ClientesBO cliBO = new ClientesBO();
	DiscoBO disBO = new DiscoBO();

	// Métodos de Login
	public void autenticar(ActionEvent event) throws Exception {

		AdminVO vo = new AdminVO();

		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());

		try {
			AdminVO autenticado = admBO.autenticar(vo);
			if (autenticado instanceof AdminVO) {
				Telas.telaMenuInicial();
			}
		} catch (Exception e) {
			erroAut.setText("Login ou senha inválidos!");
			erroAut.setVisible(true);
		}

	}

	public void logout(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}

	// Métodos do Menu
	public void abrirTelaClientes(ActionEvent event) throws Exception {
		Telas.telaClientes();
	}

	public void abrirTelaAlugueis(ActionEvent event) throws Exception {
		Telas.telaAlugueis();
	}

	public void abrirTelaLivros(ActionEvent event) throws Exception {
		Telas.telaLivros();
	}

	public void abrirTelaDiscos(ActionEvent event) throws Exception {
		Telas.telaDiscos();
	}

	public void retornarMenuInicial(ActionEvent event) throws Exception {
		Telas.telaMenuInicial();
	}

	// Métodos da TelaClientes
	public void abrirTelaClientesPesquisa(ActionEvent event) throws Exception {
		Telas.telaClientesPesquisa();
	}

	public void abrirTelaClientesUpdate(ActionEvent event) throws Exception {
		Telas.telaClientesUpdate();
	}

	// Métodos da TelaDiscos
	public void abrirTelaDiscosPesquisa(ActionEvent event) throws Exception {
		Telas.telaDiscosPesquisa();
	}

	public void abrirTelaDiscosUpdate(ActionEvent event) throws Exception {
		Telas.telaDiscosUpdate();
	}

	// Métodos da TelaClientesUpdate
	public void inserirCliente(ActionEvent event) throws Exception {

		ClientesVO vo = new ClientesVO();

		vo.setNome(nomeCliente.getText());
		vo.setEndereco(enderecoCliente.getText());
		vo.setCpf(cpfCliente.getText());

		try {

			cliBO.inserir(vo);
			nomeCliente.setText("");
			enderecoCliente.setText("");
			cpfCliente.setText("");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void pesquisarCliente(ActionEvent event) throws Exception {
		Telas.telaClientes();
	}

	// Métodos da TelaDiscosUpdate
	/*public void inserirDisco(ActionEvent event) throws Exception {

		DiscoVO vo = new DiscoVO();

		vo.setTitulo(tituloDisco.getText());
		vo.setBanda(bandaDisco.getText());
		vo.setEstilo(estiloDisco.getText());
		vo.setExemplares(exemplaresDisco.getAnchor());
		vo.setValorAluguel(valorDisco.getBaselineOffset());

		try {
			disBO.inserir(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*
	 * public void removerCliente(ActionEvent event) throws Exception {
	 * cliBO.remover(); }
	 */

}
