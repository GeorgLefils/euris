package entities;

import util.IMappablePro;

public class Articolo implements IMappablePro {
	
	private int id;
	private String nome;
	private String prezzo;
	
	public Articolo(int id, String nome, String prezzo) {
		super();
		
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public Articolo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nome:" + nome + ", prezzo:" + prezzo + "}";
	}
	
	
	

}
