package com.atSistemas.antifraude.motor.service.domain;

import java.util.HashMap;
import java.util.Map;

import com.atSistemas.antifraude.motor.rest.dto.RequestDTO;

/**
 * Clase Request del dominio tiene su correspondiente {@link RequestDTO}
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
public class Request 
{
	private Type type;
	private Map<String,String> trama = new HashMap<>();

	public Request() {

	}

	public Request(Type type, Map<String,String> trama) {
		this.type = type;
		this.trama.putAll(trama);
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
	/**
	 * Metodo estatico para obtener un Request a partir de un RequestDTO request
	 * 
	 * @param request RequestDTO request
	 * 
	 * @return Request
	 */
	public static Request fromRequestDTO(RequestDTO request) {
		Request rest = new Request();
		rest.setTrama(request.getTrama());
		rest.setType(fromTypeDTO(request.getType().toString()));

		return rest;
	}

	/**
	 * Metodo para obtener un RequestDTO a partir de un Request origen
	 * 
	 * @return RequestDTO
	 */
	public RequestDTO toRequestDTO() {
		RequestDTO dto = new  RequestDTO();
		dto.setTrama(this.getTrama());
		dto.setType(toTypeDTO(this.getType().toString()));
		return dto;
	}

	private static Type fromTypeDTO(final String type) {
		switch (type) {
		case "ACCESS":
			return Type.ACCESS;
		case "IP":
			return Type.IP;
		default:
			return null;
		}
	}
	
	private RequestDTO.Type toTypeDTO(final String type) {
		switch (type) {
		case "ACCESS":
			return RequestDTO.Type.ACCESS;
		case "IP":
			return RequestDTO.Type.IP;
		default:
			return null;
		}
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
		return "Request [trama=" + trama + "]";
	}
}
