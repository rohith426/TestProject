/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.StringTokenizer;
/**
 *
 * @author user
 */
public class StringTokenizer1 {
     
    public static void main(String[] args) {
		
//		String str = "415251010,19.02";
// 
//		System.out.println("StringTokenizer Example: \n");
//		StringTokenizer st = new StringTokenizer(str, ",");
//                System.out.println("StringTokenizer Output1: " + st.nextToken());
//                System.out.println("StringTokenizer Output2: " + st.nextToken());
//		while (st.hasMoreElements()) {
//			System.out.println("StringTokenizer Output: " + st.nextElement());
//		}
// 
//		System.out.println("\n\nSplit Example: \n");
//		String[] tokens = str.split(",");
//		int tokenCount = tokens.length;
//		for (int j = 0; j < tokenCount; j++) {
//			System.out.println("Split Output: "+ tokens[j]);
//		}
            String itemDescription="MOTOR & PUMP ASSY,";
            if(itemDescription.contains("&"))
                        itemDescription=itemDescription.replace('&',' ');
            System.out.println("Item Description=="+itemDescription);
            
	}

    
    
}
