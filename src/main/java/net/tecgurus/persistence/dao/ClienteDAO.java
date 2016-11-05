package net.tecgurus.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.entities.Cliente;

@Local
public interface ClienteDAO extends GenericDAO<Cliente> {

	List<Cliente> findByName(String name);

}
