/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.output.XMLOutputter;
 
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.math.BigDecimal;
/**
 *
 * @author user
 */
public class StringToXML {
    
    public static void main(String[] args) throws IOException{
        final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE cXML SYSTEM \"http://xml.cXML.org/schemas/cXML/1.2.020/InvoiceDetail.dtd\"> <cXML version=\"1.2.014\" payloadID=\"3172802Auto\" timestamp=\"2015-12-04T17:39:35\"><Header><From><Credential domain=\"Auto\"><Identity>ausdrill_admin</Identity></Credential></From><To><Credential domain=\"DUNS\"><Identity>757539440</Identity></Credential></To><Sender><Credential domain=\"Auto\"><Identity>ausdrill_admin</Identity><SharedSecret>adminin</SharedSecret></Credential><UserAgent/></Sender></Header><Request deploymentMode=\"test\"><InvoiceDetailRequest><InvoiceDetailRequestHeader invoiceID=\"88888881025\" purpose=\"standard\" operation=\"new\" invoiceDate=\"2015-12-04T17:39:35\"> <InvoiceDetailHeaderIndicator/><InvoiceDetailLineIndicator isDiscountInLine=\"yes\"/><Extrinsic name=\"CustomFields\"><IdReference domain=\"CustomField\" identifier=\"official_tax_invoice_attachment\"><Description xml:lang=\"en\">TRUE</Description></IdReference></Extrinsic></InvoiceDetailRequestHeader><InvoiceDetailOrder><InvoiceDetailOrderInfo><OrderReference orderID=\"AIMS-10002683\"><DocumentReference payloadID=\"\"/></OrderReference><SupplierOrderInfo orderID=\"AIMS-10002683\"/></InvoiceDetailOrderInfo><InvoiceDetailItem invoiceLineNumber=\"1\" quantity=\"1\"><UnitOfMeasure>EA</UnitOfMeasure><UnitPrice><Money currency=\"AUD\">31.21</Money></UnitPrice><InvoiceDetailItemReference lineNumber=\"1\"><ItemID><SupplierPartID>0    F520 17315</SupplierPartID></ItemID><Description xml:lang=\"en\">SHAFT IDLE GEAR</Description></InvoiceDetailItemReference><SubtotalAmount><Money currency=\"AUD\">31.21</Money></SubtotalAmount><GrossAmount><Money currency=\"AUD\">34.33</Money></GrossAmount><InvoiceDetailDiscount><Money currency=\"AUD\">0.00</Money></InvoiceDetailDiscount><NetAmount><Money currency=\"AUD\">34.33</Money></NetAmount><Comments/><Extrinsic name=\"LineType\">Item</Extrinsic></InvoiceDetailItem><InvoiceDetailItem invoiceLineNumber=\"2\" quantity=\"4\"><UnitOfMeasure>EA</UnitOfMeasure><UnitPrice><Money currency=\"AUD\">6.52</Money></UnitPrice><InvoiceDetailItemReference lineNumber=\"2\"><ItemID><SupplierPartID>000300020Z</SupplierPartID></ItemID><Description xml:lang=\"en\">TBA 665</Description></InvoiceDetailItemReference><SubtotalAmount><Money currency=\"AUD\">26.08</Money></SubtotalAmount><GrossAmount><Money currency=\"AUD\">28.69</Money></GrossAmount><InvoiceDetailDiscount><Money currency=\"AUD\">0.00</Money></InvoiceDetailDiscount><NetAmount><Money currency=\"AUD\">28.69</Money></NetAmount><Comments/><Extrinsic name=\"LineType\">Item</Extrinsic></InvoiceDetailItem><InvoiceDetailItem invoiceLineNumber=\"3\" quantity=\"1\"><UnitOfMeasure>EA</UnitOfMeasure><UnitPrice><Money currency=\"AUD\">8.66</Money></UnitPrice><InvoiceDetailItemReference lineNumber=\"3\"><ItemID><SupplierPartID>000300050B</SupplierPartID></ItemID><Description xml:lang=\"en\">30-5-DRIFT P</Description></InvoiceDetailItemReference><SubtotalAmount><Money currency=\"AUD\">8.66</Money></SubtotalAmount><GrossAmount><Money currency=\"AUD\">9.53</Money></GrossAmount><InvoiceDetailDiscount><Money currency=\"AUD\">0.00</Money></InvoiceDetailDiscount><NetAmount><Money currency=\"AUD\">9.53</Money></NetAmount><Comments/><Extrinsic name=\"LineType\">Item</Extrinsic></InvoiceDetailItem></InvoiceDetailOrder><InvoiceDetailSummary><SubtotalAmount><Money currency=\"AUD\">65.95</Money></SubtotalAmount><Tax><Money currency=\"AUD\">6.60</Money><Description xml:lang=\"\">TotalTax</Description><TaxDetail category=\"GST\" purpose=\"tax\"><TaxableAmount><Money currency=\"AUD\">65.95</Money></TaxableAmount><TaxAmount><Money currency=\"AUD\">6.60</Money></TaxAmount></TaxDetail></Tax><GrossAmount><Money currency=\"AUD\">72.55</Money></GrossAmount><NetAmount><Money currency=\"AUD\">72.55</Money></NetAmount></InvoiceDetailSummary></InvoiceDetailRequest></Request></cXML>";
       // convertStringToDocument(xmlStr);
        BigDecimal bd = new BigDecimal(2.28);
        BigDecimal bd1 = new BigDecimal(2.226);
//System.out.println(bd.setScale(2,BigDecimal.ROUND_CEILING)+"..1.."+bd1.setScale(2,BigDecimal.ROUND_CEILING));
//System.out.println(bd.setScale(2,BigDecimal.ROUND_DOWN)+"..2.."+bd1.setScale(2,BigDecimal.ROUND_DOWN));
//System.out.println(bd.setScale(2,BigDecimal.ROUND_FLOOR)+".3..."+bd1.setScale(2,BigDecimal.ROUND_FLOOR));
System.out.println(bd.setScale(2,BigDecimal.ROUND_HALF_DOWN)+".4..."+bd1.setScale(2,BigDecimal.ROUND_HALF_DOWN));
System.out.println(bd.setScale(2,BigDecimal.ROUND_HALF_EVEN)+"..5.."+bd1.setScale(2,BigDecimal.ROUND_HALF_EVEN));
System.out.println(bd.setScale(2,BigDecimal.ROUND_HALF_UP)+"..6.."+bd1.setScale(2,BigDecimal.ROUND_HALF_UP));
//System.out.println(bd.setScale(2,BigDecimal.ROUND_UNNECESSARY)+"...."+bd1.setScale(2,BigDecimal.ROUND_UNNECESSARY));
//System.out.println(bd.setScale(2,BigDecimal.ROUND_UP)+"...7."+bd1.setScale(2,BigDecimal.ROUND_UP));
         
       
        //System.out.println(doc);
    }
 
    
//    private static void convertStringToDocument(String xmlStr) {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
//        DocumentBuilder builder;  
//        XMLOutputter _xmlWriter = new XMLOutputter();
//        File f=null;
//        BufferedWriter out=null;
//        try 
//        {  
////            f=new File("C:\\Test\\VijayDev\\Test.xml");
//            out = new BufferedWriter(new FileWriter("C:\\Test\\VijayDev\\Test.xml"));
////            builder = factory.newDocumentBuilder();  
////            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
////            FileOutputStream f = new FileOutputStream(f);
////                _xmlWriter.output(xmlStr), f);
////                System.out.println("currOutFile=" + currOutFile.getAbsolutePath());
////                f.close();
////                f = null;
//              out.write(xmlStr);
//           // return doc;
//         } catch (IOException e) {
//        e.printStackTrace();
//    } finally {
//        out.close();
//    }
//        
//    }
    
     private static void convertStringToDocument(String xmlStr) throws IOException{
        BufferedWriter out=null;
        try 
        {  
            out = new BufferedWriter(new FileWriter("C:\\Test\\VijayDev\\Test.xml"));
            out.write(xmlStr);
                SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        String orderDate = dateFormatter.format(new Date());
        System.out.println("orderDate="+orderDate);
        
       

         }catch (IOException e) {
        e.printStackTrace();
    }finally {
     out.close();
    }
        
    }
    
}
