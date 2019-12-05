package br.com.bpss.hg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bpss.hg.domain.GenericDomain;
import br.com.bpss.hg.domain.ListaDesignacoesView;
import br.com.bpss.hg.dto.FiltrosDTO;
import br.com.bpss.hg.dto.GestaoOperacoesDTO;

@Repository
public class GestaoOperacoesRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Object> listarGestaoOperacoes(GestaoOperacoesDTO gestaoOperacoesDTO) {

		Query query = null;
		StringBuffer condicao = new StringBuffer();

		condicao.append("select t.CONTRATO, t.DS_TIPO_OPERACAO, t.NM_GRP_PRODUTO, "
				+ "t.MES_ANO, t.NM_FIXACAO_TIPO, t.QTDE, t.PRECO, t.STATUS from tth001_j_lista_operacoes t ");

		if (gestaoOperacoesDTO.getAnoSafra() != null) {
			condicao.append("where t.ANO_SAFRA = '" + gestaoOperacoesDTO.getAnoSafra() + "' ");
		}
		
		query = entityManager.createNativeQuery(condicao.toString());
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object> listarOperacoes(FiltrosDTO filtrosDTO) {

		Query query = null;
		StringBuffer condicao = new StringBuffer();

		condicao.append("select t.CONTRATO, t.DS_TIPO_OPERACAO, t.NM_GRP_PRODUTO, "
				+ "t.MES_ANO, t.NM_FIXACAO_TIPO, t.QTDE, t.PRECO, t.STATUS from tth001_j_lista_operacoes t ");

		if (filtrosDTO.getAnoSafra() != null) {
			condicao.append("where t.ANO_SAFRA = '" + filtrosDTO.getAnoSafra() + "' ");
		}
		if (filtrosDTO.getDtNegociacaoIni() != null && !filtrosDTO.getDtNegociacaoIni().isEmpty()) {
			condicao.append("and t.DT_NEGOCIACAO BETWEEN '" + filtrosDTO.getDtNegociacaoIni() + "' AND '"
					+ filtrosDTO.getDtNegociacaoFim() + "'");
		}

		query = entityManager.createNativeQuery(condicao.toString());

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Object carregarOperacoes() {

		StoredProcedureQuery call = entityManager.createStoredProcedureQuery("TTH001_CARGA_OPERACOES");

		return call.getResultList();

	}

	@Transactional
	public void salvar(GenericDomain genericDomain) {
		entityManager.persist(genericDomain);
	}

}