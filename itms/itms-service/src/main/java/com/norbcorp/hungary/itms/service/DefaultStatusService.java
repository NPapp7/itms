package com.norbcorp.hungary.itms.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.norbcorp.hungary.itms.model.dto.StatusDTO;
import com.norbcorp.hungary.persistence.dao.StatusDAO;

@Stateless
public class DefaultStatusService {

	@Inject
	private StatusDAO statusDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<StatusDTO> getAllStatuses(){
		return statusDAO.getAllStatus();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addStatus(StatusDTO statusDTO){
		statusDAO.addStatus(statusDTO);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteStatusById(Integer id){
		statusDAO.deleteStatusById(id);
	}
}
