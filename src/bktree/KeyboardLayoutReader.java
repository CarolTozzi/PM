package bktree;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class KeyboardLayoutReader {
	
		
	public static void main(String argv[]) 
	{

	    try 
	    {

	    File fXmlFile = new File("C:/Users/IBM_ADMIN/Desktop/Mine/Trabalho PM/KeyboardLayouts.xml");
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();

	    NodeList nList = doc.getElementsByTagName("layout");

	    
	    for (int temp = 0; temp < nList.getLength(); temp++) 
	      {

	        Node nNode = nList.item(temp);

	        if (nNode.getNodeType() == Node.ELEMENT_NODE) 
	        {

	            Element eElement = (Element) nNode;

	            String KeyboardLayout = eElement.getAttribute("model");
	            
	           System.out.println(KeyboardLayout);
	          
	        }
	      }
	    } 
	    
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	 }
}

	

