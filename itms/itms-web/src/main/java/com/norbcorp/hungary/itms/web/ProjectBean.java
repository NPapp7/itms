package com.norbcorp.hungary.itms.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.ProjectDTO;
import com.norbcorp.hungary.itms.service.ProjectService;

@Named("projectBean")
@ViewScoped
public class ProjectBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjectService projectService;
	
	private List<ProjectDTO> projects;
	
	private ProjectDTO projectDTO;

	public List<ProjectDTO> getProjects() {
		this.projects=projectService.getAllProjects();
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}
	
	public void addProject(){
		projectService.addProject(projectDTO);
	}
	
	public void deleteProject(){
		
	}
}
