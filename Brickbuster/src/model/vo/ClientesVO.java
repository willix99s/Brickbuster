package model.vo;

public class ClientesVO {
	//Atributos de Clientes
	private String nome;
	private String enderešo;
	private int cpf;
	
	//Get e Set de nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Get e Set de enderešo
	public String getEnderešo() {
		return enderešo;
	}
	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
	}
	
	//Get e Set de cpf
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
}
