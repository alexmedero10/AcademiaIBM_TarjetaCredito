package com.ibm.academia.apirest.tarjeta_credito.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tarjetas_credito", schema = "tarjetas")
public class TarjetaCredito implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "preferencia")
	private String preferencia;
	
	@NotEmpty
	@Positive
	@Column(name = "sueldo_minimo")
	private BigDecimal sueldoMinimo;
	
	@NotEmpty
	@Positive
	@Column(name = "sueldo_maximo")
	private BigDecimal sueldoMaximo;
	
	@NotEmpty
	@Positive
	@Column(name = "edad_minima")
	private Integer edadMinima;
	
	@NotEmpty
	@Positive
	@Column(name = "edad_maxima")
	private Integer edadMaxima;	
	
	@NotEmpty
	@Size(min = 3, max = 150)
	@Column(name = "tarjetas")
	private String tarjetas;
	
	@NotEmpty
	@Size(min = 3, max = 30)
	@Column(name = "usuario_creacion")
	private String usuarioCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	public TarjetaCredito(@NotEmpty String preferencia,
			@NotEmpty @Positive BigDecimal sueldoMinimo, @NotEmpty @Positive BigDecimal sueldoMaximo,
			@NotEmpty @Positive Integer edadMinima, @NotEmpty @Positive Integer edadMaxima,
			@NotEmpty @Size(min = 3, max = 150) String tarjetas,
			@NotEmpty @Size(min = 3, max = 30) String usuarioCreacion) {
		this.preferencia = preferencia;
		this.sueldoMinimo = sueldoMinimo;
		this.sueldoMaximo = sueldoMaximo;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		this.tarjetas = tarjetas;
		this.usuarioCreacion = usuarioCreacion;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		return Objects.equals(id, other.id);
	}

	
	@PrePersist
	public void antesPersistir() {
		this.fechaCreacion = new Date();
	}
	
	@PreUpdate
	public void antesActualizar() {
		this.fechaModificacion = new Date();
	}


	private static final long serialVersionUID = 2072431473439127247L;
}
