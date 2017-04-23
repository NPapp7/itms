package com.norbcorp.hungary.itms.web.converters;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.ProjectDTO;
import com.norbcorp.hungary.itms.service.ProjectService;

@Named
@RequestScoped
public class ProjectConverter implements Converter{

	@Inject
	private ProjectService projectService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null || value.isEmpty())
			return null;
		try{
			return projectService.findProjectById(Integer.valueOf(value).intValue());
		}catch(Exception e){
			throw new ConverterException(new FacesMessage("Not valid id:"+value),e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null)
			return null;
		if(value instanceof ProjectDTO) {
			ProjectDTO projectDTO = (ProjectDTO)value;
			return ((ProjectDTO) value).getId()+"";
		}
		return null;
	}

}
