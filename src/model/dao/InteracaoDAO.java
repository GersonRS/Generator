package model.dao;

import model.Facada;
import model.Gerador;
import model.Interacao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class InteracaoDAO {

	public static Interacao getInteracao(Element interacao) {
		Interacao in = new Interacao();
		NodeList generalization_interacao = interacao
				.getElementsByTagName("generalization");

		for (int i = 0; i < generalization_interacao.getLength(); i++) {
			Element general = (Element) generalization_interacao.item(i);
			if (general.getAttribute("general").equalsIgnoreCase(
					"MouseInputListener")) {
				in.setMouse(true);
			}
			if (general.getAttribute("general").equalsIgnoreCase("KeyListener")) {
				in.setTeclado(true);
			}
		}
		return in;
	}
	public static Interacao getInteracaoMVC(Element interacao) {
		Interacao in = new Interacao();
		NodeList interfaceRealization = interacao
				.getElementsByTagName("interfaceRealization");
		
		for (int i = 0; i < interfaceRealization.getLength(); i++) {
			Element general = (Element) interfaceRealization.item(i);
			if (general.getAttribute("supplier").equalsIgnoreCase(
					"MouseInputListener")) {
				in.setMouse(true);
			}
			if (general.getAttribute("supplier").equalsIgnoreCase("KeyListener")) {
				in.setTeclado(true);
			}
		}
		return in;
	}

	public static void inserirInteracao(Document doc, Element interacao) {
		if (Facada.getInstance().isInteracoes_mouse()) {
			boolean tem = false;
			NodeList generalization = interacao
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase(
						"MouseInputListener")) {
					tem = true;
				}
			}
			if (!tem) {
				Element general = doc.createElement("generalization");
				general.setAttribute("xmi:id", Gerador.gerarId());
				general.setAttribute("general", "MouseInputListener");
				interacao.appendChild(general);
			}
		} else {
			NodeList generalization = interacao
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase(
						"MouseInputListener")) {
					interacao.removeChild(general);
				}
			}
		}

		if (Facada.getInstance().isInteracoes_teclado()) {
			boolean tem = false;
			NodeList generalization = interacao
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase(
						"KeyListener")) {
					tem = true;
				}
			}
			if (!tem) {
				Element general = doc.createElement("generalization");
				general.setAttribute("xmi:id", Gerador.gerarId());
				general.setAttribute("general", "KeyListener");
				interacao.appendChild(general);
			}
		} else {
			NodeList generalization = interacao
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase(
						"KeyListener")) {
					interacao.removeChild(general);
				}
			}
		}
	}
	
	
	public static void inserirInteracaoMVC(Document doc, Element interacao) {
		if (Facada.getInstance().isInteracoes_mouse()) {
			boolean tem = false;
			NodeList interfaceRealization = interacao
					.getElementsByTagName("interfaceRealization");
			for (int i = 0; i < interfaceRealization.getLength(); i++) {
				Element general = (Element) interfaceRealization.item(i);
				if (general.getAttribute("contract").equalsIgnoreCase(
						"MouseInputListener")) {
					tem = true;
				}
			}
			if (!tem) {
				Element realization = doc.createElement("interfaceRealization");
				realization.setAttribute("xmi:id", Gerador.gerarId());
				realization.setAttribute("contract", "MouseInputListener");
				realization.setAttribute("supplier", "MouseInputListener");
				realization.setAttribute("client", "InputManager");
				realization.setAttribute("name", "interfaceRealization");
				interacao.appendChild(realization);
			}
		} else {
			NodeList interfaceRealization = interacao
					.getElementsByTagName("interfaceRealization");
			for (int i = 0; i < interfaceRealization.getLength(); i++) {
				Element realization = (Element) interfaceRealization.item(i);
				if (realization.getAttribute("contract").equalsIgnoreCase(
						"MouseInputListener")) {
					interacao.removeChild(realization);
				}
			}
		}
		
		if (Facada.getInstance().isInteracoes_teclado()) {
			boolean tem = false;
			NodeList generalization = interacao
					.getElementsByTagName("interfaceRealization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("contract").equalsIgnoreCase(
						"KeyListener")) {
					tem = true;
				}
			}
			if (!tem) {
				Element realization = doc.createElement("interfaceRealization");
				realization.setAttribute("xmi:id", Gerador.gerarId());
				realization.setAttribute("contract", "KeyListener");
				realization.setAttribute("supplier", "KeyListener");
				realization.setAttribute("client", "InputManager");
				realization.setAttribute("name", "interfaceRealization");
				interacao.appendChild(realization);
			}
		} else {
			NodeList generalization = interacao
					.getElementsByTagName("interfaceRealization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("contract").equalsIgnoreCase(
						"KeyListener")) {
					interacao.removeChild(general);
				}
			}
		}
	}
}