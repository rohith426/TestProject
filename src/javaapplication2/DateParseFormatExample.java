/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class DateParseFormatExample {
    public static void main(String[] args) {
		
		//Format examples
		LocalDate date = LocalDate.now();
		//default format
		System.out.println("Default format of LocalDate="+date);
		//specific format
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::u")));
		System.out.println(date.format(DateTimeFormatter.ISO_DATE));
		
		
		LocalDateTime dateTime = LocalDateTime.now();
		//default format
		System.out.println("Default format of LocalDateTime="+dateTime);
		//specific format
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
		System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		
		Instant timestamp = Instant.now();
		//default format
		System.out.println("Default format of Instant="+timestamp);
		
		//Parse examples
		LocalDateTime dt = LocalDateTime.parse("07::Apr::2014 21::39::48",
				DateTimeFormatter.ofPattern("dd::MMM::uuuu HH::mm::ss"));
		System.out.println("Default format after parsing = "+dt);
	}
}
