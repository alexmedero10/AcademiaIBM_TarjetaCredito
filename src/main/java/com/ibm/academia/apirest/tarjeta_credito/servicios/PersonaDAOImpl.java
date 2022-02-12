package com.ibm.academia.apirest.tarjeta_credito.servicios;

import com.ibm.academia.apirest.tarjeta_credito.modelo.entidades.Persona;
import com.ibm.academia.apirest.tarjeta_credito.repositorios.PersonaRepository;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO{

	public PersonaDAOImpl(PersonaRepository repository) {
		super(repository);
	}

}
