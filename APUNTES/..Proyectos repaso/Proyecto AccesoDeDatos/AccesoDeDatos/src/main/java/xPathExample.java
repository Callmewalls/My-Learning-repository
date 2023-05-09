import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class xPathExample {
    public static void main(String[] args) {

        try
        {
            File file = new File("src/test/java/parsers.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(true);
            dbf.setIgnoringElementContentWhitespace(true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(file);

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "/catalog/book";

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(d, XPathConstants.NODESET);

            for(int i = 0; i < nodeList.getLength(); i++)
            {
                Node n = nodeList.item(i);
                System.out.println("\nCurrent Element: " + n.getNodeName());

                if(n.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element el = (Element) n;
                }
            }
        }
        catch(ParserConfigurationException | SAXException | IOException | XPathExpressionException e){e.printStackTrace();}

    }
}
