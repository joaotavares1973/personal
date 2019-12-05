package br.com.bpss.hg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import br.com.bpss.hg.repository.MainRepository;
import br.com.bpss.hg.service.PermissoesService;
import br.com.bpss.hg.service.GenericService;

@Controller
public class ProdutoController {

	@Autowired
	private MainRepository mainRepository;

	@Autowired
	GenericService utils;
	
	@Autowired
	PermissoesService permissoesService;

	final static Logger logger = Logger.getLogger(ProdutoController.class);

	@RequestMapping(value = "/listarProdutos.bpss", method = RequestMethod.GET)
	public String listarProdutos(Model model, HttpSession session, SessionStatus status) {

		boolean permissao = permissoesService.permicaoAutorizada((String) session.getAttribute("usuario"), "8");
		
		if(!permissao)
			return "jsp/usuarioSemPermissao";
		
		List<Object> produtos = mainRepository.listarProduto(null);

		model.addAttribute("produtos", produtos);
		
		return "jsp/listarProdutos";

	}
}