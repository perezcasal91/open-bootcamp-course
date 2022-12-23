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

/**
 * Class with an example of read and write an XML.
 */
public class ReadWriteXML {
    private final Document document;
    private final File file;
    public ReadWriteXML(){
        try {
            DocumentBuilderFactory dbfDocument = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder dbDocument = dbfDocument.newDocumentBuilder();
            this.file = new File("src/resources/xml/xml_file.xml");
            this.document = dbDocument.parse(this.file);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read the XML File, from the first Node.
     */
    public void read(){
        readNode(this.document.getChildNodes());
    }

    /**
     * Recursive read of the xml,
     * Read the Head Node and them go to his children.
     * @param nodeList The first child node of the document.
     */
    private void readNode(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node cNode = nodeList.item(i);
            if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.print(cNode.getNodeName() + ":");
                for (int j = 0; j < cNode.getAttributes().getLength(); j++) {
                    String sNodeName = cNode.getAttributes().item(j).getNodeName();
                    String sNodeValue = cNode.getAttributes().item(j).getNodeValue();
                    System.out.print(" " + sNodeName + "=" + sNodeValue);
                }
                System.out.println();
                readNode(cNode.getChildNodes());
            }
        }
    }

    /**
     * Write a new node from the parent tag.
     * @param tagParent Tag of the parent.
     * @param valueChild New node.
     */
    public void write(String tagParent, String valueChild) {
        try {
            int iLevel = 0;
            writeNode(this.document.getChildNodes(), tagParent, valueChild, iLevel);
            TransformerFactory tfTransformer = TransformerFactory.newInstance();
            Transformer cTransformer = tfTransformer.newTransformer();
            this.document.normalizeDocument();
            DOMSource dsDOM = new DOMSource(this.document);
            StreamResult srStream = new StreamResult(file);
            cTransformer.transform(dsDOM, srStream);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Write the new node from the parent.
     * Looping all the xml file until find the parent,
     * when find it crete the new node with the indentation and the attribute name.
     * @param nodeList The first child nodes of the document.
     * @param tagParent Tag of the parent.
     * @param valueChild New node.
     * @param level The level where the node is, it's use for the indentation of the new node.
     */
    private void writeNode(NodeList nodeList, String tagParent, String valueChild, int level) {
        level++;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node cNode = nodeList.item(i);
            if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                if (cNode.getNodeName().equals(tagParent)) {
                    Text cLineJumpE = this.document.createTextNode("\n");
                    Text cNewElementIndentationFirstTime = this.document
                                    .createTextNode(String.format("%" + (level * 4)  + "s", ""));
                    Text cNewElementIndentation = this.document
                            .createTextNode(String.format("%" + (4)  + "s", ""));
                    if (cNode.getChildNodes().getLength() == 0 || cNode.getChildNodes().getLength() == 1) {
                        cNode.appendChild(cLineJumpE);
                        cNode.appendChild(cNewElementIndentationFirstTime);
                    } else {
                        cNode.appendChild(cNewElementIndentation);
                    }
                    Element cNewElement = this.document.createElement(valueChild);
                    cNewElement.setAttribute("name", level + "");
                    cNode.appendChild(cNewElement);
                    Text cLineJumpN = this.document.createTextNode("\n");
                    cNode.appendChild(cLineJumpN);
                    Text cNodeIndentation = this.document
                            .createTextNode(String.format("%" + (level - 1) * 4 + "s", ""));
                    cNode.appendChild(cNodeIndentation);
                }
                writeNode(cNode.getChildNodes(), tagParent, valueChild, level);
            }
        }
    }
}
