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
		this.titulo = titulo;
	}
	
	//Get e Set de autor
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	//Get e Set de genero
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	//Get e Set de ano
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	//Get e Set de paginas
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	//Get e Set de exemplares
	public int getExemplares() {
		return exemplares;
	}
	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}
	
	//Get e Set de aluguel
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	
}
