package colarinhobranco.controller;

import javax.servlet.http.HttpSession;

public class ApplicationControllerLogout extends ApplicationController {
		
	@Override
	public String execute() {	
		HttpSession session = this.request.getSession();
		session.invalidate();
		return "/pages/login";
	}	
}
