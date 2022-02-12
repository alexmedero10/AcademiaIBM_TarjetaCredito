package com.ibm.academia.apirest.tarjeta_credito.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.academia.apirest.tarjeta_credito.modelo.entidades.Persona;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Long>{

}
