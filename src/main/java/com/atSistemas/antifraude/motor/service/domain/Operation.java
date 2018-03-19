package com.atSistemas.antifraude.motor.service.domain;


/**
 * Clase Operation del dominio
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
public class Operation 
{
	private String cccDestination;
	private String pwd;
	private String login;
	private String ip;
	private Long amount;
	private Result result = null;

	public Operation (String login, String ip, String cccDestination, String pwd, Long amount) {
		this.login = login;
		this.ip = ip;
		this.cccDestination = cccDestination;
		this.pwd = pwd;
		this.amount = amount;
	}
	public Operation () {
	}
	/**
	 * @return the cccDestination
	 */
	public String getCccDestination() {
		return cccDestination;
	}
	/**
	 * @param cccDestination the ccc to set
	 */
	public void setCccDestination(String cccDestination) {
		this.cccDestination = cccDestination;
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
	/**
	 * @param result the result to set
	 */
	public void addResult(Integer code, String description) {
		if (result == null) {
			result = new Result (code, description);
		} else {
			if (code.equals(Result.KO)) {
				result.setCode(code);
			}
			result.addDescription(description);
		}
	}	
	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
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
		return "Operation [" + login + "(" + ip+ ") <" + cccDestination + "->" + amount + ">]";
	}
}
