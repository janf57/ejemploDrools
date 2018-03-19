package com.atSistemas.antifraude.motor.service.domain;

public class IpNegra {

	private String ip;
	/**
	 * 
	 */
	public IpNegra() {
		super();
	}

	/**
	 * @param ip to set
	 */
	public IpNegra(String ip) {
		super();
		this.ip = ip;
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
		return "IpNegra [ip=" + ip + "]";
	}	
}
