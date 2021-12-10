import java.rmi.RemoteException;

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

public class MiddlewareServidorBImp implements MiddlewareServidorB {

    public MiddlewareServidorBImp() throws RemoteException {

    }

    public String buscarTitulo(String tituloBuscado) throws RemoteException {

        String env = "";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("biblioteca A.xml"));

            document.getDocumentElement().normalize();

            NodeList libroList = document.getElementsByTagName("book");
            for (int i = 0; i < libroList.getLength(); i++) {
                Node libro = libroList.item(i);
                if (libro.getNodeType() == Node.ELEMENT_NODE) {

                    Element libroElement = (Element) libro;
                    System.out.println("Libro: " + libroElement.getAttribute("name"));

                    NodeList libroDetails = libro.getChildNodes();
                    Node detail = libroDetails.item(1);
                    Element detailElement = (Element) detail;
                    String st = String.valueOf(detailElement.getAttribute("value"));

                    if (st.equals(tituloBuscado)) {
                        System.out.println("b1");
                        for (int j = 0; j < libroDetails.getLength(); j++) {
                            detail = libroDetails.item(j);
                            if (detail.getNodeType() == Node.ELEMENT_NODE) {
                                detailElement = (Element) detail;
                                env = env + detailElement.getTagName() + ": " + detailElement.getAttribute("value")
                                        + "\n";
                                System.out.println(env);

                            }

                        }
                        break;

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
        return env;
    }

    public String buscarAutor(String autorBuscado) throws RemoteException {

        String env = "";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("biblioteca A.xml"));

            document.getDocumentElement().normalize();

            NodeList libroList = document.getElementsByTagName("book");
            for (int i = 0; i < libroList.getLength(); i++) {
                Node libro = libroList.item(i);
                if (libro.getNodeType() == Node.ELEMENT_NODE) {

                    Element libroElement = (Element) libro;
                    System.out.println("Libro: " + libroElement.getAttribute("value"));

                    NodeList libroDetails = libro.getChildNodes();

                    Node detail = libroDetails.item(3);
                    Element detailElement = (Element) detail;
                    String aut = String.valueOf(detailElement.getAttribute("value"));

                    if (aut.equals(autorBuscado)) {
                        System.out.println("b2");
                        for (int j = 0; j < libroDetails.getLength(); j++) {
                            detail = libroDetails.item(j);
                            if (detail.getNodeType() == Node.ELEMENT_NODE) {
                                detailElement = (Element) detail;
                                env = env + detailElement.getTagName() + ": " + detailElement.getAttribute("value")
                                        + "\n";
                                System.out.println(env);

                            }

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
        return env;

    }

    public String traduccionLengZ(String comando) throws RemoteException {
        // este metodo recibe el comando traducido a lenguaje Z

        if (comando.indexOf("getTittle") == 1) {
            // si recibe el comando getTittle entonces extrae el titulo que debe buscar y
            // hace la llamada al metodo correspondiente

            comando = comando.replaceAll("getTittle", "");
            comando = comando.replaceAll("(", "");
            comando = comando.replaceAll(")", "");
            return buscarTitulo(comando);

        } else {
            // sino eso significa que el comando es getAuthor extrae el autor que debe
            // buscar y hace la llamada al metodo correspondiente

            comando = comando.replaceAll("getAuthor", "");
            comando = comando.replaceAll("(", "");
            comando = comando.replaceAll(")", "");
            return buscarAutor(comando);
        }
    }
}