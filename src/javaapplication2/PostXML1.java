/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author user
 */
public class PostXML1 {
    public static void main(String[] args) throws Exception {



    // Get target URL
    String strURL = "https://52.65.21.224:4002";

    // Get file to be posted
    String strXMLFilename = "C:\\Test\\Ausdrill\\ANW-10049286_201607271558212.xml\\";
    File input = new File(strXMLFilename);

    // Prepare HTTP post
    PostMethod post = new PostMethod(strURL);

    // Request content will be retrieved directly
    // from the input stream
    // Per default, the request content needs to be buffered
    // in order to determine its length.
    // Request body buffering can be avoided when
    // content length is explicitly specified
    post.setRequestEntity(new InputStreamRequestEntity(
            new FileInputStream(input), input.length()));

    // Specify content type and encoding
    // If content encoding is not explicitly specified
    // ISO-8859-1 is assumed
    post.setRequestHeader(
            "Content-type", "text/xml; charset=ISO-8859-1");

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


    }catch (Exception e) {
        e.printStackTrace();

    } finally {
        // Release current connection to the connection pool 
        // once you are done
        post.releaseConnection();
    }
}
}
