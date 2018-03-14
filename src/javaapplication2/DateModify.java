/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class DateModify {
    
     public static void main(String args[]) {
        try {
            String str="2016-05-17T03:09:31.3149347+02:00";
           // System.out.println("dfs="+str.split(".")[0]);
            DateModify p = new DateModify();
                StringBuffer str1=new StringBuffer();
        
         str1.append(str.split("T")[0]);         
         str1.append(" ");
        str1.append(str.split("T")[1].substring(0,8));
       
        
            System.out.println("today="+str1);
           // p.getDateNanos();
           // p.getDate();

        //System.out.println("Done...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
