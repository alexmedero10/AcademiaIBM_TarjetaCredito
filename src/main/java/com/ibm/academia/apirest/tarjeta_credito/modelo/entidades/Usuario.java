package com.ibm.academia.apirest.tarjeta_credito.modelo.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios", schema = "tarjeta_credito")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Usuario extends Persona {
	
	@Column(name = "preferencia", nullable = false)
	private String preferencia;
	
	@Column(name = "salario", nullable = false)
	private BigDecimal salario;

	
	
	private static final long serialVersionUID = 2510110509993782724L;
}
