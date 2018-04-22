package com.norbcorp.hungary.itms.web.errorhandling;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class ErrorHandler {

	private static Logger logger = Logger.getLogger(ErrorHandler.class.getName());
	
	public String getStatusCode() {
		String val = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("javax.servlet.error.status_code"));
		return val != null ? val : "";
	}

	public String getMessage() {
		String val = null; 
		try{
		val = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("javax.servlet.error.message");
		}catch(Exception e){
			logger.warning("ERROR: "+e.getMessage());
		}
		return val != null ? val : "";
	}

	public String getExceptionType() {
		String val=null;
		try{
			val = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception_type").toString();
		}catch(Exception e){
			logger.warning("ERROR: "+e.getMessage());
		}
		return val != null ? val : "";
	}

	public String getException() {
		String val=null;
		try{
			val = (String) ((Exception) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("javax.servlet.error.exception")).toString();
		}catch(Exception e){
			logger.warning(e.getMessage());
			val=null;
		}
		return val != null ? val : "";
	}

	public String getRequestURI() {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("javax.servlet.error.request_uri");
	}

	public String getServletName() {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("javax.servlet.error.servlet_name");
	}

}
