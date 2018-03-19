package com.atSistemas.antifraude.motor.rest.dto;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.ApiModel;

/**
 * Data Transfer Object para el {@link com.atSistemas.antifraude.motor.service.domain.Request} del modelo de dominio
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
@ApiModel(value = "Informacion de una Request", description = "Datos de la Request")
public class RequestDTO 
{

	private Type type;
	private Map<String,String> trama = new HashMap<>();
	/**
	 * Constructor de RequestDTO sin argumentos
	 */
	public RequestDTO () {
		
	}
	/**
	 * Constructor de RequestDTO con todos los atributos como argumentos
	 * 
	 * @param trama the trama to set
	 * 
	 */
	public RequestDTO (Map<String,String> trama) {
		this.trama = trama;
	}
	
	/**
	 * @return the trama
	 */
	public Map<String,String> getTrama() {
		return trama;
	}
	/**
	 * @param trama the trama to set
	 */
	public void setTrama(Map<String,String> trama) {
		this.trama = trama;
	}
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
    public enum Type {
        ACCESS("ACCESS"), IP("IP");
        private final String type;

        Type(final String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestDTO [trama=" + trama + "]";
	}
}
