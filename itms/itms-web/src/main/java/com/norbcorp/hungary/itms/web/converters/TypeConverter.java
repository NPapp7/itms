package com.norbcorp.hungary.itms.web.converters;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.TypeDTO;

@Named
@RequestScoped
public class TypeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value!=null && value.equals("")){
			TypeDTO typeDTO = new TypeDTO();
			typeDTO.setName(value);
			return typeDTO;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof TypeDTO){
			TypeDTO typeDTO=(TypeDTO)value;
			if(typeDTO.getName()!=null && !typeDTO.getName().equals("")) {
				return typeDTO.getName();
			}
		}
		return null;
	}

}
