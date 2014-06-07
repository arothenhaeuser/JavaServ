import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


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
		DOMHandler reader = new DOMHandler(file, abgeordnete);
		reader.doIt();
	}
	private void parseSAX() {
		SAXHandler reader = new SAXHandler(file, abgeordnete);
		reader.doIt();
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
