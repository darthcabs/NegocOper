package br.com.valemobi.model;

public class Mercadoria {
	private int codigo;
	private String nome;
	private String tipo;
	
	public Mercadoria() {
	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Mercadoria(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Mercadoria(int codigo, String nome, String tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
	}
}