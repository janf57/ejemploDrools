package com.atSistemas.antifraude.motor.rest.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * Data Transfer Object para el {@link com.atSistemas.antifraude.motor.service.domain.Result} del modelo de dominio
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
@ApiModel(value = "Resultado de una Request", description = "Datos del resultado")
public class ResultDTO 
{

	private Integer code;
	public List<String> descriptions = new ArrayList<>();
	
	/**
	 * Constructor de ResultDTO sin argumentos
	 */
	public ResultDTO () {
		
	}
	/**
	 * Constructor de ResultDTO con todos los atributos como argumentos
	 * 
	 * @param code the code to set
	 * @param descriptions the descriptions to set
	 * 
	 */
	public ResultDTO (Integer code, List<String> descriptions) {
		this.code = code;
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the descriptions
	 */
	public List<String> getDescriptions() {
		return descriptions;
	}
	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultDTO [code=" + code + " description "+descriptions+"]";
	}
}
