package com.ibm.academia.apirest.tarjeta_credito.servicios;

import java.math.BigDecimal;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.tarjeta_credito.excepciones.NotFoundException;
import com.ibm.academia.apirest.tarjeta_credito.modelo.entidades.TarjetaCredito;
import com.ibm.academia.apirest.tarjeta_credito.repositorios.TarjetaCreditoRepository;

@Service
public class TarjetaCreditoDAOImpl implements TarjetaCreditoDAO{

	protected final TarjetaCreditoRepository repository;
	
	public TarjetaCreditoDAOImpl(TarjetaCreditoRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TarjetaCredito> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public TarjetaCredito guardar(TarjetaCredito entidad) {
		return repository.save(entidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TarjetaCredito> buscarTodos() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void eliminarPorId(Long id) {
		repository.deleteById(id);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<TarjetaCredito> buscarTarjetasPorPreferenciaYSueldoYEdad(String preferencia, BigDecimal sueldo,
			Integer edad) {
		Optional<TarjetaCredito> oTarjetas = repository.buscarTarjetasPorPreferenciaYSueldoYEdad(preferencia, sueldo, edad);
		
		if(oTarjetas.isEmpty())
			throw new NotFoundException("No existen tarjetas para el usuario");
		
		return oTarjetas;
	}

}
