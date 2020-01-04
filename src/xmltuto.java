import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class xmltuto {
	public static void main(String[] args) {
		try{
			File inputFile = new File("test.xml");
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
			Document doc = dbuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nlist = doc.getElementsByTagName("student");
			for(int temp = 0; temp<nlist.getLength(); temp++)
			{
				Node node = nlist.item(temp);
				if(node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element ele = (Element) node;
					System.out.println("name of student number ("+(ele.getAttribute("rollno"))+"): ");
					System.out.println("First name: "+ele.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last name: "+ele.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("nick name: "+ele.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Marks name: "+ele.getElementsByTagName("marks").item(0).getTextContent());
				}
			}
		}catch(Exception e)
		{
			
		}

	}

}
