package com.example.register.util;

import java.util.regex.Pattern;

import com.example.register.beans.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;

public class CustomerFieldValidator {
		
	private static final int MIN_EMAIL_LENGTH = 6;
	private static final int MIN_PASSWORD_LENGTH = 6;
	private static final int MIN_AGE = 18;
	
	public static boolean isEmailValid(String email) {
		int length = email.length();
		
		return (length >= MIN_EMAIL_LENGTH) ? true : false;
	}
	
	public static boolean isPasswordValid(String pwd)
	{
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(pwd);
        boolean isStringContainsSpecialCharacter = matcher.find();
        int length = pwd.length();
        
        if(isStringContainsSpecialCharacter && length >= MIN_PASSWORD_LENGTH)
            return true;
        else    
            return false;
	}
	
	public static boolean isAgeValid(Date date)
	{
		LocalDate dob = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate presentDate = LocalDate.now();
		Period P = Period.between(dob, presentDate);
		
		return (P.getYears()>= MIN_AGE)?true:false;
	}
	
	//validation check for the DB
	//
	//
}
