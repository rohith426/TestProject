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
public class Test1 {
    public static void main(String args[]){
	Object str = new String("abc");
		
	if(str instanceof String){
		System.out.println("String value:"+str);
	}
		
	if(str instanceof Integer){
		System.out.println("Integer value:"+str);
	}
}
}
