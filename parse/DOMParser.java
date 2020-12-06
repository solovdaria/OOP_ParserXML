
package parse;

import candy.*;
import org.mitre.taxii.messages.xml10.ObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DOMParser {
	 
    private DocumentBuilderFactory documentBuilderFactory = null;
    private DocumentBuilder documentBuilder = null;
    private Document document = null;
    private String fileName = null;
    
    private static final ObjectFactory factory = new ObjectFactory();
    private CandyCollection candyCollection = null;
     
    public DOMParser(String fileName) {
    	this.fileName = new String(fileName);
    }
    
    
    public void parse() {
    	try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();    
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(fileName); 
            candyCollection = new CandyCollection();
            analysis();         
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
    }
    
	private void analysis() {
		
		NodeList candyList = document.getElementsByTagName("candy");
		
		for (int i = 0; i < candyList.getLength(); i++) {
			Node curCandy = candyList.item(i);
			if (curCandy.getNodeType() == Node.ELEMENT_NODE) {
				Element candy = (Element) curCandy;
				Candy candyType = new Candy();
				candyType.setType(Type.valueOf(candy.getAttribute("type")));
				candyType.setId(candy.getAttribute("id"));
				NodeList featureList = candy.getChildNodes();
				for (int j = 0; j < featureList.getLength(); j++) {
					Node f = featureList.item(j);
					if (f.getNodeType() == Node.ELEMENT_NODE) {
						Element feature = (Element) f;
						switch (feature.getTagName()) {
							case "name":
								candyType.setName(feature.getTextContent());
								break;
							case "energy":
								candyType.setEnergy(Integer.parseInt(feature.getTextContent()));
								break;
							case "production":
								candyType.setProduction(feature.getTextContent());
								break;
							case "ingridients":
								candyType.setIngridients(analyseIngredients(feature));
								break;
							case "value":
								candyType.setValue(analyseValue(feature));
								break;
							}
					}
				}
				candyCollection.add(candyType);
			}
		}
	}
	
	private Ingridients analyseIngredients(Element feature) {
		Ingridients ingredients = new Ingridients();
		NodeList ingredList = feature.getChildNodes();
		for (int k = 0; k < ingredList.getLength(); k++) {
			Node in = ingredList.item(k);
			if (in.getNodeType() == Node.ELEMENT_NODE) {
				Element ingridient = (Element) in;
				switch (ingridient.getTagName()) {
					case "water":
						int water = Integer.parseInt(ingridient.getTextContent());
						ingredients.setWater(water);
						break;
					case "sugar":
						int sugar = Integer.parseInt(ingridient.getTextContent());
						ingredients.setSugar(sugar);
						break;
					case "fructose":
						int fructose = Integer.parseInt(ingridient.getTextContent());
						ingredients.setFructose(fructose);
						break;
					}
			}
		}
		return ingredients;
	}
	
	private Value analyseValue(Element feature) {
		Value value = new Value();
		NodeList valueList = feature.getChildNodes();
		for (int k = 0; k < valueList.getLength(); k++) {
			Node v = valueList.item(k);
			if (v.getNodeType() == Node.ELEMENT_NODE) {
				Element curValue = (Element) v;
				switch (curValue.getTagName()) {
					case "protein":
						int proteins = Integer.parseInt(curValue.getTextContent());
						value.setProteins(proteins);
						break;
					case "fat":
						int fats = Integer.parseInt(curValue.getTextContent());
						value.setFats(fats);
						break;
					case "carbohydrate":
						int carbohydrates = Integer.parseInt(curValue.getTextContent());
						value.setCarbohydrates(carbohydrates);
						break;
					}
			}
		}
		return value;
	}
	
	public CandyCollection getCandyCollection() {
		return candyCollection;
	}

}

