package colarinhobranco.controller;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;



public class ApplicationControllerNewsList extends ApplicationController {
		
	@Override
	public String execute() {
		NewsDao newsDao = new NewsDaoImpl();
		
		this.request.setAttribute("news", newsDao.findAll());
		
		return "/pages/news/list";
	}	
}
