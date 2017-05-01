package com.norbcorp.hungary.persistence.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.norbcorp.hungary.itms.model.dto.IssueDTO;
import com.norbcorp.hungary.itms.model.dto.TypeDTO;
import com.norbcorp.hungary.persistence.entities.ItmsIssue;
import com.norbcorp.hungary.persistence.entities.ItmsProject;
import com.norbcorp.hungary.persistence.entities.ItmsStatus;
import com.norbcorp.hungary.persistence.entities.ItmsType;

@Stateless
public class IssueDAO implements Serializable{
	
	private static Logger logger = Logger.getLogger(IssueDAO.class.getName());
	
	@PersistenceContext(name = "ITMS-PERSISTENCE")
	private EntityManager em;
	
	@Inject
	private TypeDAO typeDAO;
	
	@Inject
	private StatusDAO statusDAO;
	
	public IssueDTO getIssueById(Integer id){
		ItmsIssue issueEntity = (ItmsIssue) em.find(ItmsIssue.class, id);
		IssueDTO issueDTO = new IssueDTO();
		issueDTO.setId(issueEntity.getId());
		issueDTO.setCreatedDate(issueEntity.getCreatedDate());
		issueDTO.setEstimatedTime(issueEntity.getEstimatedTime());
		issueDTO.setLastModifiedDate(issueEntity.getLastModifiedDate());
		issueDTO.setRemainingDate(issueEntity.getRemainingTime());
		issueDTO.setTitle(issueEntity.getTitle());
		issueDTO.setWorkTime(issueEntity.getWorkTime());
		issueDTO.setDescription(issueEntity.getDescription());
		return issueDTO;
	}
	
	public IssueDTO getIssueByTitle(String name){
		try{
			Query query = em.createNamedQuery("ItmsIssue.findByName");
			query.setParameter("name", name);
			ItmsIssue itmsIssue = (ItmsIssue)query.getSingleResult();
			IssueDTO issueDTO = new IssueDTO();
			issueDTO.setId(itmsIssue.getId());
			issueDTO.setCreatedDate(itmsIssue.getCreatedDate());
			issueDTO.setEstimatedTime(itmsIssue.getEstimatedTime());
			issueDTO.setLastModifiedDate(itmsIssue.getLastModifiedDate());
			issueDTO.setRemainingDate(itmsIssue.getRemainingTime());
			issueDTO.setTitle(itmsIssue.getTitle());
			issueDTO.setWorkTime(itmsIssue.getWorkTime());
			
			return issueDTO;
		}catch(NoResultException|NonUniqueResultException nre){
			return null;
		}
	}
	
	public List<IssueDTO> getIssues(){
		List<IssueDTO> issueList = new ArrayList<>();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ItmsIssue> cq = cb.createQuery(ItmsIssue.class);
		Root<ItmsIssue> rootEntry = cq.from(ItmsIssue.class);
		CriteriaQuery<ItmsIssue> all = cq.select(rootEntry);
		TypedQuery<ItmsIssue> allQuery = em.createQuery(all);
		allQuery.getResultList().forEach(issue -> {

			IssueDTO dto = new IssueDTO();
			dto.setCreatedDate(issue.getCreatedDate());
			dto.setDescription(issue.getDescription());
			dto.setEstimatedTime(issue.getEstimatedTime());
			dto.setId(issue.getId());
			dto.setLastModifiedDate(issue.getLastModifiedDate());
			dto.setRemainingDate(issue.getRemainingTime());
			dto.setTitle(issue.getTitle());
			dto.setWorkTime(issue.getWorkTime());
			dto.setTypeDTO(typeDAO.getTypeById(issue.getItmsType().getId()));
			dto.setStatusDTO(statusDAO.findStatusById(issue.getItmsStatus().getId()));
			issueList.add(dto);
			
		});
		return issueList;
	}
	
	public void add(IssueDTO issueDTO){
		ItmsIssue itmsIssue=new ItmsIssue();
		itmsIssue.setTitle(issueDTO.getTitle());
		itmsIssue.setDescription(issueDTO.getDescription());
		itmsIssue.setEstimatedTime(issueDTO.getEstimatedTime());
		itmsIssue.setWorkTime(issueDTO.getWorkTime());
		itmsIssue.setRemainingTime(issueDTO.getRemainingDate());
		itmsIssue.setLastModifiedDate(issueDTO.getLastModifiedDate());
		
		ItmsType itmsType = em.find(ItmsType.class, issueDTO.getTypeDTO().getId());
		logger.info("Type id:"+itmsType.getId());
	/*	itmsType.setId(issueDTO.getTypeDTO().getId());
		itmsType.setName(issueDTO.getTypeDTO().getName());*/
		itmsIssue.setItmsType(itmsType);
		
		ItmsStatus itmsStatus = em.find(ItmsStatus.class, issueDTO.getStatusDTO().getId());
		logger.info("Status id:"+itmsStatus.getId());
	/*	itmsStatus.setId(issueDTO.getStatusDTO().getId());
		itmsStatus.setName(issueDTO.getStatusDTO().getName());
		itmsStatus.setDescription(issueDTO.getStatusDTO().getDescription());*/
		itmsIssue.setItmsStatus(itmsStatus);
		
		ItmsProject itmsProject = em.find(ItmsProject.class, issueDTO.getProjectDTO().getId());
		logger.info("Project id:"+itmsProject.getId());
	/*	itmsProject.setId(issueDTO.getProjectDTO().getId());
		itmsProject.setName(issueDTO.getProjectDTO().getName());
		itmsProject.setDescription(issueDTO.getProjectDTO().getDescription());*/
		
		itmsIssue.setItmsProject(itmsProject);
		
		em.persist(itmsIssue);
		em.flush();
	}

}
