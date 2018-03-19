package com.atSistemas.antifraude.motor.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.atSistemas.antifraude.motor.service.domain.Request;
import com.atSistemas.antifraude.motor.service.domain.Result;
import com.atSistemas.antifraude.motor.service.AntiFraudeService;
import com.atSistemas.antifraude.motor.rest.dto.RequestDTO;
import com.atSistemas.antifraude.motor.rest.dto.ResultDTO;

@RestController
@RequestMapping(value = "/antifraude/motor")
@Api(value = "AntiFraudeCommandsController", produces = "application/json")
/**
 * Controlador de commands 
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
public class  AntiFraudeCommandsController {

	@Autowired
	private AntiFraudeService antiFraudeService;

	/**
	 * Consulta a AntiFraude.
	 *
	 * @param request RequestDTO
	 * @param builder UriComponentsBuilder
	 * @return resultDTO
	 */
	@ApiOperation(value = "Crea un AntiFraude", tags = { "Controlador AntiFraudes" })
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "AntiFraude consultado", response = ResultDTO.class), @ApiResponse(code = 404, message = "No consultado") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResultDTO> consult(@ApiParam(value = "AntiFraude que se va a crear", required = true) @RequestBody @Valid RequestDTO request, UriComponentsBuilder builder) {

		Result result = antiFraudeService.consult(Request.fromRequestDTO(request));

		HttpHeaders headers = new HttpHeaders();

		ResultDTO output = result.toResultDTO();
		return new ResponseEntity<>(output, headers, HttpStatus.ACCEPTED);
	}

}
