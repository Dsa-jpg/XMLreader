import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XML {


    public static void main(String[] args) {

        //Get the Document Builder

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Build Document

            Document document = builder.parse(new File("C:\\Users\\nacht\\IdeaProjects\\untitled12\\src\\laptops.xml"));

            //Normalize the XML Structure; It's just too important !!

            document.getDocumentElement().normalize();

            NodeList laptopList = document.getElementsByTagName("laptop");
            for (int i = 0; i < laptopList.getLength(); i++) {
                Node laptop = laptopList.item(i);
                if (laptop.getNodeType() == Node.ELEMENT_NODE) {

                    Element laptopElement = (Element) laptop;
                    System.out.println("Laptop Name: " + laptopElement.getAttribute("name"));

                    NodeList laptopDetails = laptop.getChildNodes();
                    for (int j = 0; j < laptopDetails.getLength(); j++) {
                        Node detail = laptopDetails.item(j);
                        if (detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;
                            System.out.println("     " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                        }

                    }

                }
            }


        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
