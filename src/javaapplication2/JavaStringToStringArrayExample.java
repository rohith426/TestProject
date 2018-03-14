/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author user
 */
public class JavaStringToStringArrayExample {
      public static void main(String args[]){
               
                //String which we want to convert to String array
//                String str = "vthumma@ivbplus.com.au,tvijayp@gmail.com,tvijayp9@gmail.com";
String str = "vthumma@ivbplus.com.au";
               
                /*
                 * To convert String object to String array, first thing
                 * we need to consider is to how we want to create array.
                 *
                 * In this example, array will be created by words contained
                 * in the original String object. So, first element of array
                 * will contain "java", second will contain "String" and so on.
                 *
                 * To convert String to String array, use
                 * String[] split(String delimiter) method of Java String
                 * class as given below.
                 */
               
                String strArray[] = str.split(",");
               
                System.out.println("String converted to String array");
               
                //print elements of String array
//                for(int i=0; i < strArray.length; i++){
//                        System.out.println(strArray[i]);
//                }
//                System.out.println(strArray.length+"..."+strArray[0]+"..."+strArray[1]+"..."+strArray[2]);
                 System.out.println(strArray.length+"..."+strArray[0]);
        }
}
