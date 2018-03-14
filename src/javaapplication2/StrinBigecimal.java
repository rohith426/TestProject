/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class StrinBigecimal {
     public static void main(String[] args) throws UnsupportedEncodingException {
        String str="8.658";
        System.out.println("bigdecimal value=="+new BigDecimal(str));
        int quantity = 2;
            BigDecimal unitPrice= new BigDecimal(25.553);
            BigDecimal price = unitPrice.multiply(new BigDecimal(quantity)).setScale(3, BigDecimal.ROUND_HALF_UP);
            BigDecimal tax = price.multiply(new BigDecimal(0.1)).setScale(3, BigDecimal.ROUND_HALF_UP);
            BigDecimal cost = price.add(tax);
            System.out.println("bigdecimal value price=="+price+"...tax="+tax+"...cost="+cost);
    }
}
