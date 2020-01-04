import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
public class xmlmodif {

	public static void main(String[] args) {
		File input = new File("cars.xml");
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db= dbf.newDocumentBuilder();
			Document doc = db.parse(input);
			Element root = doc.getDocumentElement();
			Node cars = root.getElementsByTagName("supercars").item(0);
			NodeList carnames = cars.getChildNodes();
			for(int i=0; i<carnames.getLength(); i++)
			{
				Node carname = carnames.item(i);

				if(carname.getNodeType() == Node.ELEMENT_NODE)
				{
					Element ele = (Element) carname;
					if(ele.getNodeName().equals("carname"))
					{
						if(ele.getAttribute("type").matches("formula(.*)"))
						{
							ele.setAttribute("type", "suport car");
							carname.setTextContent("modified node");
						}
					}
				}
			}
			
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource src = new DOMSource(doc);
			StreamResult out = new StreamResult(System.out);
			tf.transform(src, out);
			
			StreamResult out1 = new StreamResult(new File("cars.xml"));
			tf.transform(src, out1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
