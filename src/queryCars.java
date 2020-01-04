import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
public class queryCars {

	public static void main(String[] args) {
		DocumentBuilderFactory dbfactory= DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
			File xmlfile = new File("cars.xml");
			Document doc = dbuilder.parse(xmlfile);
			doc.getDocumentElement().normalize();
			NodeList cars = doc.getElementsByTagName("supercars");
			for(int i=0; i<cars.getLength(); i++)
			{
				Node car = cars.item(i);
				if(car.getNodeType() == Node.ELEMENT_NODE)
				{
					Element carTags = (Element) car;
					NodeList carnames = carTags.getElementsByTagName("carname");
					System.out.println("company: "+carTags.getAttribute("company"));
					for(int j=0; j<carnames.getLength(); j++)
					{
						System.out.println("Car name: "+carnames.item(j).getTextContent()+" type: "+((Element) carnames.item(j)).getAttribute("type"));
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
