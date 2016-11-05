package net.tecgurus.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.QueryParameter;
import net.tecgurus.persistence.dao.ClienteDAO;

/**
 * Session Bean implementation class ClienteDAOBean
 */
@Stateless
public class ClienteDAOBean extends GenericDAOBean<Cliente> implements ClienteDAO {

	@Override
	public List<Cliente> findByName(String name){
		try{
			List<Cliente> list = super.findWithNamedQuery("Cliente.findByName", QueryParameter.with("nomCte", name).parameters());
			return list;
		}catch(Exception e){
			return null;
		}
	}
	
}
