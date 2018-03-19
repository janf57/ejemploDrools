package com.atSistemas.antifraude.motor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atSistemas.antifraude.motor.service.domain.Access;
import com.atSistemas.antifraude.motor.service.domain.Operation;
import com.atSistemas.antifraude.motor.service.domain.Request;
import com.atSistemas.antifraude.motor.service.domain.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.atSistemas.antifraude.motor.service.AntiFraudeService;

/**
 * Implementacion interna de {@link com.atSistemas.antifraude.motor.service.AntiFraudeService}. Esta clase no se debe acceder directamente
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
@Service
public class AntiFraudeServiceImpl implements AntiFraudeService 
{
	@Autowired
	RuleRunnerImpl ruleRunner;
	
	@Autowired
	ObjectMapper mapper;
	
	@Override
	public Result consult(Request request) {

		if (request.getType().equals(Request.Type.ACCESS)) {
			Access access = mapper.convertValue(request.getTrama(), Access.class);
			return ruleRunner.launchAccess(access);
		} else if (request.getType().equals(Request.Type.IP)) {
			Operation oper = mapper.convertValue(request.getTrama(), Operation.class);
			return ruleRunner.launchOperation(oper);
		}
		return null;
	}
}
