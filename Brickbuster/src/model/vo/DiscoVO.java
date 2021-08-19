package model.vo;

public class DiscoVO {
	//Atributos de DiscoVO
	private String titulo;
	private String nome;
	private String estilo;
	private int exemplares;
	private double valorAluguel;
	
	//Get e Set de titulo
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (titulo==null) {System.out.println ("Digite um Título válido");}
		else 
		{
			if (nome.equals(" ") ) {System.out.println ("Digite um Título válido");}
			else {this.titulo = titulo;}
		}
		
	}
	
	//Get e Set de nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome==null) {System.out.println ("Digite um nome válido");}
		else
		{
			if (nome.equals(" ") ) {System.out.println ("Digite um nome Válido");}
			else {this.nome = nome;}
		}
		
	}
	
	//Get e Set de estilo
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		if (estilo==null) {System.out.println ("Digite um nome válido");}
		else 
		{
			if (nome.equals(" ") ) {System.out.println ("Digite um nome Válido");}
			else {this.estilo = estilo;}
		}
		
	}
	
	//Get e Set de exemplares
	public int getExemplares() {
		return exemplares;
	}
	public void setExemplares(int exemplares) {
		if (exemplares <= 0) {System.out.println ("Quantidade não permitida");}
		else
		this.exemplares = exemplares;
	}
	
	//Get e Set de valor do aluguel
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		if (valorAluguel <= 0) {System.out.println ("Valor não permitido ");}
		else
		this.valorAluguel = valorAluguel;
	}
	
	
}
