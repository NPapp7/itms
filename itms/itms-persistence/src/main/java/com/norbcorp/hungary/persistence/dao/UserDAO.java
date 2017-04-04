package com.norbcorp.hungary.persistence.dao;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.norbcorp.hungary.itms.model.dto.UserDTO;
import com.norbcorp.hungary.persistence.entities.ItmsUser;

@Stateless
public class UserDAO {
	
	@PersistenceContext(name = "STOCKS")
	private EntityManager em;
	
	public UserDTO getUserById(Integer id){
		ItmsUser iu = em.find(ItmsUser.class, id);
		if(iu==null){
			return null;
		}
		UserDTO userDTO=new UserDTO();
		userDTO.setName(iu.getName());
		userDTO.setPassword(iu.getPassword());
		userDTO.setRegisteredDate(iu.getRegisteredDate());
		userDTO.setUserId(iu.getId());
		return userDTO;
	}
	
	public UserDTO getUserByUserName(String userName){
		Query query = em.createNamedQuery("ItmsUser.findUserByName");
		query.setParameter("name", userName);
		ItmsUser itmsUser = (ItmsUser)query.getSingleResult();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(itmsUser.getName());
		userDTO.setPassword(itmsUser.getPassword());
		userDTO.setRegisteredDate(itmsUser.getRegisteredDate());
		userDTO.setUserId(itmsUser.getId());
		return userDTO;
	}
	
	public List<UserDTO> getUsers(){
		Query query = em.createNamedQuery("ItmsUser.findAll");
		List<UserDTO> users=new LinkedList<UserDTO>();
		for(ItmsUser itmsUser : (List<ItmsUser>)query.getResultList()){
			UserDTO userDTO=new UserDTO();
			userDTO.setName(itmsUser.getName());
			users.add(userDTO);
		}
		return users;
	}
}
