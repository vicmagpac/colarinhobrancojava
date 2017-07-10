package colarinhobranco.services; 

import colarinhobranco.daoimpl.NewsDaoImpl;
import colarinhobranco.model.News;

public class ApplicationServiceNews {
	
	private NewsDaoImpl newsDao = new NewsDaoImpl();

	public News save(News news) {
		return newsDao.save(news);
	}

}
