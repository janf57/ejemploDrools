package com.atSistemas.antifraude.motor.service;

import com.atSistemas.antifraude.motor.service.domain.Access;
import com.atSistemas.antifraude.motor.service.domain.Operation;
import com.atSistemas.antifraude.motor.service.domain.Result;

/**
 * RuleRunner encargado de lanzar las reglas
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 *
 */
public interface RuleRunner {

	public Result launchAccess(Access access);
	public Result launchOperation(Operation operation);
}
