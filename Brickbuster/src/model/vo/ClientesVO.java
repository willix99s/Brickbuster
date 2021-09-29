package model.vo;

public class ClientesVO {
	//Atributos de Clientes
	private int codClientes;
	private String nome;
	private String endereco;
	private String cpf;
	
	//Get e Set de codClientes
	public int getCodClientes() {
		return codClientes;
	}

	public void setCodClientes(int codClientes) {
		if(codClientes >= 0) 
		{
			this.codClientes = codClientes;
		}
	}

	
	
	//Get e Set de nome
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if ( nome == null ) { System.out.println ("Nome n�o pode ser nulo"); }
		else 
		{
			if( nome.equals("") ) { System.out.println("Nome n�o pode ser vazio"); }
			else { this.nome = nome; }
		}
	
	}
	
	//Get e Set de endere�o
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {

		if ( endereco == null ) { System.out.println ("Endere�o n�o pode ser nulo"); }
		else 
		{
			if( endereco.equals("") ) { System.out.println("Endere�o n�o pode ser vazio"); }
			else { this.endereco = endereco; }
		}
		
	}
	
	//Get e Set de cpf
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		
		if ( cpf.length() >= 11 ) { this.cpf = cpf; } 
		else { System.out.println ("CPF inv�lido!"); }
	}
	
}
