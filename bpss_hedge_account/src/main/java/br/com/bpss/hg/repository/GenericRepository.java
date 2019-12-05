package br.com.bpss.hg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bpss.hg.domain.GenericDomain;
import br.com.bpss.hg.domain.Tta150Parametro;

@Repository
public class GenericRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Object> getParametrosView() {

		Query query = entityManager.createNativeQuery("select * from TTA150_J_PARAMETRO t");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Tta150Parametro> getParametros() {

		return entityManager.createNamedQuery("Tta150Parametro.findAll",Tta150Parametro.class).getResultList();
	}

	@Transactional
	public void salvar(GenericDomain genericDomain) {
		entityManager.persist(genericDomain);
	}

}