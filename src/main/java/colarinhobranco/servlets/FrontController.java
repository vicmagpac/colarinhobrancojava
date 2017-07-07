package colarinhobranco.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import colarinhobranco.controller.ApplicationController;

@MultipartConfig
public class FrontController extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ApplicationController applicationControllerClass = null;
			
			String applicationController = request.getParameter("ApplicationController");
			
			if (applicationController == null || applicationController == "") {
				applicationController = "NewsList";
			}
			
			HttpSession session = request.getSession();
			
			request.setAttribute("login", session.getAttribute("login"));
			
			applicationControllerClass = (ApplicationController)Class.forName("colarinhobranco.controller.ApplicationController"+applicationController).newInstance();
			applicationControllerClass.init(this.getServletContext(), request, response);
			String file = applicationControllerClass.execute();
			this.forward(file, request, response);
		
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    public void forward(String target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        target = String.format("/%s.jsp", target);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
	
}