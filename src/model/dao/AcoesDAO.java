package model.dao;

import model.Acoes;
import model.Facada;
import model.Gerador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AcoesDAO {

	public static Acoes getAcoes(Element acoes) {
		Acoes ac = new Acoes();
		NodeList generalization_acoes = acoes
				.getElementsByTagName("generalization");
		for (int i = 0; i < generalization_acoes.getLength(); i++) {
			Element general = (Element) generalization_acoes.item(i);
			if (general.getAttribute("general").equalsIgnoreCase("Colisao")) {
				ac.setColisao(true);
			}
			if (general.getAttribute("general").equalsIgnoreCase("Movimento")) {
				ac.setMovimento(true);
			}
		}
		return ac;
	}

	public static void inserirAcoes(Document doc, Element acoes) {

		if (Facada.getInstance().isAcoes_colisao()) {
			boolean tem = false;
			NodeList generalization = acoes
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase("Colisao")) {
					tem = true;
				}
			}
			if (!tem) {
				Element general = doc.createElement("generalization");
				general.setAttribute("xmi:id", Gerador.gerarId());
				general.setAttribute("general", "Colisao");
				acoes.appendChild(general);
			}
		} else {
			NodeList generalization = acoes
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase("Colisao")) {
					acoes.removeChild(general);
				}
			}
		}

		if (Facada.getInstance().isAcoes_movimento()) {
			boolean tem = false;
			NodeList generalization = acoes
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase(
						"Movimento")) {
					tem = true;
				}
			}
			if (!tem) {
				Element general = doc.createElement("generalization");
				general.setAttribute("xmi:id", Gerador.gerarId());
				general.setAttribute("general", "Movimento");
				acoes.appendChild(general);
			}
		} else {
			NodeList generalization = acoes
					.getElementsByTagName("generalization");
			for (int i = 0; i < generalization.getLength(); i++) {
				Element general = (Element) generalization.item(i);
				if (general.getAttribute("general").equalsIgnoreCase(
						"Movimento")) {
					acoes.removeChild(general);
				}
			}
		}

	}
}