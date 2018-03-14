/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom.JDOMException;
import org.jdom.output.DOMOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author user
 */
public class XMLNS {
    public static void main(String[] args) throws Exception {
  // Create an empty XML document
 // Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
  
 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document xml = builder.parse(new File("C:\\Test\\20161122063143.xml"));
Element rootElement = xml.getDocumentElement();
System.out.println("rootElement...."+rootElement);
System.out.println("rootElement...."+rootElement.getNodeName());

  // Rename the root node
  xml.renameNode(rootElement, "", rootElement.getNodeName());
serializeXml(xml);
  // Serialize the document
 // System.out.println(serializeXml(xml));
}

/*
 * Helper function to serialize a XML document.
 */
private static void serializeXml(Document doc) throws Exception {
  Transformer transformer = TransformerFactory.newInstance().newTransformer();
  Source source = new DOMSource(doc.getDocumentElement());
  //StringWriter out = new StringWriter();
  
  
   File resultTempFile = new File("C:\\Test\\20161122063143_trim.xml");
            FileOutputStream fout = new FileOutputStream(resultTempFile.getAbsolutePath());
            StreamResult result = new StreamResult(fout);
            transformer.transform(source, result);
            fout.flush();
            fout.close();
            
//  Result result = new StreamResult(out);
//  transformer.transform(source, result);
//  return out.toString();
}

public org.w3c.dom.Document convertJDOMTOW3C(org.jdom.Document jdomDoc) throws JDOMException {
        DOMOutputter outputter = new DOMOutputter();
        
        return outputter.output(jdomDoc);
    }


}
