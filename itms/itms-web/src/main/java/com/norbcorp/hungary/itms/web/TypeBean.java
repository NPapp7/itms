package com.norbcorp.hungary.itms.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.TypeDTO;
import com.norbcorp.hungary.itms.service.DefaultTypeService;

@Named
@ViewScoped
public class TypeBean implements Serializable{

	@Inject
	private DefaultTypeService defaultTypeService;
	
	private List<TypeDTO> types;
	
	private String name;

	public List<TypeDTO> getTypes() {
		this.types = defaultTypeService.getAllType();
		return types;
	}

	public void setTypes(List<TypeDTO> types) {
		this.types = types;
	}
	
	public void addType(){
		defaultTypeService.addType(name);
	}
	
	public void deleteById(Integer id){
		defaultTypeService.deleteById(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
