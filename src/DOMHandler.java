import java.util.ArrayList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class DOMHandler {

	Document doc = null;
	ArrayList<Abgeordneter> abgeordnete = null;

	public DOMHandler(Document doc, ArrayList<Abgeordneter> abgeordnete) {
		this.doc = doc;
		this.abgeordnete = abgeordnete;
	}

	public void doIt() {
		NodeList list = doc.getElementsByTagName("abgeordneter");
		Abgeordneter abgeordneter = new Abgeordneter();
		for(int i=0; i<list.getLength(); i++) {
			Element item = (Element) list.item(i);
			abgeordneter.setName(((Element) item.getElementsByTagName("name").item(0)).getTextContent());
			abgeordneter.setPartei(((Element) item.getElementsByTagName("partei").item(0)).getTextContent());
			abgeordneter.setTitel(((Element) item.getElementsByTagName("titel").item(0)).getTextContent());
			abgeordneter.setHerkunft(((Element) item.getElementsByTagName("herkunft").item(0)).getTextContent());
			abgeordneter.setBundesland(((Element) item.getElementsByTagName("bundesland").item(0)).getTextContent());
			abgeordneter.setAusbildung(((Element) item.getElementsByTagName("ausbildung").item(0)).getTextContent());
			abgeordneter.setBild(((Attr)((Element) item.getElementsByTagName("bild").item(0)).getAttributeNode("url")).getValue());
			abgeordnete.add(abgeordneter);
		}
	}
	
	
}
