package com.ibm.academia.apirest.tarjeta_credito.servicios;

import java.math.BigDecimal;
import java.util.Optional;

import com.ibm.academia.apirest.tarjeta_credito.modelo.entidades.TarjetaCredito;

public interface TarjetaCreditoDAO{
	
	public Optional<TarjetaCredito> buscarPorId(Long id);
	public TarjetaCredito guardar(TarjetaCredito entidad);
	public Iterable<TarjetaCredito> buscarTodos();
	public void eliminarPorId(Long id);
	public Optional<TarjetaCredito> buscarTarjetasPorPreferenciaYSueldoYEdad(String preferencia, BigDecimal sueldo, Integer edad);
}
