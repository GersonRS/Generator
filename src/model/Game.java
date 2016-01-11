package model;

import java.util.ArrayList;

public class Game {

	private ArrayList<Elemento> listaElementos;
	private ArrayList<Cenario> listaCenarios;
	private Interacao interacao;
	private Acoes acoes;
	private boolean audio;

	public Game() {
		listaElementos = new ArrayList<Elemento>();
		listaCenarios = new ArrayList<Cenario>();
		interacao = new Interacao();
		acoes = new Acoes();
		listaElementos.add(new Elemento(Gerador.gerarId(), "Personagem",
				"Elemento"));
		listaElementos.add(new Elemento(Gerador.gerarId(), "Obstaculo",
				"Elemento"));
	}

	public ArrayList<Elemento> getListaElementos() {
		return listaElementos;
	}

	public ArrayList<Cenario> getListaCenarios() {
		return listaCenarios;
	}

	public void setInteracao(Interacao interacao) {
		this.interacao = interacao;
	}

	public void setAcoes(Acoes acoes) {
		this.acoes = acoes;
	}

	public Interacao getInteracao() {
		return interacao;
	}

	public Acoes getAcoes() {
		return acoes;
	}

	public void setListaElementos(ArrayList<Elemento> listaElementos) {
		this.listaElementos = listaElementos;
	}

	public void setListaCenarios(ArrayList<Cenario> listaCenarios) {
		this.listaCenarios = listaCenarios;
	}

	public boolean isAudio() {
		return audio;
	}

	public void setAudio(boolean audio) {
		this.audio = audio;
	}

}
