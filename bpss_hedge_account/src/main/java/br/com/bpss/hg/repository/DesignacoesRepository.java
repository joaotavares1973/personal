package br.com.bpss.hg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bpss.hg.domain.GenericDomain;
import br.com.bpss.hg.domain.ListaDesignacoesView;
import br.com.bpss.hg.domain.Tth001JOperNaoDesignadasF;
import br.com.bpss.hg.domain.Tth001JOperNaoDesignadasH;
import br.com.bpss.hg.dto.FiltrosDTO;
import br.com.bpss.hg.service.GenericService;

@Repository
public class DesignacoesRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private GenericService genericService;

	@SuppressWarnings("unchecked")
	public List<ListaDesignacoesView> listarDesignacoes(FiltrosDTO filtrosDTO) {

		Query query = null;
		StringBuffer condicao = new StringBuffer();
		boolean temCondicao = false;
				
		if(filtrosDTO == null) {
			query = entityManager.createQuery("select t from ListaDesignacoesView t", ListaDesignacoesView.class);
		} else {
			
			condicao.append("select t from ListaDesignacoesView t ");
			
			if(filtrosDTO.getAnoSafra() != null) {
				condicao.append("where t.anoSafra = :anoSafra ");
			}
			if(filtrosDTO.getDtNegociacaoIni() != null && !filtrosDTO.getDtNegociacaoIni().isEmpty()) {
				condicao.append("and t.dtAlocacao BETWEEN :dtNegociacaoIni AND :dtNegociacaoFim ");
			}
			
			query = entityManager.createQuery(condicao.toString(), ListaDesignacoesView.class);
			
			if(filtrosDTO.getAnoSafra() != null) {
				query.setParameter("anoSafra", filtrosDTO.getAnoSafra());
			}
			if(filtrosDTO.getDtNegociacaoIni() != null  && !filtrosDTO.getDtNegociacaoIni().isEmpty()) {
				query.setParameter("dtNegociacaoIni", filtrosDTO.getDtNegociacaoIni());
				query.setParameter("dtNegociacaoFim", filtrosDTO.getDtNegociacaoFim());
			}
			
		}

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tth001JOperNaoDesignadasH> operacoesNaoDesignadasHedge(FiltrosDTO filtrosDTO) {

		Query query = null;
		StringBuffer condicao = new StringBuffer();
				
		if(filtrosDTO == null) {
			query = entityManager.createQuery("select t from Tth001JOperNaoDesignadasH t", Tth001JOperNaoDesignadasH.class);
		} else {
			
			
		}

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tth001JOperNaoDesignadasF> operacoesNaoDesignadasFinanc(FiltrosDTO filtrosDTO) {

		Query query = null;
		StringBuffer condicao = new StringBuffer();
				
		if(filtrosDTO == null) {
			query = entityManager.createQuery("select t from Tth001JOperNaoDesignadasF t", Tth001JOperNaoDesignadasF.class);
		} else {
			
			
		}

		return query.getResultList();
	}	

	@Transactional
	public void salvar(GenericDomain genericDomain) {
		entityManager.persist(genericDomain);
	}

}