package com.atSistemas.antifraude.motor.service.domain;

import java.util.ArrayList;
import java.util.List;

import com.atSistemas.antifraude.motor.rest.dto.ResultDTO;

public class Result {
	
	public static final Integer OK = 0;
	public static final Integer KO = 1;
	
	public Integer code;
	public List<String> descriptions = new ArrayList<>();
	
	/**
	 * @param code to set
	 * @param descriptions to set
	 */
	public Result(Integer code, List<String> descriptions) {
		super();
		this.code = code;
		this.descriptions = descriptions;
	}
	/**
	 * @param code to set
	 * @param description to add
	 */
	public Result(Integer code, String description) {
		super();
		this.code = code;
		this.descriptions.add(description);
	}	
	/**
	 * 
	 */
	public Result() {

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
	 * @param description the description to add
	 */
	public void addDescription(String description) {
		descriptions.add(description);
	}
	/**
	 * Metodo estatico para obtener un Result a partir de un ResultDTO request
	 * 
	 * @param result ResultDTO result
	 * 
	 * @return Result
	 */
	public static Result fromResultDTO(ResultDTO result) {
		Result rest = new Result();
		rest.setCode(result.getCode());
		rest.setDescriptions(result.getDescriptions());

		return rest;
	}

	/**
	 * Metodo para obtener un ResultDTO a partir de un Result origen
	 * 
	 * @return ResultDTO
	 */
	public ResultDTO toResultDTO() {
		ResultDTO dto = new  ResultDTO();
		dto.setCode(this.getCode());
		dto.setDescriptions(this.getDescriptions());
		return dto;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultDTO [code=" + code + " descriptions "+descriptions+"]";
	}
}
