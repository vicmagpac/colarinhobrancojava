package colarinhobranco.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ApplicationController {	
	protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public void init(ServletContext context, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.context = context;
    	this.request = servletRequest;
        this.response = servletResponse;
    }
    
	public abstract String execute();

}