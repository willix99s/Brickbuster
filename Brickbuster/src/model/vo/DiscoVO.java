package model.vo;

public class DiscoVO {
	//Atributos de DiscoVO
	private String titulo;
	private String banda;
	private String estilo;
	private int exemplares;
	private double valorAluguel;
	
	//Get e Set de titulo
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (titulo==null) {System.out.println ("Digite um t�tulo v�lido");}
		else 
		{
			if (titulo.equals(" ") ) {System.out.println ("Digite um t�tulo v�lido");}
			else {this.titulo = titulo;}
		}
		
	}
	
	//Get e Set de banda
	public String getBanda() {
		return banda;
	}
	public void setBanda(String banda) {
		if (banda==null) {System.out.println ("Digite uma banda v�lida");}
		else
		{
			if (banda.equals(" ") ) {System.out.println ("Digite uma banda v�lida");}
			else {this.banda = banda;}
		}
		
	}
	
	//Get e Set de estilo
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		if (estilo==null) {System.out.println ("Digite um estilo v�lido");}
		else 
		{
			if (estilo.equals(" ") ) {System.out.println ("Digite um estilo v�lido");}
			else {this.estilo = estilo;}
		}
		
	}
	
	//Get e Set de exemplares
	public int getExemplares() {
		return exemplares;
	}
	public void setExemplares(int exemplares) {
		if (exemplares <= 0) {System.out.println ("Quantidade n�o permitida");}
		else
		this.exemplares = exemplares;
	}
	
	//Get e Set de valor do aluguel
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		if (valorAluguel <= 0) {System.out.println ("Valor n�o permitido");}
		else
		this.valorAluguel = valorAluguel;
	}
	
	
}
