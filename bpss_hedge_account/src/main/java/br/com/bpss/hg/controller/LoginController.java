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

import br.com.bpss.hg.domain.Usuario;
import br.com.bpss.hg.repository.MainRepository;
import br.com.bpss.hg.service.PermissoesService;
import br.com.bpss.hg.service.GenericService;

@Controller
public class LoginController {

	@Autowired
	private MainRepository mainRepository;

	@Autowired
	GenericService utils;
	
	@Autowired
	PermissoesService permissoesService;

	final static Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/inicial.bpss", method = RequestMethod.GET)
	public String hedgeaccount(Model model, HttpSession session, SessionStatus status) {

		List<Object> listaUsuario = mainRepository.login((String) session.getAttribute("usuario"));
		
		if (!listaUsuario.isEmpty()) {
			
			Object[] results = (Object[]) listaUsuario.get(0);
			session.setAttribute("usuario", results[0]);

			return "jsp/principal";
		}else
			return "jsp/usuarioSemAutorizacao";

	}

	@RequestMapping(value = "/hedgeaccounting.bpss", method = RequestMethod.POST)
	public String hedgeaccounting(Model model, HttpSession session, SessionStatus status,
			@RequestParam("usuario") String usuario) {

		List<Object> listaUsuario = mainRepository.login(usuario);

		if (!listaUsuario.isEmpty()) {
			
			Object[] results = (Object[]) listaUsuario.get(0);
			session.setAttribute("usuario", results[0]);

			return "jsp/principal";
		}else
			return "jsp/usuarioSemAutorizacao";

	}
	
	@RequestMapping(value = "/hedgeaccount.bpss", method = RequestMethod.GET)
	public String hedgeaccount(Model model, HttpSession session, SessionStatus status,
			@RequestParam("usuario") String usuario) {

		List<Object> listaUsuario = mainRepository.login(usuario);

		if (!listaUsuario.isEmpty()) {
			
			Object[] results = (Object[]) listaUsuario.get(0);
			session.setAttribute("usuario", results[0]);

			return "jsp/principal";
		}else
			return "jsp/usuarioSemAutorizacao";

	}

}