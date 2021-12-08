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

public class XMLParser {

    /*
    * Get the Document Builder
    * Get Document
    * Normalize the xml structure
    * Get all the element by the tag name
    * */

    public static void main(String[] args) {

        //Get the Document Builder

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Get Document
            Document document = builder.parse(new File("biblioteca A.xml"));

            // Normalize the xml structure
            document.getDocumentElement().normalize();

            // Get all the element by the tag name

            NodeList libroList = document.getElementsByTagName("book");
            for(int i = 0; i <libroList.getLength(); i++) {
                Node libro = libroList.item(i);
                if(libro.getNodeType() == Node.ELEMENT_NODE) {

                    Element libroElement = (Element) libro;
                    System.out.println("Libro: " + libroElement.getAttribute("name"));

                    NodeList libroDetails =  libro.getChildNodes();
                    Node detail = libroDetails.item(1);
                    System.out.println("dsfsdf" + detail);
                    Element detailElement = (Element) detail;
                    String st=String.valueOf(detailElement.getAttribute("value"));
                    System.out.println(st.equals("dracula"));


                    if (st.equals("dracula")){
                        System.out.println("hola");
                        System.out.println(detailElement.getAttribute("value"));
                    }
                    for(int j = 0; j < libroDetails.getLength(); j++){
                        detail = libroDetails.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE) {
                            detailElement = (Element) detail;
                            System.out.println("     " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                        }

                    }
                    
                }
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}