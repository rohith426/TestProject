/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.serialize.XMLSerializer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

//import org.w3c.dom.Document;
/**
 *
 * @author user
 */
public class ExtractXML {

    public static void main(String[] args) throws Exception {
        SAXBuilder _xmlBuilder = null;
        Document doc = null;
        List<Element> list = new ArrayList<Element>();
        try {

            _xmlBuilder = new SAXBuilder();
            _xmlBuilder.setReuseParser(false);
            //doc = _xmlBuilder.build("C:\\Test\\Ausdrill\\ASL-10048786_20160725144410.xml");
            doc = _xmlBuilder.build("C:\\Test\\20161122063143.xml");
            Element root = doc.getRootElement();

            System.out.println("root value=" + root.getName());
            
                    
                    
            File fout1 = new File("C:\\Test\\20161122063143_interim.xml");
                        //doc.getRootElement().getAttributeValue("xmlns").setText("Archisha");
                        //root.removeAttribute("xmlns");
                       // root.getAttribute("Archi").setValue("sdf");
//                        System.out.println("aval=" + aval);
                       // root.removeChild("xmlns");
                       root.s(new Namespace("xmlns"));
                         System.out.println("flag value=" + flag);
                        FileOutputStream f11 = new FileOutputStream(fout1);
                        org.jdom.output.XMLOutputter _xmlWriter;
                        _xmlWriter = new org.jdom.output.XMLOutputter();
                        _xmlWriter.output(doc, f11);
                        f11.close();
                        f11 = null;
                        fout1 = null;
                        
                        
                          doc.r

//            String headerLevelComment = root.getChild("Request").getChild("OrderRequest").getChild("OrderRequestHeader").getChild("Extrinsic").getValue();
//            System.out.println("headerLevelComment value=" + headerLevelComment);

//             list = root.getChild("Request").getChild("OrderRequest").getChildren();
//                for (Element lineItem : list) {
//                    if (lineItem.getName().equals("ItemOut")) {
//                        String deliverydate = lineItem.getAttributeValue("requestedDeliveryDate");
//                        String linelevelcomment = lineItem.getChild("ItemDetail").getChild("Extrinsic").getValue();
//                         System.out.println("deliverydate value=" + deliverydate+"....linelevelcomment=="+linelevelcomment);
//                    }
//                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
}
