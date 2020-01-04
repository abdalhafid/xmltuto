import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Attr;

public class creatingxml {

	public static void main(String[] args) {
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
			Document doc = dbuilder.newDocument();
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			Element suppercars = doc.createElement("suppercars");
			Attr company = doc.createAttribute("company");
			company.setValue("Ferrari");
			suppercars.setAttributeNode(company);
			root.appendChild(suppercars);
			
			Element carname = doc.createElement("carname");
			Attr type = doc.createAttribute("type");
			type.setValue("formela one");
			carname.setAttributeNode(type);
			suppercars.appendChild(carname);
			
			
			Element carname1 = doc.createElement("carname");
			Attr type1 = doc.createAttribute("type");
			type1.setValue("sport car");
			carname.setAttributeNode(type1);
			suppercars.appendChild(carname1);
			
			
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource src = new DOMSource(doc);
			StreamResult out = new StreamResult(new File("carstest.xml"));
			tf.transform(src, out);
			
			
			StreamResult out1 = new StreamResult(System.out);
			tf.transform(src, out1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
