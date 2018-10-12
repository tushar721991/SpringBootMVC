package com.tt.BankFrontEnd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

import com.tt.BankFrontEnd.service.LoginService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/")
	public String showLoginpage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String handleLogin(HttpServletRequest request, ModelMap map, @RequestParam String name,
			@RequestParam String password) {
		boolean isValid = loginService.validateUser(name, password);
		
		if (!isValid) {
			map.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		request.getSession().setAttribute("username", name);
		map.put("name", name);
		map.put("password", password);
		return "welcome";

	}
}