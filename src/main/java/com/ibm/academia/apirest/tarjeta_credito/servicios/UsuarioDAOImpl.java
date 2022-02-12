package com.ibm.academia.apirest.tarjeta_credito.servicios;

import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.tarjeta_credito.repositorios.PersonaRepository;

@Service
public class UsuarioDAOImpl extends PersonaDAOImpl implements UsuarioDAO{

	public UsuarioDAOImpl(PersonaRepository repository) {
		super(repository);
	}

}
