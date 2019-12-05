package br.com.bpss.hg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.bpss.hg.domain.Usuario;
import br.com.bpss.hg.repository.MainRepository;
import br.com.bpss.hg.service.GenericService;

@Component
public class HedgeAccAppInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private GenericService genericService;

	@Autowired
	private MainRepository mainRepository;

	public void onApplicationEvent(final ContextRefreshedEvent event) {

		Usuario usuario = new Usuario();
		//usuario.setLoginRede("admin");
		

	}
}