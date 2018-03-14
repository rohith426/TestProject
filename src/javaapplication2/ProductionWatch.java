/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;   
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class ProductionWatch
{
    public static void main(String args[]) throws Exception {
        String ipAddress = "52.65.21.224";
//        String ipAddress = "192.168.1.45";
        ProductionWatch tc = new ProductionWatch();
//        boolean systemStatus = tc.isSystemUp(ipAddress);
//        if (systemStatus) {
            boolean flag_tomcat = tc.isPortInUse(ipAddress, 8080);
//            boolean flag_tomcat_Staging = tc.isPortInUse(ipAddress, 8081);
//            boolean flag_tomcat_RssBus = tc.isPortInUse(ipAddress, 8181);
//            boolean flag_tc_microcat = tc.isPortInUse(ipAddress, 4000);
            boolean flag_tc_Test = tc.isPortInUse(ipAddress, 4002);
            boolean flag_tc_B2BE = tc.isPortInUse(ipAddress, 4003);
//            boolean flag_tc_midway = tc.isPortInUse(ipAddress, 4007);
//            boolean flag_tc_Ausdrill = tc.isPortInUse(ipAddress, 5022);
//            boolean flag_tc_test45 = tc.isPortInUse(ipAddress, 4001);
//            boolean flag_test_AWS = tc.isPortInUse("60.241.54.94", 4001);
//            System.out.println("flag value==" + flag_test_AWS);
            if (!flag_tomcat) {
                System.out.println("There is problem with the application called Tomcat");
                sendMessagethroughGmail("Tomcat");
            }
//            if (!flag_tomcat_Staging) {
//                System.out.println("There is problem with the application called Tomcat Staging");
//                sendMessagethroughGmail("Tomcat Staging");
//            }if (!flag_tomcat_RssBus) {
//                System.out.println("There is problem with the application called RSSBus");
//                sendMessagethroughGmail("RSSBus");
//            }if (!flag_tc_microcat) {
//                System.out.println("There is problem with the application called TradeConnect Microcat");
//                sendMessagethroughGmail("TradeConnect Microcat");
//            }
              if (!flag_tc_Test) {
                System.out.println("There is problem with the application called TradeConnect Test");
                sendMessagethroughGmail("TradeConnect Test");
            }if (!flag_tc_B2BE) {
                System.out.println("There is problem with the application called TradeConnect B2BE");
                sendMessagethroughGmail("TradeConnect B2BE");
            }
//            if (!flag_tc_midway) {
//                System.out.println("There is problem with the application called TradeConnect Midway");
//                sendMessagethroughGmail("TradeConnect Midway");
//            }if (!flag_tc_Ausdrill) {
//                System.out.println("There is problem with the application called TradeConnect AusDrill");
//                sendMessagethroughGmail("TradeConnect AusDrill");
//            }if (!flag_tc_test45) {
//                System.out.println("There is problem with the application called TradeConnect Test45");
//                sendMessagethroughGmail("TradeConnect Test45");
//            }if (!flag_test_AWS) {
//                System.out.println("There is problem with the application called TradeConnect AWS");
//                sendMessagethroughGmail("TradeConnect AWS");
//            }
//        } else {
//            System.out.println("There is problem with the Production System");
//            sendMessagethroughGmail("Production System Down");
//        }
    }

    private boolean isPortInUse(String hostName, int portNumber) {
        boolean result;
        try {
            Socket s = new Socket(hostName, portNumber);
            s.close();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return (result);
    }

//    private boolean isSystemUp(String ipAddress) throws UnknownHostException {
//        boolean status = false;
//        try {
//            InetAddress inet = InetAddress.getByName(ipAddress);
//            status = inet.isReachable(5000); //Timeout = 5000 milli seconds
//            System.out.println("status==" + status);
//        } catch (IOException ex) {
//            Logger.getLogger(ProductionWatch.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return status;
//    }

    public static boolean sendMessagethroughGmail(String appName) throws UnsupportedEncodingException {
        boolean success = false;
        final String username = "vthumma@ivbplus.com.au";
        final String password = "vijay125";
        String from = "techhelp@ivbplus.com.au";
        String to = "vthumma@ivbplus.com.au";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        String subject = "Production failure: problem with " + appName;
        String msgText = "Mr/Mrs,";
        msgText += "\n\n There is problem with your production server application called " + appName + ". Please take the necessary action. ";
        msgText += "\n\n Best regards";
        msgText += "\n\n Nexus Support Team";

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from, "IVBPlus Tech Team"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(msgText);

            Transport.send(message);
            success = true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return success;
    }
}

