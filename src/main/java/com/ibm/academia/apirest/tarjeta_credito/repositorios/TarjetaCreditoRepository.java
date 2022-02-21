package com.ibm.academia.apirest.tarjeta_credito.repositorios;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.tarjeta_credito.modelo.entidades.TarjetaCredito;

@Repository
public interface TarjetaCreditoRepository extends CrudRepository<TarjetaCredito, Long>{

	@Query("select t from TarjetaCredito t where upper(t.preferencia) = upper(?1)"
			+ " and ?2 between t.sueldoMinimo and t.sueldoMaximo"
			+ " and ?3 between t.edadMinima and t.edadMaxima")
	public Optional<TarjetaCredito> buscarTarjetasPorPreferenciaYSueldoYEdad(String preferencia, BigDecimal sueldo, Integer edad);
	
}
