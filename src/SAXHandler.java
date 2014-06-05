import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SAXHandler implements ContentHandler {
	String currentValue = null;
	Abgeordneter abgeordneter = null;
	ArrayList<Abgeordneter> abgeordnete = null;
	public SAXHandler(ArrayList<Abgeordneter> abgeordnete) {
		this.abgeordnete = abgeordnete;
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
		// TODO Auto-generated method stub
		
	}
	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void processingInstruction(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub
		
	}
	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}
}
