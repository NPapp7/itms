package com.norbcorp.hungary.persistence.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.norbcorp.hungary.itms.model.dto.StatusDTO;
import com.norbcorp.hungary.persistence.entities.ItmsStatus;

@Stateless
public class StatusDAO implements Serializable{
	@PersistenceContext(name = "ITMS-PERSISTENCE")
	private EntityManager em;
	
	public List<StatusDTO> getAllStatus(){
		Query query = em.createNamedQuery("ItmsStatus.findAll");
		List<StatusDTO> statuses=new LinkedList<StatusDTO>();
		for(ItmsStatus itmsStatus : (List<ItmsStatus>)query.getResultList()){
			StatusDTO statusDTO=new StatusDTO();
			statusDTO.setId(itmsStatus.getId());
			statusDTO.setName(itmsStatus.getName());
			statusDTO.setDescription(itmsStatus.getDescription());
			statuses.add(statusDTO);
		}
		return statuses;
	}
	
	public void addStatus(StatusDTO statusDTO){
		ItmsStatus itmsStatus=new ItmsStatus();
		itmsStatus.setName(statusDTO.getName());
		itmsStatus.setId(statusDTO.getId());
		itmsStatus.setDescription(statusDTO.getDescription());
		em.persist(itmsStatus);
	}
	
	public void modify(StatusDTO statusDTO){
		ItmsStatus itmsStatus=em.find(ItmsStatus.class, statusDTO.getId());
		itmsStatus.setName(statusDTO.getName());
		itmsStatus.setId(statusDTO.getId());
		itmsStatus.setDescription(statusDTO.getDescription());
	}
	
	public void removeStatus(StatusDTO statusDTO){
		ItmsStatus itmsStatus=em.find(ItmsStatus.class, statusDTO.getId());
		em.remove(itmsStatus);
	}
	
	public void deleteStatusById(Integer id){
		ItmsStatus itmsStatus = em.find(ItmsStatus.class, id);
		em.remove(itmsStatus);
	}
}
