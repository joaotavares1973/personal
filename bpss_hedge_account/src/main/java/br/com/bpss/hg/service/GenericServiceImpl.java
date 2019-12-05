package br.com.bpss.hg.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bpss.hg.repository.GenericRepository;

@Service("utilsService")
public class GenericServiceImpl implements GenericService {
	
	@Autowired
	private GenericRepository genericRepository;
	

	final static Logger logger = Logger.getLogger(GenericServiceImpl.class);


	@Override
	public Object getParametrosView() {
		
		List<Object> lista = genericRepository.getParametrosView();

		if(lista != null && lista.size() > 0 )
			return lista.get(0);
		else
			return null;
	}

	
	
}
