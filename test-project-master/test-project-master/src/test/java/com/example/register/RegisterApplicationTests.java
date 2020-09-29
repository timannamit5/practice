package com.example.register;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.register.beans.CreditCard;
import com.example.register.beans.Customer;
import com.example.register.util.CustomerFieldValidator;
import com.example.register.util.Gender;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.Number;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RegisterApplicationTests {
	
	@InjectMocks
	CustomerFieldValidator cValidator = new CustomerFieldValidator();
	
	//@Mock // Here we need to interact with the Data console : the console which will access data from the db. 
	// The data model can be mocked using the @Mock. 
	Customer customer;
	
	@Before 
	public void initializMockito()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void validityTest1() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE);
		assertEquals((cValidator.isAgeValid(customer.getDateOfBirth() ) && cValidator.isEmailValid(customer.getUsername()) && cValidator.isPasswordValid(customer.getPassword())), true);
	}
	
	//invlaid password
	@Test
	void validityTest2() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE);
		assertEquals((cValidator.isAgeValid(customer.getDateOfBirth() ) && cValidator.isEmailValid(customer.getUsername()) && cValidator.isPasswordValid(customer.getPassword())), true);
	}
	
	//invalid id
	@Test
	void validityTest3() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("df", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE);
		assertEquals((cValidator.isAgeValid(customer.getDateOfBirth() ) && cValidator.isEmailValid(customer.getUsername()) && cValidator.isPasswordValid(customer.getPassword())), true);
	}
	
	//invalid date of birth
	@Test
	void validityTest4() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-2015");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE);
		assertEquals((cValidator.isAgeValid(customer.getDateOfBirth() ) && cValidator.isEmailValid(customer.getUsername()) && cValidator.isPasswordValid(customer.getPassword())), true);
	}
	
}
