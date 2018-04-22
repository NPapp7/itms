package com.norbcorp.hungary.persistence.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.norbcorp.hungary.itms.model.dto.GroupDTO;
import com.norbcorp.hungary.itms.model.dto.UserDTO;
import com.norbcorp.hungary.persistence.entities.ItmsGroup;
import com.norbcorp.hungary.persistence.entities.ItmsUser;

@Stateless
public class GroupDAO implements Serializable{

	@PersistenceContext(name = "ITMS-PERSISTENCE")
	private EntityManager em;
	
	/**
	 * Get all groups containing name and description attributes.
	 * 
	 * @return list of groups
	 */
	public List<GroupDTO> getAllGroups(){
		Query query = em.createNamedQuery("ItmsGroup.findAll");
		List<GroupDTO> groups=new LinkedList<GroupDTO>();
		for(ItmsGroup itmsGroup : (List<ItmsGroup>)query.getResultList()){
			groups.add(new GroupDTO(itmsGroup.getName(),itmsGroup.getDescription()));
		}
		return groups;
	}
	
	/**
	 * Get all groups containing name and description attributes.
	 * Those users which are members of these groups are also loaded.
	 * 
	 * @return list of groups
	 */
	public List<GroupDTO> getAllGroupsWithUsers(){
		Query query = em.createNamedQuery("ItmsGroup.findAll");
		List<GroupDTO> groups=new LinkedList<GroupDTO>();
		for(ItmsGroup itmsGroup : (List<ItmsGroup>)query.getResultList()){
			GroupDTO groupDTO= new GroupDTO(itmsGroup.getName(),itmsGroup.getDescription());
			List<UserDTO> userDTOs = new LinkedList<UserDTO>();
			for(ItmsUser itmsUser : (List<ItmsUser>)query.getResultList()){
				UserDTO userDTO = new UserDTO(itmsUser.getName(),itmsUser.getRegisteredDate(),itmsUser.getRole(),itmsUser.getStatus());
				userDTOs.add(userDTO);
			}
			groupDTO.setUsers(userDTOs);
		}
		return groups;
	}
	
	public void add(GroupDTO groupDTO){
		ItmsGroup itmsGroup = new ItmsGroup();
		itmsGroup.setName(groupDTO.getName());
		itmsGroup.setDescription(groupDTO.getDescription());
	}
}
