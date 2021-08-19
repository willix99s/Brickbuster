package model.vo;

public class ClientesVO {
	//Atributos de Clientes
	private String nome;
	private String endereco;
	private String cpf;
	
	//Get e Set de nome
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if ( nome == null ) { System.out.println ("Nome não pode ser nulo"); }
		else 
		{
			if( nome.equals(" ") ) { System.out.println("Nome não pode ser vazio"); }
			else { this.nome = nome; }
		}
	
	}
	
	//Get e Set de endereço
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {

		if ( endereco == null ) { System.out.println ("Endereço não pode ser nulo"); }
		else 
		{
			if( nome.equals(" ") ) { System.out.println("Nome não pode ser vazio"); }
			else { this.endereco = nome; }
		}
		
	}
	
	//Get e Set de cpf
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		
		if ( cpf.length() == 11 ) { this.cpf = cpf; } 
		else { System.out.println ("CPF inválido!"); }
	}
	
}
