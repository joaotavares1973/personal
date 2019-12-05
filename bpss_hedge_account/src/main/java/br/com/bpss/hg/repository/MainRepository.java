package br.com.bpss.hg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bpss.hg.domain.GenericDomain;
import br.com.bpss.hg.domain.Usuario;

@Repository
public class MainRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Object> login(String usuario) {

		Query query = entityManager.createQuery("select us from Usuario us where us.cdUsuario =:cdUsuario", Usuario.class);
		query.setParameter("cdUsuario", usuario);
		List<Usuario> usuarioq = query.getResultList();
		
		query = entityManager
				.createNativeQuery("select * from tta401_usuario t where t.cd_usuario = '" + usuario + "'");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object> listarProduto(String tipoProduto) {

		Query query = null;

		if (tipoProduto == null) {
			query = entityManager.createNativeQuery("select cd_grp_produto, nm_grp_produto from tta110_j_grp_produto");
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public boolean permicaoAutorizada(String usuario, String idPermissao) {

		Query query = entityManager.createNativeQuery("select t.NM_PERMISSAO from tta302_j_valida_perm_simples t "
				+ "where t.ID_PERMISSAO = " + idPermissao + " and t.CD_USUARIO = '" + usuario + "'");

		if (query.getResultList().isEmpty())
			return false;
		else
			return true;
	}


	@Transactional
	public void salvar(GenericDomain genericDomain) {
		entityManager.persist(genericDomain);
	}

//	@SuppressWarnings("unchecked")
//	public List<Lojas> listarLojas(Lojas lojas) {
//
//		Query query = null;
//
//		if (lojas == null) {
//			query = entityManager.createQuery("Select lojas from Lojas lojas " + " JOIN FETCH lojas.shopping shopping "
//					+ "JOIN FETCH lojas.operadores operador " + " where lojas.operadores.id = operador.id "
//					+ "and lojas.tipoLoja = 'S' " + "order by lojas.idLoja");
//		} else if (lojas.getOperadores().getId() != null) {
//			query = entityManager.createQuery("Select lojas from Lojas lojas " + " JOIN FETCH lojas.shopping shopping "
//					+ " JOIN FETCH lojas.operadores operador " + " where lojas.operadores.id = operador.id "
//					+ " and lojas.tipoLoja = 'S' and lojas.operadores.id = :id " + "order by lojas.idLoja");
//			query.setParameter("id", lojas.getOperadores().getId());
//		} else if (lojas.getIdLoja() != null) {
//			query = entityManager.createQuery(
//					"Select o from Lojas o where o.idLoja =:idLoja and lojas.tipoLoja = 'S' order by o.idLoja");
//			query.setParameter("idLoja", lojas.getIdLoja());
//		}
//
//		return query.getResultList();
//	}

}