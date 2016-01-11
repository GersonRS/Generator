package model;

import java.io.File;
import java.util.ArrayList;

public class Facada{
	private static Facada instance = null;
	private Game game;
	private Gerador gerador;

	private Facada() {
		game = new Game();
		gerador = new Gerador();
	}

	public static synchronized Facada getInstance() {
		if (instance == null)
			instance = new Facada();
		return instance;
	}

	public void generateXMLFile(File f) {
		gerador.generateXMLFile(f);
	}

	public void gerarCodigo(File f) {
		gerador.gerarCodigo(f);
	}

	public void loadXMLFile(File f) {
		this.game = gerador.loadXMLFile(f);
	}
	
	public ArrayList<Elemento> getListaElementos() {
		return game.getListaElementos();
	}
	public ArrayList<Cenario> getListaCenarios() {
		return game.getListaCenarios();
	}

	public Elemento getElementoPorNome(String nome) {
		for (Elemento elemento : game.getListaElementos()) {
			if (elemento.getNome().equalsIgnoreCase(nome))
				return elemento;
		}
		return null;
	}
	
	public Cenario getCenarioPorNome(String nome) {
		for (Cenario cenario : game.getListaCenarios()) {
			if (cenario.getNome().equalsIgnoreCase(nome))
				return cenario;
		}
		return null;
	}

	public boolean isAcoes_colisao() {
		return game.getAcoes().isColisao();
	}

	public boolean isAcoes_movimento() {
		return game.getAcoes().isMovimento();
	}

	public boolean isInteracoes_mouse() {
		return game.getInteracao().isMouse();
	}

	public boolean isInteracoes_teclado() {
		return game.getInteracao().isTeclado();
	}

	public void setInteracoes_mouse(boolean b) {
		game.getInteracao().setMouse(b);
	}

	public void setInteracoes_teclado(boolean b) {
		game.getInteracao().setTeclado(b);
	}

	public void setAcoes_colisao(boolean b) {
		game.getAcoes().setColisao(b);
	}

	public void setAcoes_movimento(boolean b) {
		game.getAcoes().setMovimento(b);
	}
	
	public boolean isAudio() {
		return game.isAudio();
	}

	public void setAudio(boolean audio) {
		game.setAudio(audio);
	}

	public void addElemento(Elemento elemento) {
		game.getListaElementos().add(elemento);
	}
}
