package colarinhobranco.controller;


public class ApplicationControllerSemAcesso extends ApplicationController {
		
	@Override	
	public String execute() {
		return "/pages/semAcesso";
	}

	
}
