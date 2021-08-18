package model.vo;

public class ClientesVO {
	//Atributos de Clientes
	private String nome;
	private String endereço;
	private int cpf;
	
	//Get e Set de nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Get e Set de endereço
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
	//Get e Set de cpf
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
}
