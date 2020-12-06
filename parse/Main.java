package parse;

import candy.CandyCollection;

public class Main {

	public static void main(String[] args) {
		String XML = "src/main/resources/Candy.xml";
		String XSD = "src/main/resources/Candy.xsd";
		String XSL = "src/main/resources/Candy.xsl";
		
		
		Validate validate = new Validate(XML, XSD);
		
		if (validate.isValid()) {
			System.out.println("XML is valid with this XSD");
		} else {
			System.out.println("ERROR: XML is invalid");
			System.exit(0);
		}
		
		DOMParser dom = new DOMParser(XML);
		dom.parse();
		CandyCollection candyCollection = dom.getCandyCollection();
		System.out.println(candyCollection.toString());
		
	/*	SAXPars sax = new SAXPars(XML);
		sax.parse();
		CandyCollection candyCollection = sax.getCandyCollection();
		System.out.println(candyCollection.toString());*/
		
//		StAXParser stax = new StAXParser(filenameXML);
//		stax.parse();
//		CandyCollection candyCollection = stax.getCandyCollection();
//		System.out.println(candyCollection.toString());
		
		/*Sorts the array list using comparator*/
		//Collections.sort(candyCollection.getCandyList());
		//System.out.println(candyCollection.toString());
		
		//XMLtoHTML html = new XMLtoHTML(XML, XSL);
		//html.transform();

	}


}
