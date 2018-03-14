/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;


import java.io.File;

public class FileDemo {
   public static void main(String[] args) {
      
      File f = null;
      File f1 = null;
      boolean bool = false;
      
      try{      
         // create new File objects
         f = new File("C:/test/Vijay.xml");
         f1 = new File("C:/test/vijay/Vijay.xml");
         
         // rename file
         bool = f.renameTo(f1);
         
         // print
         System.out.print("File renamed? "+bool);
         
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }
   }
}