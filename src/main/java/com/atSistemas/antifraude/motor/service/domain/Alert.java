package com.atSistemas.antifraude.motor.service.domain;

import com.atSistemas.antifraude.motor.rest.dto.RequestDTO;

/**
 * Clase Alert del dominio tiene su correspondiente {@link RequestDTO}
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
public class Alert 
{
	private String ip;
	private String tipo;
	private String login;

	public Alert (String tipo, String ip, String login) {
		this.ip = ip;
		this.login = login;
		this.tipo = tipo;
	}
	public Alert () {
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alert [login=" + login + ", ip=" + ip + "]";
	}
}
