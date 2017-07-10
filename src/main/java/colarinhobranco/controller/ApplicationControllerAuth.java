package colarinhobranco.controller;

import javax.servlet.http.HttpSession;

import colarinhobranco.services.ApplicationServiceUsuario;

public class ApplicationControllerAuth extends ApplicationController {
		
	private ApplicationServiceUsuario service = new ApplicationServiceUsuario();
	
	@Override
	public String execute() {
		
		String email = this.request.getParameter("email");
		String senha = this.request.getParameter("senha");
		
		boolean existe = this.service.auth(email, senha);
		
		if (existe) {
			HttpSession session = this.request.getSession();
			session.setAttribute("login", email);
			
			return "/pages/news/list";
			
		} else {
			return "/pages/login";
		}
	}	
}
