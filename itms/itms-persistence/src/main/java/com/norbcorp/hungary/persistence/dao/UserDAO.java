package com.norbcorp.hungary.persistence.dao;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.norbcorp.hungary.itms.model.dto.UserDTO;
import com.norbcorp.hungary.persistence.entities.ItmsUser;

@Stateless
public class UserDAO {
	
	@PersistenceContext(name = "ITMS-PERSISTENCE")
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
		userDTO.setRole(iu.getRole());
		userDTO.setStatus(iu.getStatus());
		return userDTO;
	}
	
	public UserDTO getUserByUserName(String userName){
		try{
		Query query = em.createNamedQuery("ItmsUser.findUserByName");
		query.setParameter("name", userName);
		ItmsUser itmsUser = (ItmsUser)query.getSingleResult();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(itmsUser.getName());
		userDTO.setPassword(itmsUser.getPassword());
		userDTO.setRegisteredDate(itmsUser.getRegisteredDate());
		userDTO.setUserId(itmsUser.getId());
		userDTO.setRole(itmsUser.getRole());
		userDTO.setStatus(itmsUser.getStatus());
		return userDTO;
		}catch(NoResultException nre){return null;}
	}
	
	public List<UserDTO> getUsers(){
		Query query = em.createNamedQuery("ItmsUser.findAll");
		List<UserDTO> users=new LinkedList<UserDTO>();
		for(ItmsUser itmsUser : (List<ItmsUser>)query.getResultList()){
			UserDTO userDTO=new UserDTO();
			userDTO.setName(itmsUser.getName());
			userDTO.setPassword(itmsUser.getPassword());
			userDTO.setRole(itmsUser.getRole());
			userDTO.setStatus(itmsUser.getStatus());
			userDTO.setUserId(itmsUser.getId());
			userDTO.setRegisteredDate(itmsUser.getRegisteredDate());
			users.add(userDTO);
		}
		return users;
	}
	
	public Boolean updateUser(UserDTO user){
		try{
			Query query = em.createNamedQuery("ItmsUser.findUserById");
			ItmsUser iu = (ItmsUser)query.getSingleResult();
			iu.setName(user.getName());
			iu.setPassword(user.getPassword());
			iu.setRegisteredDate(user.getRegisteredDate());
			iu.setRole(user.getRole());
			iu.setStatus(user.getStatus());
		}catch(NoResultException nre){
			return false;
		}
		return true;
	}
	
	public void deleteUser(Integer id){
		ItmsUser iu = em.find(ItmsUser.class, id);
		em.remove(iu);
	}
	
	public void addUser(UserDTO user){
		
	}
}
