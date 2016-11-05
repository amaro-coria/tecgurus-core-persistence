package net.tecgurus.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.entities.CatalogoGeneral;

@Local
public interface CatalogoGeneralDAO {

	List<CatalogoGeneral> findAll();

	List<CatalogoGeneral> findNative();

	List<CatalogoGeneral> findAllByStatus(int status);

	List<CatalogoGeneral> findAllNamed();

}
