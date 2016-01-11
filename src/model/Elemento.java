package model;

import java.util.ArrayList;

public class Elemento {

	private String id;
	private String nome;
	private String extend;
	private ArrayList<Atributo> atributos;

	public Elemento(String id, String nome, String extend) {
		this.id = id;
		this.nome = nome;
		this.extend = extend;
		this.atributos = new ArrayList<Atributo>();
	}

	public Atributo getAtributoPorNome(String nome) {
		for (Atributo atributo : atributos) {
			if (atributo.getNome().equalsIgnoreCase(nome))
				return atributo;
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}

}
