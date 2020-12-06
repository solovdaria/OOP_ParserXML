package parse;

import candy.*;
import org.mitre.taxii.messages.xml10.ObjectFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StAXParser extends XMLStreamException {
	private String filename = null;
	private XMLInputFactory XMLfactory = null;
	private XMLStreamReader reader = null;
	
	private static final ObjectFactory factory = new ObjectFactory();
	private CandyCollection candyCollection = null;
	private Candy curCandy = null;
	private Ingridients ingredients = null;
	private Value value = null;

	public StAXParser(String filename) {
		this.filename = filename;
		XMLfactory = XMLInputFactory.newInstance();
	}
	
	public void parse() {
		try {
			try {
				reader = XMLfactory.createXMLStreamReader(new FileInputStream(filename));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			analyse();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
	}
	
	private void analyse() {
		int event;
		try {
			while (reader.hasNext()) {
				event = reader.next();
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:

					if ("collection".equals(reader.getLocalName())) {
						
						candyCollection = new CandyCollection();
					
					} else if ("candy".equals(reader.getLocalName())) {
						
						curCandy = new Candy();
						curCandy.setType(Type.valueOf(reader.getAttributeValue(0)));
						curCandy.setId(reader.getAttributeValue(1));
						candyCollection.add(curCandy);
					}
					else if ("name".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						curCandy.setName(info);
						
					} else if ("energy".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						curCandy.setEnergy(Integer.parseInt(info));
						
					} else if ("production".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						curCandy.setProduction(info);
						
					} else if ("ingridients".equals(reader.getLocalName())) {
						
						ingredients = new Ingridients();
						curCandy.setIngridients(ingredients);
						
					} else if ("water".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						int water = Integer.parseInt(info);
						ingredients.setWater(water);
						
					} else if ("sugar".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						int sugar = Integer.parseInt(info);
						ingredients.setSugar(sugar);
						
					} else if ("fructose".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						int fructose = Integer.parseInt(info);
						ingredients.setFructose(fructose);
						
					} else if ("value".equals(reader.getLocalName())) {
						
						value = new Value();
						curCandy.setValue(value);
						
					} else if ("protein".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						int proteins = Integer.parseInt(info);
						value.setProteins(proteins);
						
					} else if ("fat".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						int fats =Integer.parseInt(info);
						value.setFats(fats);
						
					} else if ("carbohydrate".equals(reader.getLocalName())) {
						
						String info = new String(reader.getElementText().trim());
						int carbohydrates = Integer.parseInt(info);
						value.setCarbohydrates(carbohydrates);
						
					}
					break;
				case XMLStreamConstants.START_DOCUMENT:
					candyCollection = new CandyCollection();
					break;
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	public CandyCollection getCandyCollection() {
		return candyCollection;
	}

	

}
