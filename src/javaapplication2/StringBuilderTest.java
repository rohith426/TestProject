/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author user
 */



public class StringBuilderTest {

  

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        nums.peek(n -> n%2 == 0).forEach( s -> System.out.print(" "+s));
    }
}
//public class StringBuilderTest {
//      public static void main(String[] args) {
//          
//          StringBuilder s1 = new StringBuilder("Java");
//          String s2 = "Love";
//          s1.append(s2);
//          System.out.println("S1=="+s1);
//          s1.substring(4);
//           System.out.println("Substring=="+s1.substring(4));
//          int foundAt = s1.indexOf(s2);
//          System.out.println(foundAt);
//      }
//            
//}
