package com.norbcorp.hungary.persistence.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.norbcorp.hungary.itms.model.dto.TypeDTO;
import com.norbcorp.hungary.persistence.entities.ItmsType;

@Stateless
public class TypeDAO implements Serializable{

	@PersistenceContext(name = "ITMS-PERSISTENCE")
	private EntityManager em;
	
	public List<TypeDTO> getAllType(){
		Query query=em.createNamedQuery("ItmsType.findAll");
		List<TypeDTO> types=new LinkedList<TypeDTO>();
		for(ItmsType type : (List<ItmsType>)query.getResultList()){
			TypeDTO typeDTO = new TypeDTO();
			typeDTO.setId(type.getId());
			typeDTO.setName(type.getName());
			types.add(typeDTO);
		}
		return types;
	}
	
	public void addNewType(TypeDTO typeDTO){
		ItmsType itmsType=new ItmsType();
		itmsType.setId(typeDTO.getId());
		itmsType.setName(typeDTO.getName());
		em.persist(itmsType);
	}
	
	public void deleteType(TypeDTO typeDTO){
		ItmsType itmsType = em.find(ItmsType.class, typeDTO.getId());
		em.remove(itmsType);
	}
	
	public void deleteById(Integer id){
		ItmsType itmsType = em.find(ItmsType.class, id);
		em.remove(itmsType);
	}
	
	public void addNewType(String name){
		ItmsType itmsType = new ItmsType();
		itmsType.setName(name);
		em.persist(itmsType);
	}
	
	public void modify(TypeDTO typeDTO){
		ItmsType itmsType = em.find(ItmsType.class, typeDTO.getId());
		itmsType.setName(typeDTO.getName());
	}
	
	public TypeDTO getTypeByName(String name){
		Query query = em.createNamedQuery("ItmsType.findTypeByName");
		query.setParameter("name", name);
		TypeDTO typeDTO = new TypeDTO();
		typeDTO.setId(((TypeDTO)query.getSingleResult()).getId());
		typeDTO.setName(((TypeDTO)query.getSingleResult()).getName());
		return typeDTO;
	}
	
	public TypeDTO getTypeById(Integer id){
		ItmsType itmsType = em.find(ItmsType.class, id);
		TypeDTO typeDTO = new TypeDTO();
		typeDTO.setId(itmsType.getId());
		typeDTO.setName(itmsType.getName());
		return typeDTO;
	}
	
}
