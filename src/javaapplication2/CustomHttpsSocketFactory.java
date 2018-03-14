/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

/**
 *
 * @author user
 */
public class CustomHttpsSocketFactory implements SecureProtocolSocketFactory
{

   private final SecureProtocolSocketFactory base;

   public CustomHttpsSocketFactory(ProtocolSocketFactory base)
   {
      if(base == null || !(base instanceof SecureProtocolSocketFactory)) throw new IllegalArgumentException();
      this.base = (SecureProtocolSocketFactory) base;
   }

   private Socket acceptOnlyTLS12(Socket socket)
   {
      if(!(socket instanceof SSLSocket)) return socket;
      SSLSocket sslSocket = (SSLSocket) socket;
      sslSocket.setEnabledProtocols(new String[]{"TLSv1.2" });
      return sslSocket;
   }

   @Override
   public Socket createSocket(String host, int port) throws IOException
   {
      return acceptOnlyTLS12(base.createSocket(host, port));
   }
   @Override
   public Socket createSocket(String host, int port, InetAddress localAddress, int localPort) throws IOException
   {
      return acceptOnlyTLS12(base.createSocket(host, port, localAddress, localPort));
   }
   @Override
   public Socket createSocket(String host, int port, InetAddress localAddress, int localPort, HttpConnectionParams params) throws IOException
   {
      return acceptOnlyTLS12(base.createSocket(host, port, localAddress, localPort, params));
   }
   @Override
   public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException
   {
      return acceptOnlyTLS12(base.createSocket(socket, host, port, autoClose));
   }

}