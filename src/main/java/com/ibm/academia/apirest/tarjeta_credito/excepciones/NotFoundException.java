package com.ibm.academia.apirest.tarjeta_credito.excepciones;

public class NotFoundException extends RuntimeException{

	public NotFoundException(String mensaje){
		super(mensaje);
	}
	
	private static final long serialVersionUID = -1692659933493603344L;

}
