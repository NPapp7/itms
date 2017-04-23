package com.norbcorp.hungary.itms.web.converters;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.TypeDTO;
import com.norbcorp.hungary.itms.service.DefaultTypeService;

@Named
@RequestScoped
public class TypeConverter implements Converter{

	private static Logger logger = Logger.getLogger(TypeConverter.class.getName());
	
	@Inject
	private DefaultTypeService defaultTypeService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException{
		if(value==null || value.isEmpty()){
			return null;
		}
		
		try{
			return defaultTypeService.getTypeById(Integer.valueOf(value).intValue());
		} catch(NumberFormatException nfe){
			throw new ConverterException(new FacesMessage("Not valid id: "+value), nfe);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return "";
		}
		
		if(value instanceof TypeDTO){
			return String.valueOf(((TypeDTO) value).getId());
		}
		return null;
	}

}
