package model.vo;

public class AdminVO {
	//Atributos do admin
	private String login;
	private String senha;
	private String nome;
	
	//Get e Set de login
	public String getLogin() {
		
		return login;
		
	}
	public void setLogin(String login) {
		if ( login == null) 
		{
			System.out.println("Login não pode ser nulo");
		}
		else 
		{
			if( login.equals(" ") ) 
			{
			 System.out.println("Login não pode ser vazio");	
			}
			else 
			{
				this.login = login;	
			}
		}
		
		
	}
	
	//Get e Set de senha	
	public String getSenha() {
		return senha;
		
	}
	public void setSenha(String senha) {
		if ( senha == null) 
		{
			System.out.println("Senha inválida");
		}
		else 
		{
			if( senha.equals(" ") ) 
			{
				System.out.println("Senha inválida");
			}
			else if ( senha.length() >= 4 && senha.length() <= 8 )
			{
				this.senha = senha;
			}
		}
		
	}
	
	//Get e Set de nome
	public String getNome() {
		return nome;
		
	}
	public void setNome(String nome) {
		if ( nome == null ) 
		{
			System.out.println("Nome não pode ser nulo");
		}
		else 
		{
			this.nome = nome;	
		}
	}
	
}
