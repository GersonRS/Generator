package model.dao;

import java.util.ArrayList;

import model.Elemento;
import model.Facada;
import model.Game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class GameDAO {

	public static Game getGame(Document doc) {

		Game game = new Game();

		Element docElement = doc.getDocumentElement();

		Element packagedCore = null;
		Element packagedGame = null;
		Element interacao = null;
		Element acoes = null;
		Element jogo = null;

		NodeList pacotes = docElement.getElementsByTagName("packagedElement");
		for (int i = 0; i < pacotes.getLength(); i++) {
			Element current = (Element) pacotes.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("core")) {
				packagedCore = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("game")) {
				packagedGame = current;
			}
		}

		NodeList classesCore = packagedCore
				.getElementsByTagName("packagedElement");

		for (int i = 0; i < classesCore.getLength(); i++) {
			Element current = (Element) classesCore.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("Interacao")) {
				interacao = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("Acoes")) {
				acoes = current;
			}
		}

		jogo = (Element) packagedGame.getElementsByTagName("packagedElement")
				.item(0);

		game.setListaCenarios(CenarioDAO.getCenarios(jogo));

		game.setInteracao(InteracaoDAO.getInteracao(interacao));

		game.setAcoes(AcoesDAO.getAcoes(acoes));

		game.setListaElementos(ElementoDAO.getElementos(packagedGame));

		return game;
	}

	public static Game getGameMVC(Document doc) {

		Game game = new Game();

		Element docElement = doc.getDocumentElement();

		Element packagedController = null;
		Element packagedModel = null;
		Element inputManager = null;
		Element acoes = null;
		Element gameController = null;
		Element audio = null;
		// Element personagem = null;
		// Element obstaculo = null;

		NodeList pacotes = docElement.getElementsByTagName("packagedElement");
		for (int i = 0; i < pacotes.getLength(); i++) {
			Element current = (Element) pacotes.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("controller")) {
				packagedController = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("model")) {
				packagedModel = current;
			}
		}

		NodeList classesController = packagedController
				.getElementsByTagName("packagedElement");

		for (int i = 0; i < classesController.getLength(); i++) {
			Element current = (Element) classesController.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("InputManager")) {
				inputManager = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("GameController")) {
				gameController = current;
			}
		}

		NodeList classesModel = packagedModel
				.getElementsByTagName("packagedElement");

		for (int i = 0; i < classesModel.getLength(); i++) {
			Element current = (Element) classesModel.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("Acoes")) {
				acoes = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("Audio")) {
				audio = current;
			}
		}

		if (audio != null) {
			game.setAudio(true);
		}

		game.setListaCenarios(CenarioDAO.getCenarios(gameController));

		game.setInteracao(InteracaoDAO.getInteracaoMVC(inputManager));

		game.setAcoes(AcoesDAO.getAcoes(acoes));

		game.setListaElementos(ElementoDAO.getElementosMVC(packagedModel));

		// Elemento perso = new Elemento("Personagem", "Personagem",
		// "Elemento");
		// Elemento obst = new Elemento("Obstaculo", "Obstaculo",
		// "Elemento");
		//
		// perso.setAtributos(AtributoDAO.getAtributos(personagem));
		// obst.setAtributos(AtributoDAO.getAtributos(obstaculo));
		//
		// game.getListaElementos().add(perso);
		// game.getListaElementos().add(obst);

		return game;
	}

	public static void inserirGame(Document doc) {

		Element docElement = doc.getDocumentElement();

		Element packagedCore = null;
		Element packagedGame = null;
		Element interacao = null;
		Element acoes = null;
		Element jogo = null;

		NodeList pacotes = docElement.getElementsByTagName("packagedElement");
		for (int i = 0; i < pacotes.getLength(); i++) {
			Element current = (Element) pacotes.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("src.core")) {
				packagedCore = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("src.game")) {
				packagedGame = current;
			}
		}

		NodeList classesCore = packagedCore
				.getElementsByTagName("packagedElement");

		for (int i = 0; i < classesCore.getLength(); i++) {
			Element current = (Element) classesCore.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("Interacao")) {
				interacao = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("Acoes")) {
				acoes = current;
			}
		}

		jogo = (Element) packagedGame.getElementsByTagName("packagedElement")
				.item(0);

		CenarioDAO.inserirCenarios(doc, jogo);

		InteracaoDAO.inserirInteracao(doc, interacao);

		AcoesDAO.inserirAcoes(doc, acoes);

		ElementoDAO.setElementos(doc, packagedGame);

	}

	public static void inserirGameMVC(Document doc) {

		Element docElement = doc.getDocumentElement();

		Element packagedController = null;
		Element packagedModel = null;
		Element inputManager = null;
		Element acoes = null;
		Element gameController = null;
		Element personagem = null;
		Element obstaculo = null;
		Element audio = null;

		NodeList pacotes = docElement.getElementsByTagName("packagedElement");
		for (int i = 0; i < pacotes.getLength(); i++) {
			Element current = (Element) pacotes.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("controller")) {
				packagedController = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("model")) {
				packagedModel = current;
			}
		}

		NodeList classesController = packagedController
				.getElementsByTagName("packagedElement");

		for (int i = 0; i < classesController.getLength(); i++) {
			Element current = (Element) classesController.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("InputManager")) {
				inputManager = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("GameController")) {
				gameController = current;
			}
		}

		NodeList classesModel = packagedModel
				.getElementsByTagName("packagedElement");

		for (int i = 0; i < classesModel.getLength(); i++) {
			Element current = (Element) classesModel.item(i);
			if (current.getAttribute("name").equalsIgnoreCase("Acoes")) {
				acoes = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("Personagem")) {
				personagem = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("Obstaculo")) {
				obstaculo = current;
			}
			if (current.getAttribute("name").equalsIgnoreCase("Audio")) {
				audio = current;
			}
		}

		if (!Facada.getInstance().isAudio()) {
			packagedModel.removeChild(audio);
		} else if (audio == null) {
			Element packagedElement = doc.createElement("packagedElement");
			packagedElement.setAttribute("xmi:type", "uml:Class");
			packagedElement.setAttribute("xmi:id", "Audio");
			packagedElement.setAttribute("name", "Audio");
			packagedModel.appendChild(packagedElement);
		}

		CenarioDAO.inserirCenarios(doc, gameController);

		InteracaoDAO.inserirInteracaoMVC(doc, inputManager);

		AcoesDAO.inserirAcoes(doc, acoes);

		ElementoDAO.setElementos(doc, packagedModel);

		ArrayList<Elemento> elementos = Facada.getInstance()
				.getListaElementos();

		for (Elemento elemento : elementos) {
			if (elemento.getNome().equalsIgnoreCase("Personagem")) {
				AtributoDAO.inserirAtributos(doc, personagem, elemento);
			}
			if (elemento.getNome().equalsIgnoreCase("Obstaculo")) {
				AtributoDAO.inserirAtributos(doc, obstaculo, elemento);
			}

		}
	}

}
