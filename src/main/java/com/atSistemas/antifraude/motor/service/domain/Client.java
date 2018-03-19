package com.atSistemas.antifraude.motor.service.domain;

import com.atSistemas.antifraude.motor.rest.dto.RequestDTO;

/**
 * Clase Client del dominio tiene su correspondiente {@link RequestDTO}
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
public class Client 
{
	private String login;
	private String pwd;

	public Client (String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}
	public Client () {
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
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * Valida si la pwd es correcta
	 * @param pwd pwt a comprobar
	 * @return acceso valido
	 */
	public Boolean validAccess(String pwd) {
		return this.pwd.equals(pwd);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [login=" + login + "]";
	}
}
