package br.com.valemobi.model;

public class Operacao {
	private int codigo;
	private Mercadoria mercadoria;
	private int quantidade;
	private double preco;
	private String tipo;
	
	public Operacao() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Operacao(Mercadoria mercadoria, int quantidade, double preco, String tipo) {
		this.mercadoria = mercadoria;
		this.quantidade = quantidade;
		this.preco = preco;
		this.tipo = tipo;
	}
	
	public Operacao(int codigo, Mercadoria mercadoria, int quantidade, double preco, String tipo) {
		this.codigo = codigo;
		this.mercadoria = mercadoria;
		this.quantidade = quantidade;
		this.preco = preco;
		this.tipo = tipo;
	}
}