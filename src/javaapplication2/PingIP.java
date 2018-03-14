/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class PingIP {

  public static void runSystemCommand(String command) {

		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String s = "";
                        boolean flag=false;
			// reading output stream of the command
                      
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
//                            flag=true;
			}
//                        System.out.println("System ready=="+flag);
                           InetAddress inet = InetAddress.getByName("52.65.21.224");
                           boolean status = inet.isReachable(5000); //Timeout = 5000 milli seconds
                           System.out.println("status=="+status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		String ip = "52.65.21.224";
		runSystemCommand("ping " + ip);

	
	}
}