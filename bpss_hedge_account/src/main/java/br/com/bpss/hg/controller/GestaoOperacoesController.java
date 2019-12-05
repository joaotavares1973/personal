package br.com.bpss.hg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import br.com.bpss.hg.domain.Tta150Parametro;
import br.com.bpss.hg.dto.FiltrosDTO;
import br.com.bpss.hg.dto.GestaoOperacoesDTO;
import br.com.bpss.hg.repository.GenericRepository;
import br.com.bpss.hg.repository.GestaoOperacoesRepository;
import br.com.bpss.hg.service.GenericService;
import br.com.bpss.hg.service.PermissoesService;

@Controller
public class GestaoOperacoesController {

	@Autowired
	private GenericService genericService;
	
	@Autowired
	private GenericRepository genericRepository;
	
	@Autowired
	private GestaoOperacoesRepository gestaoOperacoesRepository;

	@Autowired
	GenericService utils;

	@Autowired
	PermissoesService permissoesService;

	final static Logger logger = Logger.getLogger(GestaoOperacoesController.class);

	@RequestMapping(value = "/gestorOperacoes.bpss", method = RequestMethod.GET)
	public String gestorOperacoes(Model model, HttpSession session, SessionStatus status) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "514");

		if (!permissao)
			return "jsp/usuarioSemPermissao";

		GestaoOperacoesDTO gestaoOperacoesDTO = new GestaoOperacoesDTO();
		
		List<Tta150Parametro> parametro = genericRepository.getParametros();
		gestaoOperacoesDTO.setAnoSafra(parametro.get(0).getAnoSafraAtual());
		
		List<Object> operacoes = gestaoOperacoesRepository.listarGestaoOperacoes(gestaoOperacoesDTO);
		Object[] parametros = (Object[]) genericService.getParametrosView();
		
		model.addAttribute("operacoes", operacoes);
		model.addAttribute("mesAno", parametros[4]);
		model.addAttribute("anoSafra", parametro.get(0).getAnoSafraAtual());

		return "jsp/listarOperacoes";

	}
	
	@RequestMapping(value = "/listarOperacoes.bpss", method = RequestMethod.POST)
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
		
		List<Object> operacoes = gestaoOperacoesRepository.listarOperacoes(filtrosDTO);
		Object[] parametros = (Object[]) genericService.getParametrosView();

		model.addAttribute("operacoes", operacoes);
		model.addAttribute("anoSafra", anoSafra);
		model.addAttribute("mesAno", parametros[4]);
		model.addAttribute("dtNegociacaoIni", dtNegociacaoIni);
		model.addAttribute("dtNegociacaoFim", dtNegociacaoFim);

		return "jsp/listarOperacoes";

	}
	
	@RequestMapping(value = "/carregarOperacoes.bpss", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String carregarOperacoes( Model model, HttpSession session) {
		
		Object retorno = gestaoOperacoesRepository.carregarOperacoes();

		return "OK";
	}	
	
}