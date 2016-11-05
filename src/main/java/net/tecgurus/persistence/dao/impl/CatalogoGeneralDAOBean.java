package net.tecgurus.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.dao.CatalogoGeneralDAO;

/**
 * Session Bean implementation class CatalogoGeneralDAOBean
 */
@Stateless
public class CatalogoGeneralDAOBean implements CatalogoGeneralDAO {

	/*
	 * Injected value
	 */
	@PersistenceContext
	EntityManager em;

	@Override
	public List<CatalogoGeneral> findAll() {
		try {
			String sql = "From CatalogoGeneral";
			TypedQuery<CatalogoGeneral> tquery = em.createQuery(sql, CatalogoGeneral.class);
			List<CatalogoGeneral> listAll = tquery.getResultList();
			return listAll;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CatalogoGeneral> findAllNamed() {
		try {
			TypedQuery<CatalogoGeneral> tquery = em.createNamedQuery("CatalogoGeneral.findAllActive",
					CatalogoGeneral.class);
			List<CatalogoGeneral> listAll = tquery.getResultList();
			return listAll;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CatalogoGeneral> findAllByStatus(int status) {
		try {
			TypedQuery<CatalogoGeneral> tquery = em.createNamedQuery("CatalogoGeneral.findAllByState",
					CatalogoGeneral.class);
			tquery.setParameter("idEstCat", status);
			List<CatalogoGeneral> listAll = tquery.getResultList();
			return listAll;
		} catch (Exception e) {
			return null;
		}
	}
	

	@Override
	public List<CatalogoGeneral> findNative() {
		try {
			Query query = em.createNativeQuery("CatalogoGeneral.nativeSelect", CatalogoGeneral.class);
			List<CatalogoGeneral> list = query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

}
