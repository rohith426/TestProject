/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 *
 * @author user
 */
public class LocalTimeExample {
    public static void main(String[] args) {
		
		//Current Time
		LocalTime time = LocalTime.now();
		System.out.println("Current Time="+time);
		
		//Creating LocalTime by providing input arguments
		LocalTime specificTime = LocalTime.of(23,20,25,40);
		System.out.println("Specific Time of Day="+specificTime);
		
		
		//Try creating time by providing invalid inputs
		//LocalTime invalidTime = LocalTime.of(25,20);
		//Exception in thread "main" java.time.DateTimeException: 
		//Invalid value for HourOfDay (valid values 0 - 23): 25
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalTime timeKolkata = LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println("Current Time in IST="+timeKolkata);

		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		//LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));
		
		//Getting date from the base date i.e 01/01/1970
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(1000);
		System.out.println("10000th second time= "+specificSecondTime);

	}
}
