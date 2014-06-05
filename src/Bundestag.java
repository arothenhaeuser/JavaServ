import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


public class Bundestag {
	ArrayList<Abgeordneter> abgeordnete = null;
	int currPos;
	
	String file = "bundestag.xml";
	
	public Bundestag() {
		abgeordnete = new ArrayList<Abgeordneter>();
		currPos = 0;
		String type = null;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(new File("config.xml"));
			file = ((Element) doc.getElementsByTagName("file").item(0)).getTextContent();
			type = ((Element) doc.getElementsByTagName("parser").item(0)).getTextContent();
		} catch (Exception e) {
			System.out.println("Fehler beim Parsen der config.xml!");
			e.printStackTrace();
		}
		
		
		//check settings
		if(type.equals("SAX")){
			parseSAX();
		}
		else if(type.equals("DOM")){
			parseDOM();
		}
		else {
			System.out.println("Config: Ungültige Konfiguration!");
		}
	}
	private void parseDOM() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(new File(file));
			DOMHandler reader = new DOMHandler(doc, abgeordnete);
			reader.doIt();
		} catch (Exception e) {
			System.out.println("DOMParser: Fehler beim Parsen der Datei!");
			e.printStackTrace();
		}
	}
	private void parseSAX() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(new SAXHandler(abgeordnete));
			reader.parse(new InputSource(file));
		} catch (Exception e) {
			System.out.println("SAXParser: Fehler beim Parsen der Datei!");
		}
	}
	public boolean hasNext() {
		if(abgeordnete.size() > currPos)
			return true;
		else
			return false;
	}
	public Abgeordneter getNext() {
		return abgeordnete.get(currPos++);
	}
}
