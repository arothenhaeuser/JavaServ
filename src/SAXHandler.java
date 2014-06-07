import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SAXHandler implements ContentHandler {
	String currentValue = null;
	Abgeordneter abgeordneter = null;
	String file = null;
	ArrayList<Abgeordneter> abgeordnete = null;
	public SAXHandler(String file, ArrayList<Abgeordneter> abgeordnete) {
		this.file = file;
		this.abgeordnete = abgeordnete;
	}
	public void doIt() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(this);
			reader.parse(new InputSource(file));
		} catch (Exception e) {
			System.out.println("SAXParser: Fehler beim Parsen der Datei!");
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		currentValue = new String(ch, start, length);
	}
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if(qName.equals("abgeordneter")) {
			abgeordneter = new Abgeordneter();
		}
		if(abgeordneter != null) {
			if (qName.equals("bild")) {
				abgeordneter.setBild(atts.getValue("url"));
				abgeordnete.add(abgeordneter);
			}
		}
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("name")) { abgeordneter.setName(currentValue);}
		if(qName.equals("partei")) { abgeordneter.setPartei(currentValue);}
		if(qName.equals("titel")) { abgeordneter.setTitel(currentValue);}
		if(qName.equals("herkunft")) { abgeordneter.setHerkunft(currentValue);}
		if(qName.equals("bundesland")) { abgeordneter.setBundesland(currentValue);}
		if(qName.equals("ausbildung")) { abgeordneter.setAusbildung(currentValue);}
	}
	public void endDocument() throws SAXException {
	}
	public void endPrefixMapping(String arg0) throws SAXException {
	}
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {
	}
	public void processingInstruction(String arg0, String arg1)
			throws SAXException {
	}
	public void setDocumentLocator(Locator arg0) {
	}
	public void skippedEntity(String arg0) throws SAXException {
	}
	public void startDocument() throws SAXException {
	}
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
	}
}
