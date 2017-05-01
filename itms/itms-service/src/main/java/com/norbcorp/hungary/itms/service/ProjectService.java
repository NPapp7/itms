package com.norbcorp.hungary.itms.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.norbcorp.hungary.itms.model.dto.ProjectDTO;
import com.norbcorp.hungary.persistence.dao.ProjectDAO;

@Stateless
public class ProjectService implements Serializable{

	@Inject
	private ProjectDAO projectDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<ProjectDTO> getAllProjects(){
		return projectDAO.findAll();
	}
	
	public ProjectDTO findProjectById(Integer id){
		return projectDAO.findById(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteProjectById(Integer id){
		projectDAO.deleteProjectById(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addProject(ProjectDTO projectDTO){
		projectDAO.addProject(projectDTO);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void updateProject(ProjectDTO projectDTO){
		projectDAO.updateProject(projectDTO);
	}
}
