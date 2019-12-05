package br.com.bpss.hg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import br.com.bpss.hg.domain.ListaDesignacoesView;
import br.com.bpss.hg.domain.Tta150Parametro;
import br.com.bpss.hg.domain.Tth001JOperNaoDesignadasF;
import br.com.bpss.hg.domain.Tth001JOperNaoDesignadasH;
import br.com.bpss.hg.dto.FiltrosDTO;
import br.com.bpss.hg.repository.DesignacoesRepository;
import br.com.bpss.hg.repository.GenericRepository;
import br.com.bpss.hg.service.GenericService;
import br.com.bpss.hg.service.PermissoesService;

@Controller
public class DesignacoesController {

	@Autowired
	private DesignacoesRepository designacoesRepository;

	@Autowired
	private GenericRepository genericRepository;

	@Autowired
	GenericService utils;

	@Autowired
	PermissoesService permissoesService;

	final static Logger logger = Logger.getLogger(DesignacoesController.class);

	@RequestMapping(value = "/designacoes.bpss", method = RequestMethod.GET)
	public String designacoes(Model model, HttpSession session, SessionStatus status) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "517");

		if (!permissao)
			return "jsp/usuarioSemPermissao";

		List<ListaDesignacoesView> designacoes = designacoesRepository.listarDesignacoes(new FiltrosDTO());
		List<Tta150Parametro> parametro = genericRepository.getParametros();

		model.addAttribute("designacoes", designacoes);
		model.addAttribute("anoSafra", parametro.get(0).getAnoSafraAtual());

		return "jsp/listarDesignacoes";

	}
	
	@RequestMapping(value = "/listarDesignacoes.bpss", method = RequestMethod.POST)
	public String listarDesignacoes(Model model, HttpSession session, SessionStatus status, 
			@RequestParam("anoSafra") String anoSafra,
			@RequestParam("dtNegociacaoIni") String dtNegociacaoIni,
			@RequestParam("dtNegociacaoFim") String dtNegociacaoFim) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "517");

		if (!permissao)
			return "jsp/usuarioSemPermissao";

		FiltrosDTO filtrosDTO = new FiltrosDTO();
		filtrosDTO.setAnoSafra(anoSafra);
		filtrosDTO.setDtNegociacaoIni(dtNegociacaoIni);
		filtrosDTO.setDtNegociacaoFim(dtNegociacaoFim);
		
		List<ListaDesignacoesView> designacoes = designacoesRepository.listarDesignacoes(filtrosDTO);

		model.addAttribute("designacoes", designacoes);
		model.addAttribute("anoSafra", anoSafra);
		model.addAttribute("dtNegociacaoIni", dtNegociacaoIni);
		model.addAttribute("dtNegociacaoFim", dtNegociacaoFim);

		return "jsp/listarDesignacoes";

	}
	
	@RequestMapping(value = "/incluirDesignacoes.bpss", method = RequestMethod.POST)
	public String incluirDesignacoes(Model model, HttpSession session, SessionStatus status) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "518");

		if (!permissao)
			return "jsp/usuarioSemPermissao";

		List<Tth001JOperNaoDesignadasH> operacoesHedge = designacoesRepository.operacoesNaoDesignadasHedge(null);
		List<Tth001JOperNaoDesignadasF> operacoesFinanceiro = designacoesRepository.operacoesNaoDesignadasFinanc(null);
		List<Tta150Parametro> parametro = genericRepository.getParametros();

		model.addAttribute("operacoesHedge", operacoesHedge);
		model.addAttribute("operacoesFinanceiro", operacoesFinanceiro);
		model.addAttribute("anoSafra", parametro.get(0).getAnoSafraAtual());

		return "jsp/incluirDesignacoes";

	}

}