package colarinhobranco.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.mapping.List;

import colarinhobranco.daoimpl.UsuarioDao;
import colarinhobranco.model.Usuario;

public class ApplicationControllerAuth extends ApplicationController {
		
	private UsuarioDao usuarioDao = new UsuarioDao();
	
	@Override
	public String execute() {
		
		String email = this.request.getParameter("email");
		String senha = this.request.getParameter("senha");
		
		Boolean existe = this.usuarioDao.auth(email, senha);
		
		System.out.println("Existe: " + existe);
		
		if (existe) {
			HttpSession session = this.request.getSession();
			session.setAttribute("login", email);
			
			return "/pages/news/list";
			
		} else {
			return "/pages/login";
		}
	}	
}
