package com.norbcorp.hungary.itms.web.converters;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.ProjectDTO;
import com.norbcorp.hungary.itms.model.dto.StatusDTO;
import com.norbcorp.hungary.itms.service.ProjectService;

@Named
@ApplicationScoped
public class ProjectConverter implements Converter{

	private static Logger logger = Logger.getLogger(ProjectConverter.class.getName());
	
	@Inject
	private ProjectService projectService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.info(value);
		if(value==null || value.isEmpty())
			return null;
		try{
					ProjectDTO projectDTO = projectService.findProjectById(Integer.valueOf(value).intValue());
					logger.info(projectDTO.getId()+"");
					return projectDTO;
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
			return String.valueOf(projectDTO.getId());
		}
		return null;
	}

}
