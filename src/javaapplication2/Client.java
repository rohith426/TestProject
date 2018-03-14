/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * }
 *
 * @author user
 */
import javax.net.ssl.*;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Vector;

public class Client {

    public static void main(String[] args) {
        talk("https://52.65.21.224:4002", "C:\\Test\\Ausdrill\\ANW-10049286_201607271558212.xml\\");
    }

    private static void talk(String urlval, String msgPath) {
        try {

            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage msg = mf.createMessage();

            SOAPPart sp = msg.getSOAPPart();

            StreamSource prepMsg = new StreamSource(new FileInputStream(msgPath));

            sp.setContent(prepMsg);

            msg.saveChanges();

            System.out.println("\n Soap request:\n");

           // msg.writeTo(System.out);

            System.out.println();

            doTrustToCertificates();

            SOAPMessage rp = sendMessage(msg, urlval);

            System.out.println("\nXML response\n");
            TransformerFactory tff = TransformerFactory.newInstance();

            Transformer tf = tff.newTransformer();

            Source sc = rp.getSOAPPart().getContent();
            StreamResult result = new StreamResult(System.out);

            tf.transform(sc, result);

            System.out.println();
            Vector list = new Vector();
            SOAPBody soapBody = rp.getSOAPBody();
            Iterator iterator1 = soapBody.getChildElements();
            while (iterator1.hasNext()) {
                SOAPBodyElement ThisBodyElement = (SOAPBodyElement) iterator1.next();
                Iterator it2 = ThisBodyElement.getChildElements();
                while (it2.hasNext()) {
                    SOAPElement child2 = (SOAPElement) it2.next();
                    Iterator it3 = child2.getChildElements();
                    while (it3.hasNext()) {
                        SOAPElement child3 = (SOAPElement) it3.next();
                        String value = child3.getValue();
                        list.addElement(value);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.elementAt(i));
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    static public SOAPMessage sendMessage(SOAPMessage message, String endPoint) throws MalformedURLException, SOAPException {

        SOAPMessage result = null;

        if (endPoint != null && message != null) {

            URL url = new URL(endPoint);

            SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();

            SOAPConnection connection = null;

            long time = System.currentTimeMillis();

            try {

                connection = scf.createConnection(); //point-to-point connection

                result = connection.call(message, url);

            } finally {

                if (connection != null) {

                    try {

                        connection.close();

                    } catch (SOAPException soape) {

                        System.out.print("Can't close SOAPConnection:" + soape);

                    }

                }

            }

        }

        return result;

    }

    static public void doTrustToCertificates() throws Exception {

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {

                public X509Certificate[] getAcceptedIssuers() {

                    return null;

                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {

                    return;

                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {

                    return;

                }
            }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
}
