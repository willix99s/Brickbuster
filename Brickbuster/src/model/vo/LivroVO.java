package model.vo;

public class LivroVO {
	//Atributos do Livro
	private String titulo;
	private String autor;
	private String genero;
	private int ano;
	private int paginas;
	private int exemplares;
	private double valorAluguel;
	
	//Get e Set de titulo
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(titulo == null)
		{
			System.out.println("Título não pode ser nulo");
		}
		else
		{
			if(titulo.equals(" "))
			{
				System.out.println("Título não pode ser vazio");
			}
			else
			{
				this.titulo = titulo;
			}
		}
	}
	
	//Get e Set de autor
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		if(autor == null)
		{
			System.out.println("Autor não pode ser nulo");
		}
		else
		{
			if(autor.equals(" "))
			{
				System.out.println("Autor não pode ser vazio");
			}
			else
			{
				this.autor = autor;
			}
		}
	}
	
	//Get e Set de genero
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		if(genero == null)
		{
			System.out.println("Gênero não pode ser nulo");
		}
		else
		{
			if(genero.equals(" "))
			{
				System.out.println("Gênero não pode ser vazio");
			}
			else
			{
				this.genero = genero;
			}
		}
	}
	
	//Get e Set de ano
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		if(ano <= 0)
		{
			System.out.println("Ano inválido");
		}
		else
		{
			this.ano = ano;
		}
	}
	
	//Get e Set de paginas
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		if(paginas <= 0)
		{
			System.out.println("Quantidade não permitida");
		}
		else
		{
			this.paginas = paginas;	
		}
	}
	
	//Get e Set de exemplares
	public int getExemplares() {
		return exemplares;
	}
	public void setExemplares(int exemplares) {
		if(exemplares <= 0)
		{
			System.out.println("Quantidade não permitida");
		}
		else
		{
			this.exemplares = exemplares;
		}
	}
	
	//Get e Set de aluguel
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		if(valorAluguel <= 0)
		{
			System.out.println("Valor não permitido");
		}
		else
		{
			this.valorAluguel = valorAluguel;
		}
	}
	
	
}
