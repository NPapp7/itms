package com.norbcorp.hungary.persistence.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.norbcorp.hungary.itms.model.dto.ProjectDTO;
import com.norbcorp.hungary.persistence.entities.ItmsProject;

@Stateless
public class ProjectDAO implements Serializable{

	@PersistenceContext(name = "ITMS-PERSISTENCE")
	private EntityManager em;
	
	public List<ProjectDTO> findAll(){
		Query query = em.createNamedQuery("ItmsProject.findAll");
		List<ProjectDTO> projectList=new LinkedList<ProjectDTO>();
		for(ItmsProject itmsProject : (List<ItmsProject>)query.getResultList()){
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setId(itmsProject.getId());
			projectDTO.setName(itmsProject.getName());
			projectDTO.setDescription(itmsProject.getDescription());
			
			projectList.add(projectDTO);
		}
		return projectList;
	}
	
	public ProjectDTO findById(Integer id){
		ItmsProject itmsProject = em.find(ItmsProject.class, id);
		ProjectDTO projectDTO =new ProjectDTO();
		projectDTO.setId(itmsProject.getId());
		projectDTO.setName(itmsProject.getName());
		projectDTO.setDescription(itmsProject.getDescription());
		
		return projectDTO;
	}
	
	public void addProject(ProjectDTO projectDTO){
		ItmsProject itmsProject = new ItmsProject();
		itmsProject.setId(projectDTO.getId());
		itmsProject.setName(projectDTO.getName());
		itmsProject.setDescription(projectDTO.getDescription());
		
		em.persist(itmsProject);
	}
	
	public void updateProject(ProjectDTO projectDTO){
		ItmsProject itmsProject = em.find(ItmsProject.class, projectDTO.getId());
		itmsProject.setName(projectDTO.getName());
		itmsProject.setDescription(projectDTO.getDescription());
	}
	
	public void deleteProjectById(Integer id){
		ItmsProject itmsProject = em.find(ItmsProject.class, id);
		em.remove(itmsProject);
	}
}
