/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/*
 * $Header:
 * $Revision$
 * $Date$
 * ====================================================================
 *
 *  Copyright 2002-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * This is a sample application that demonstrates
 * how to use the Jakarta HttpClient API.
 *
 * This application sends an XML document
 * to a remote web server using HTTP POST
 *
 * @author Sean C. Sullivan
 * @author Ortwin Glück
 * @author Oleg Kalnichevski
 */
public class PostXML {

    /**
     *
     * Usage:
     *          java PostXML http://mywebserver:80/ c:\foo.xml
     *
     *  @param args command line arguments
     *                 Argument 0 is a URL to a web server
     *                 Argument 1 is a local filename
     *
     */
    public static void main(String[] args) throws Exception {



        // Get target URL
        //String strURL = args[0];
//        String strURL = "http://203.206.178.177:8080/Auto/punchoutSetup.action";
        
               // String strURL = "http://localhost:8080/Auto/purchaseOrder.action?username=ausdrill_admin&password=adminin";
//                String strURL = "http://60.241.54.94:8081/Auto/purchaseOrder.action?username=ausdrill_admin&password=adminin";
                // String strURL = "http://nexusb2bnetwork.info/Auto/purchaseOrder.action?username=ausdrill_admin&password=adminin";
                // String strURL = "https://ausdrill.coupahost.com/cxml/invoices";
                 String strURL = "http://192.168.1.45:5031";
//                 String strURL = "https://52.65.21.224:4002";
                         
        String strCXML=null;
         DocumentBuilder builder;
        // Get file to be posted
        //String strXMLFilename = args[1];
//        String strXMLFilename = "C:\\Test\\20150114023036.xml\\";
         String strXMLFilename = "C:\\Users\\user\\Desktop\\test\\99999999_20170515152301.xml";


//         String output = "C:\\Test\\output.xml\\";

        File input = new File(strXMLFilename);

       
 
//        strCXML = "<?xml version=" + "\"" + "1.0" + "\"" + " encoding=" + "\"" + "UTF-8" + "\"" + "?>";
//        strCXML = strCXML + "<!DOCTYPE cXML SYSTEM " + "\"" + "http://xml.cxml.org/schemas/cXML/1.2.023/cXML.dtd" + "\"" + ">";
//        //strCXML = strCXML + "<cXML payloadID="+ "\"" +payloadId + "\"" +" xml:lang="+"\"en-US"+ "\" timestamp="+ "\"" + timestmp + "\" version=" +"\"1.2.0.14" +"\"" + ">";
//        strCXML = strCXML + " <cXML payloadID=" + "\"1421206652.451895@ip-10-182-62-30\"" + " timestamp=" + "\"Fri, 30 Jan 2015 11:10:32 +0000\"" + ">";
//        strCXML = strCXML + "<Header>";
//        strCXML = strCXML + "<From>";
//        strCXML = strCXML + "<Credential domain=" + "\"DUNS\"" + ">";
//         strCXML = strCXML + "<Identity>123456</Identity>";
//        strCXML = strCXML + "</Credential>";
//        strCXML = strCXML + "</From>";
//        strCXML = strCXML + "<To>";
//        strCXML = strCXML + "<Credential domain=" + "\"Auto\"" + ">";
//        strCXML = strCXML + "<Identity>123456</Identity>";
//        strCXML = strCXML + "</Credential>";
//        strCXML = strCXML + "</To>";
//        strCXML = strCXML + "<Sender>";
//        strCXML = strCXML + "<Credential domain=" + "\"DUNS\"" + ">";
//        strCXML = strCXML + "<Identity>123456</Identity>";
//        strCXML = strCXML + "<SharedSecret>adminin</SharedSecret>";
//        strCXML = strCXML + "</Credential>";
//        strCXML = strCXML + "<UserAgent>Coupa Procurement 1.0</UserAgent>";
//        strCXML = strCXML + "</Sender>";
//        strCXML = strCXML + "</Header>";
//
//        strCXML = strCXML + "<Request>";
//
//        strCXML = strCXML + "<PunchOutSetupRequest operation=\"create\">";
//        strCXML = strCXML + "<BuyerCookie>4c92d98b06909abe502c9b58b740e98199</BuyerCookie>";
//         strCXML = strCXML + "<Extrinsic name=" + "\"FirstName" + "\">" + "Chris" + "</Extrinsic>";
//         strCXML = strCXML + "<Extrinsic name=" + "\"LastName" + "\">" + "Santa Maria" + "</Extrinsic>";
//          strCXML = strCXML + "<Extrinsic name=" + "\"UniqueName" + "\">" + "chris.santamaria@ausdrill.com.au" + "</Extrinsic>";
//           strCXML = strCXML + "<Extrinsic name=" + "\"UserEmail" + "\">" + "chris.santamaria@ausdrill.com.au" + "</Extrinsic>";
//            strCXML = strCXML + "<Extrinsic name=" + "\"User" + "\">" + "chris.santamaria@ausdrill.com.au" + "</Extrinsic>";
//             strCXML = strCXML + "<Extrinsic name=" + "\"BusinessUnit" + "\">" + "COUPA" + "</Extrinsic>";
//
//             strCXML = strCXML + "<BrowserFormPost>";
//              strCXML = strCXML + "<URL>https://ausdrill-test.coupahost.com/punchout/checkout?id=11</URL>";
//            strCXML = strCXML + "</BrowserFormPost>";
//            strCXML = strCXML + "<Contact role=\"endUser\">";
//            strCXML = strCXML + "<Name xml:lang=" + "\"en-GB" + "\">" + "chris.santamaria@ausdrill.com.au" + "</Name>";
//            strCXML = strCXML + "<Email>" + "chris.santamaria@ausdrill.com.au" + "</Email>";
//            strCXML = strCXML + "</Contact>";
//            strCXML = strCXML + "<SupplierSetup>";
//             strCXML = strCXML + "<URL>http://203.206.178.177:5031</URL>";
//      strCXML = strCXML + "</SupplierSetup>";
//        strCXML = strCXML + "</PunchOutSetupRequest>";
//        strCXML = strCXML + "</Request>";
//        strCXML = strCXML + "</cXML>";
//
//        System.out.println("request==: " + strCXML);
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

//         builder = factory.newDocumentBuilder();

            // Use String reader
//            Document document = builder.parse( new InputSource(new StringReader( strCXML ) ) );
//            document .setXmlStandalone(true);

            //InputSource input=new InputSource(new StringReader( strCXML ));

//             TransformerFactory tranFactory = TransformerFactory.newInstance();
//            Transformer aTransformer = tranFactory.newTransformer();
//           // aTransformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
//aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            Source src = new DOMSource( document );
//            Result dest = new StreamResult( new File(output ));
//            aTransformer.transform( src, dest );

 //File input = new File(strXMLFilename);

        // Prepare HTTP post
        PostMethod post = new PostMethod(strURL);

        // Request content will be retrieved directly
        // from the input stream
        // Per default, the request content needs to be buffered
        // in order to determine its length.
        // Request body buffering can be avoided when
        // content length is explicitly specified
        post.setRequestEntity(new InputStreamRequestEntity(new FileInputStream(input), input.length()));
//        post.setRequestEntity(new InputStreamRequestEntity(new FileInputStreamStream(strCXML), strCXML.length()));


        // Specify content type and encoding
        // If content encoding is not explicitly specified
        // ISO-8859-1 is assumed
        post.setRequestHeader("Content-type", "application/xml; charset=ISO-8859-1");

        // Get HTTP client
        HttpClient httpclient = new HttpClient();

        // Execute request
        try {

            int result = httpclient.executeMethod(post);

            // Display status code
            System.out.println("Response status code: " + result);

            // Display response
            System.out.println("Response body: ");
            System.out.println(post.getResponseBodyAsString());

        } finally {
            // Release current connection to the connection pool
            // once you are done
            post.releaseConnection();
        }
    }
}