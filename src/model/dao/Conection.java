package model.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import exceptions.ExceptionArquivoNull;

public class Conection {

	private static Conection conection;

	public static synchronized Conection getConection() {
		if (conection == null)
			conection = new Conection();
		return conection;
	}

	private Conection() {
	}
	
	private Document carregaDoc(InputStream is){
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setEntityResolver(new EntityResolver() {
				public InputSource resolveEntity(String publicId,
						String systemId) throws SAXException, IOException {
					return new InputSource(
							new ByteArrayInputStream(new byte[0]));
				}
			});
			
			return builder.parse(is);
			
		} catch (Exception e) {
		}
		
		return null;
	}
	
	public Document connectDefault() {
		Document doc = null;
		InputStream is = null;
		try {
			File f = new File("resource/model/core.uml");
			is = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			new ExceptionArquivoNull();
		}
		doc=carregaDoc(is);
		
		return doc;
	}
	
	public Document connectDefaultMVC() {
		Document doc = null;
		InputStream is = null;
		try {
			File f = new File("resource/model/MVC.uml");
			is = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			new ExceptionArquivoNull();
		}
		doc=carregaDoc(is);
		
		return doc;
	}

	public Document connect(File f) {
		Document doc = null;
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			new ExceptionArquivoNull();
		}

		doc = carregaDoc(is);

		return doc;
	}

	public void salvar(Document doc, File f) {
		// Salva o documento XML no diret�rio passado como par�metro.
		try {
			if (f == null) {
				f = new File("resource/model/model.uml");
			}
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream(f));

			TransformerFactory transFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
