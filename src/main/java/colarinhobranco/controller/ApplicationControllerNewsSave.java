package colarinhobranco.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import colarinhobranco.model.News;
import colarinhobranco.services.ApplicationServiceNews;


public class ApplicationControllerNewsSave extends ApplicationController {
	
	private SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	private String imagesFolder; 
	
	private ApplicationServiceNews service = new ApplicationServiceNews();
	
	
	@Override
	public String execute() {
		try {

			this.request.setCharacterEncoding("UTF-8");
			
			String title = this.request.getParameter("title");
			String headlineContent = this.request.getParameter("headline-content");
			String content = this.request.getParameter("content");
			Part headlineImage = this.request.getPart("headline-image");
			
			Date date = null;
			
			try {
				date = dateParser.parse(this.request.getParameter("date"));
			} catch (ParseException pe) {
				this.response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);			
			}
			
			News news = new News(title, date, headlineContent, headlineImage.getSubmittedFileName(), content);
			
			if (this.service.save(news) != null) {
				//saveHeadlineImage(headlineImage, news.getId());
			}
			
			this.request.setAttribute("news", news);
			
			return "/pages/news/show";

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	private Boolean saveHeadlineImage(Part filePart, Integer newsId) throws IOException {
		
		InputStream is = null;
		OutputStream os = null;
		String fileName = null;
		
		try {
			File imageFolder = new File(imagesFolder, String.valueOf(newsId));
			imageFolder.mkdir();
			fileName = filePart.getSubmittedFileName();
			is = filePart.getInputStream();
			os = new FileOutputStream(new File(imageFolder, fileName));
 
			Integer read = 0;
			final byte[] bytes = new byte[1024];
			
			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}			
			
			return Boolean.TRUE;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return Boolean.FALSE;
		} finally {
			
			if (os != null) {
				os.close();
			}
			
			if (is != null) {
				is.close();
			} 
			
		}
		
	}
	
	public void setImagesFolder(String imagesFolder) { this.imagesFolder = imagesFolder; }

	
}
