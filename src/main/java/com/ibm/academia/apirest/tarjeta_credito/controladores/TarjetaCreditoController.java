package com.ibm.academia.apirest.tarjeta_credito.controladores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.tarjeta_credito.modelo.entidades.TarjetaCredito;
import com.ibm.academia.apirest.tarjeta_credito.servicios.TarjetaCreditoDAO;


@RestController
@RequestMapping("/restapi")
public class TarjetaCreditoController {

	@Autowired
	private TarjetaCreditoDAO tarjetaCreditoDao;
	
	@GetMapping("/tarjetas/lista")
	public ResponseEntity<?> listarTodas(){
		List<TarjetaCredito> tarjetasCredito = (List<TarjetaCredito>) tarjetaCreditoDao.buscarTodos();
		return new ResponseEntity<List<TarjetaCredito>>(tarjetasCredito, HttpStatus.OK);
	}
	
	@PostMapping("/tarjeta")
	public ResponseEntity<?> guardar(@Valid @RequestBody TarjetaCredito tarjetaCredito, BindingResult result){
		Map<String, Object> validaciones = new HashMap<String, Object>();
		
		if(result.hasErrors()){
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
		}
		
		TarjetaCredito tarjetaGuardada = tarjetaCreditoDao.guardar(tarjetaCredito);
		return new ResponseEntity<TarjetaCredito>(tarjetaGuardada, HttpStatus.CREATED);
	}
	
	@GetMapping("/tarjeta/recomendar/{preferencia}/{sueldo}/{edad}")
	public ResponseEntity<?> buscarTarjetasPorPreferenciaYSueldoYEdad(@PathVariable String preferencia, 
			@PathVariable BigDecimal sueldo, @PathVariable Integer edad){
		
		Optional<TarjetaCredito> tarjetas = tarjetaCreditoDao.buscarTarjetasPorPreferenciaYSueldoYEdad(preferencia, sueldo, edad);
		
		return new ResponseEntity<String>(tarjetas.get().getTarjetas(), HttpStatus.OK);
	}
	
}
