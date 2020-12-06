package parse;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;

public class XMLtoHTML {

	private String XML = null;
	private String XSL = null;

	public XMLtoHTML (String XML, String XSL) {
		this.XML = XML;
		this.XSL = XSL;
	}

	public void transform() {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory
					.newTransformer(new StreamSource(XSL));

			transformer.transform(new StreamSource(XML),
					new StreamResult(
					new FileOutputStream("Candy.html")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /*public void transform()
	    {
	        try
	        {
	            TransformerFactory tFactory = TransformerFactory.newInstance();

	            Source xslDoc = new StreamSource(xsl);
	            Source xmlDoc = new StreamSource(xml);

	            String outputFileName = "Candy.html";
	            OutputStream htmlFile = new FileOutputStream(outputFileName);

	            Transformer transformer = tFactory.newTransformer(xslDoc);
	            transformer.transform(xmlDoc, new StreamResult(htmlFile));
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }*/
	
	
}
