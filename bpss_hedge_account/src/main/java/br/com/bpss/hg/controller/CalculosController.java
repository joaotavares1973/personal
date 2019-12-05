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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import br.com.bpss.hg.repository.CalculosRepository;
import br.com.bpss.hg.service.GenericService;
import br.com.bpss.hg.service.PermissoesService;

@Controller
public class CalculosController {

	@Autowired
	private CalculosRepository calculosRepository;

	@Autowired
	private GenericService genericService;

	@Autowired
	GenericService utils;

	@Autowired
	PermissoesService permissoesService;

	final static Logger logger = Logger.getLogger(CalculosController.class);

	@RequestMapping(value = "/calculos.bpss", method = RequestMethod.GET)
	public String gestorOperacoes(Model model, HttpSession session, SessionStatus status) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "522");

		if (!permissao)
			return "jsp/usuarioSemPermissao";

		List<Object> calculos = calculosRepository.listarCalculos();
		Object[] parametros = (Object[]) genericService.getParametrosView();

		model.addAttribute("calculos", calculos);
		model.addAttribute("flStatus", parametros[1]);

		return "jsp/listarCalculos";

	}

	@RequestMapping(value = "/verifcaProcessarCalculo.bpss", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String verifcaProcessarCalculo(Model model, HttpSession session) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "523");

		if (!permissao)
			return "9;Usuário sem permissão!";
		try {
			Object[] parametros = (Object[]) genericService.getParametrosView();

			if ("N".equals(parametros[7].toString().trim())) {
				return "0;" + parametros[4];

			} else {
				return "2;PROCESSO ESTÁ EM EXECUÇÃO";
			}
		} catch (Exception e) {
			return "9;Erro no Processamento : " + e.getMessage();
		}

	}

	@RequestMapping(value = "/processarCalculo.bpss", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String processarCalculo(Model model, HttpSession session) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "523");

		if (!permissao)
			return "9;Usuário sem permissão!";
		try {
			return calculosRepository.processarCalculo();
		} catch (Exception e) {
			return "9;Erro no Processamento : " + e.getMessage();
		}

	}

	@RequestMapping(value = "/verificaPeriodoContabil.bpss", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String verificaPeriodoContabil(Model model, HttpSession session) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "524");

		if (!permissao)
			return "9;Usuário sem permissão!";
		else {
			try {
				Object[] parametros = (Object[]) genericService.getParametrosView();
				return "0;" + parametros[4];
			} catch (Exception e) {
				return "9;Erro no Processamento : " + e.getMessage();
			}

		}

	}

	@RequestMapping(value = "/processarPeriodoContabil.bpss", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String processarPeriodoContabil(Model model, HttpSession session) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "524");

		if (!permissao)
			return "9;Usuário sem permissão!";
		try {
			return calculosRepository.processarPeriodoContabil();
		} catch (Exception e) {
			return "9;Erro no Processamento : " + e.getMessage();
		}

	}

}