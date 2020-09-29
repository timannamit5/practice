package com.example.register.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreditCard {
	
	private Number creditCardNo;
	private Number cvv;
	private Date expiry;
	public CreditCard(Number creditCardNo, Number cvv, Date expiry) {
		super();
		this.creditCardNo = creditCardNo;
		this.cvv = cvv;
		this.expiry = expiry;
	}

	
}

