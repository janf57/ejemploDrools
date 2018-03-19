package com.atSistemas.antifraude.motor.service;

import com.atSistemas.antifraude.motor.service.domain.Request;
import com.atSistemas.antifraude.motor.service.domain.Result;

/**
 * AntiFraude Service, define el caso de uso del API
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 *
 */
public interface AntiFraudeService 
{
	Result consult(Request request);
}
