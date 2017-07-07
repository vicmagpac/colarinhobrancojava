package colarinhobranco.controller;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;


public class ApplicationControllerNewsShow extends ApplicationController {
	
	private NewsDao newsDao = new NewsDaoImpl();
	
	@Override
	public String execute() {
		Integer newsId = new Integer(this.request.getParameter("newsId"));
		
		this.request.setAttribute("news", newsDao.get(newsId));
		
		return "/pages/news/show";
	
	}

	
}
