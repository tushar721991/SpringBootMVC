package com.tt.BankFrontEnd.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userName, String password) {
		
		return (userName.equalsIgnoreCase("Tushar") || userName.equalsIgnoreCase("Mak")) && password.equalsIgnoreCase("123");
	}
	
}
