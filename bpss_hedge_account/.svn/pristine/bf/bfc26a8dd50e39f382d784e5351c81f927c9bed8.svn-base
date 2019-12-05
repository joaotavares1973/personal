package br.com.bpss.hg.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bpss.hg.repository.MainRepository;

@Service("permissoesService")
public class PermissoesServiceImpl implements PermissoesService {
	
	@Autowired
	private MainRepository mainRepository;

	final static Logger logger = Logger.getLogger(PermissoesServiceImpl.class);

	@Override
	public boolean permicaoAutorizada(String usuario, String idPermissao) {
		return mainRepository.permicaoAutorizada(usuario, idPermissao);
	}





	
	
}
