package parse;

import candy.*;
import org.mitre.taxii.messages.xml10.ObjectFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParsHandle extends DefaultHandler {
	
	String filename = null;
	String thisElement = "";
	private static final ObjectFactory factory = new ObjectFactory();
	private Candy curCandy = null;
	private CandyCollection candyCollection = null;
	private Ingridients ingredients = null;
	private Value value = null;

	public SAXParsHandle(String filename) {
		this.filename = new String(filename);
	}

	@Override
	public void startDocument() throws SAXException {}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		thisElement = qName;
		if ("collection".equals(qName)) {
			candyCollection = new CandyCollection();
		} else if ("candy".equals(qName)) {
			curCandy = new Candy();
			curCandy.setId(atts.getValue("id"));
			curCandy.setType(Type.valueOf(atts.getValue("type")));
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		thisElement = "";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if (thisElement.equals("name")) {
			String info = new String(ch, start, length).trim();
			curCandy.setName(info);
		}
		if (thisElement.equals("energy")) {
			String info = new String(ch, start, length).trim();
			curCandy.setEnergy(Integer.parseInt(info));
		}
		if (thisElement.equals("production")) {
			String info = new String(ch, start, length).trim();
			curCandy.setProduction(info);
		}
		if (thisElement.equals("ingridients")) {
			ingredients = new Ingridients();
			curCandy.setIngridients(ingredients);
		}
		if (thisElement.equals("water")) {
			String info = new String(ch, start, length).trim();
			int water = Integer.parseInt(info);
			ingredients.setWater(water);
		}
		if (thisElement.equals("sugar")) {
			String info = new String(ch, start, length).trim();
			int sugar = Integer.parseInt(info);
			ingredients.setSugar(sugar);
		}
		if (thisElement.equals("fructose")) {
			String info = new String(ch, start, length).trim();
			int fructose = Integer.parseInt(info);
			ingredients.setFructose(fructose);
		}
		if (thisElement.equals("value")) {
			value = new Value();
			curCandy.setValue(value);
		}
		if (thisElement.equals("protein")) {
			String info = new String(ch, start, length).trim();
			int proteins = Integer.parseInt(info);
			value.setProteins(proteins);
		}
		if (thisElement.equals("fat")) {
			String info = new String(ch, start, length).trim();
			int fats = Integer.parseInt(info);
			value.setFats(fats);
		}
		if (thisElement.equals("carbohydrate")) {
			String info = new String(ch, start, length).trim();
			int carbohydrates = Integer.parseInt(info);
			value.setCarbohydrates(carbohydrates);
			
			candyCollection.add(curCandy);
		}
	}

	@Override
	public void endDocument() {
		curCandy = null;
		ingredients = null;
		value = null;
	}

	public CandyCollection getCandyCollection() {
		return candyCollection;
	}

}