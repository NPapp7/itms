package com.norbcorp.hungary.itms.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.norbcorp.hungary.itms.model.dto.TypeDTO;
import com.norbcorp.hungary.persistence.dao.TypeDAO;

@Stateless
public class DefaultTypeService {

	@Inject
	private TypeDAO typeDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<TypeDTO> getAllType(){
		return typeDAO.getAllType();
	}
	
	public TypeDTO getTypeById(Integer id){
		return typeDAO.getTypeById(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addType(TypeDTO typeDTO){
		typeDAO.addNewType(typeDTO);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addType(String name){
		typeDAO.addNewType(name);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteById(Integer id){
		typeDAO.deleteById(id);
	}
}
