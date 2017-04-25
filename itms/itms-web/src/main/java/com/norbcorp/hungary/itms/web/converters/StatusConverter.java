package com.norbcorp.hungary.itms.web.converters;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.StatusDTO;
import com.norbcorp.hungary.itms.model.dto.TypeDTO;
import com.norbcorp.hungary.itms.service.DefaultStatusService;

@Named
@ApplicationScoped
public class StatusConverter implements Converter{

	@Inject
	private DefaultStatusService defaultStatusService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null || value.isEmpty())
			return null;
		try{
			return defaultStatusService.findStatusById(Integer.valueOf(value).intValue());
		}catch(Exception e){
			throw new ConverterException(new FacesMessage("Not valid id:"+value),e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value==null)
			return null;
		if(value instanceof StatusDTO){
			return String.valueOf(((StatusDTO) value).getId());
		}
		return null;
	}

}
