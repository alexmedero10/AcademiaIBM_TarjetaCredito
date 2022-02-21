package com.ibm.academia.apirest.tarjeta_credito.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.tarjeta_credito.datos.TarjetaCreditoDatosDummy;
import com.ibm.academia.apirest.tarjeta_credito.modelo.entidades.TarjetaCredito;

@DataJpaTest
public class TarjetaCreditoRepositoryTest {

	@Autowired
	private TarjetaCreditoRepository tarjetaRespository;
	
	
	@BeforeEach
	void setUp() {
		Iterable<TarjetaCredito> tarjetas = Arrays.asList(
						TarjetaCreditoDatosDummy.tarjeta01(),
						TarjetaCreditoDatosDummy.tarjeta02(),
						TarjetaCreditoDatosDummy.tarjeta03(),
						TarjetaCreditoDatosDummy.tarjeta04(),
						TarjetaCreditoDatosDummy.tarjeta05(),
						TarjetaCreditoDatosDummy.tarjeta06(),
						TarjetaCreditoDatosDummy.tarjeta07(),
						TarjetaCreditoDatosDummy.tarjeta08(),
						TarjetaCreditoDatosDummy.tarjeta09(),
						TarjetaCreditoDatosDummy.tarjeta10(),
						TarjetaCreditoDatosDummy.tarjeta11(),
						TarjetaCreditoDatosDummy.tarjeta12(),
						TarjetaCreditoDatosDummy.tarjeta13(),
						TarjetaCreditoDatosDummy.tarjeta14(),
						TarjetaCreditoDatosDummy.tarjeta15(),
						TarjetaCreditoDatosDummy.tarjeta16(),
						TarjetaCreditoDatosDummy.tarjeta17(),
						TarjetaCreditoDatosDummy.tarjeta18(),
						TarjetaCreditoDatosDummy.tarjeta19(),
						TarjetaCreditoDatosDummy.tarjeta20(),
						TarjetaCreditoDatosDummy.tarjeta21(),
						TarjetaCreditoDatosDummy.tarjeta22(),
						TarjetaCreditoDatosDummy.tarjeta23()
					);
		
		tarjetaRespository.saveAll(tarjetas);
	}
	
	@AfterEach
	void tearDown() {
		tarjetaRespository.deleteAll();
	}
	
	
	@Test
	@DisplayName("Test: Buscar tarjetas por preferencia, sueldo y edad")
	void buscarTarjetaPorPreferenciaYSueldoYEdad() {
		Optional<TarjetaCredito> expected = tarjetaRespository.buscarTarjetasPorPreferenciaYSueldoYEdad("Shopping", new BigDecimal(20000), 30);
		assertThat(expected.get().getTarjetas()).isEqualTo("Oro, Afinity Card, Office Depot, Costco, Best Buy Banamex, The Home Depot");
	}
	
}
