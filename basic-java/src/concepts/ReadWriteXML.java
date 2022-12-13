package concepts;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ReadWriteXML {
    private final Document document;
    private final File file;
    public ReadWriteXML(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            this.file = new File("src/resources/xml/xml_file.xml");
            this.document = documentBuilder.parse(this.file);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
    public void read(){
        readNode(this.document.getChildNodes());
    }
    private void readNode(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.print(node.getNodeName() + ":");
                for (int j = 0; j < node.getAttributes().getLength(); j++) {
                    String nodeName = node.getAttributes().item(j).getNodeName();
                    String nodeValue = node.getAttributes().item(j).getNodeValue();
                    System.out.print(" " + nodeName + "=" + nodeValue);
                }
                System.out.println();
                readNode(node.getChildNodes());
            }
        }
    }
    public void write(String tag, String value){
        try {
            int level = 0;
            writeNode(this.document.getChildNodes(), tag, value, level);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            this.document.normalizeDocument();
            DOMSource domSource = new DOMSource(this.document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    private void writeNode(NodeList nodeList, String tag, String value, int level){
        level++;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.getNodeName().equals(tag)){
                    Text lineJumpE = this.document.createTextNode("\n");
                    Text newElementIndentationFirstTime = this.document.createTextNode(String.format("%" + (level * 4)  + "s", ""));
                    Text newElementIndentation = this.document.createTextNode(String.format("%" + (4)  + "s", ""));
                    if (node.getChildNodes().getLength() == 0 || node.getChildNodes().getLength() == 1) {
                        node.appendChild(lineJumpE);
                        node.appendChild(newElementIndentationFirstTime);
                    } else {
                        node.appendChild(newElementIndentation);
                    }
                    Element newElement = this.document.createElement(value);
                    newElement.setAttribute("name", level + "");
                    node.appendChild(newElement);
                    Text lineJumpN = this.document.createTextNode("\n");
                    node.appendChild(lineJumpN);
                    Text nodeIndentation = this.document.createTextNode(String.format("%" + (level - 1) * 4 + "s", ""));
                    node.appendChild(nodeIndentation);
                }
                writeNode(node.getChildNodes(), tag, value, level);
            }
        }
    }
}
