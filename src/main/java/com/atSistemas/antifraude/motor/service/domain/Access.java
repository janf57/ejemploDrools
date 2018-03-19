package com.atSistemas.antifraude.motor.service.domain;

import com.atSistemas.antifraude.motor.rest.dto.RequestDTO;

/**
 * Clase Access del dominio tiene su correspondiente {@link RequestDTO}
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
public class Access 
{
	private String login;
	private String pwd;
	private String ip;
	private Result result = null;

	public Access (String ip, String login, String pwd) {
		this.ip = ip;
		this.login = login;
		this.pwd = pwd;
	}
	public Access () {
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
	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Access [login=" + login + ", ip=" + ip + "]";
	}
}
