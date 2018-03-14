/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;



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
public class PostXMLAusdrill {

    public static void main(String[] args) throws Exception {

        String strURL = "https://ausdrill.coupahost.com/cxml/invoices";
        String strXMLFilename = "C:\\Users\\user\\Desktop\\test\\test\\67065796_20170602113658.xml";
        
        Integer statusCode= postCXMLInvoice(strURL,strXMLFilename);
        System.out.println("Response status code: " + statusCode);
    }
    
    public static Integer postCXMLInvoice(String url,String filename) throws Exception{
        int result =0;
        File input = new File(filename);
        PostMethod post = new PostMethod(url);
        post.setRequestEntity(new InputStreamRequestEntity(new FileInputStream(input), input.length()));
        post.setRequestHeader("Content-type", "application/xml; charset=ISO-8859-1");
        HttpClient httpclient = new HttpClient();

        try {
                result = httpclient.executeMethod(post);
                System.out.println("Response status code: " + result);
                 System.out.println("Response body: "+post.getResponseBodyAsString());
        } finally {
            post.releaseConnection();
        }
        return result;
    }
}