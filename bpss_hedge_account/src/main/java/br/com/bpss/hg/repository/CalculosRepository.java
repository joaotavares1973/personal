package br.com.bpss.hg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bpss.hg.domain.GenericDomain;
import br.com.bpss.hg.service.GenericService;

@Repository
public class CalculosRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private GenericService genericService;

	@SuppressWarnings("unchecked")
	public List<Object> listarCalculos() {

		Query query = entityManager.createNativeQuery("select t.CD_CALCULO, t.MES_ANO, t.DS_TIPO_INSTRUMENTO, "
				+ "t.VL_AJUSTE from TTH004_J_LISTA_CALCULOS t");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public String processarCalculo() {

		try {
			StoredProcedureQuery call = entityManager.createStoredProcedureQuery("TTH002_CALCULO_VARIACAO")
					.registerStoredProcedureParameter("STATUS", Character.class, ParameterMode.OUT);

			call.execute();

			return "0;Processamento Efetuado com Sucesso";
		} catch (Exception e) {
			return "9;Erro no Processamento : " + e.getMessage();
		}

	}

	@SuppressWarnings("unchecked")
	public String processarPeriodoContabil() {

		StoredProcedureQuery call = entityManager.createStoredProcedureQuery("TTH003_FECHAMENTO_CONTABIL")
				.registerStoredProcedureParameter("STATUS", String.class, ParameterMode.OUT);

		try {
			String status = (String) call.getOutputParameterValue("STATUS");
			call.execute();

			return "0;"+status;
		} catch (Exception e) {
			return "9;Erro no Processamento : " + e.getMessage();
		}

	}

	@Transactional
	public void salvar(GenericDomain genericDomain) {
		entityManager.persist(genericDomain);
	}

}