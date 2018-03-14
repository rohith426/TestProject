/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author user
 */
public class InstantExample {
    public static void main(String[] args) {
		//Current timestamp
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = "+timestamp);
		System.out.println("timestamp.toEpochMilli() = "+timestamp.toEpochMilli());
		//Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = "+specificTime);
		
		//Duration example
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay);
	}

}
