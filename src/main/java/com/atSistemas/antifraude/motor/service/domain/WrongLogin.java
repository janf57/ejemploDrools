package com.atSistemas.antifraude.motor.service.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase WrongLogin del dominio
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
public class WrongLogin 
{
	private String ip;

	private List<Long> wrongAccess = new ArrayList<>();

	public WrongLogin(String ip, List<Long> wrongAccess) {
		this.ip = ip;
		this.wrongAccess = wrongAccess;
	}

	public WrongLogin(String ip) {
		this.ip = ip;
		this.wrongAccess.add(System.currentTimeMillis() / 1000);
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
	 * @return the wrongAccess
	 */
	public List<Long> getWrongAccess() {
		return wrongAccess;
	}
	/**
	 * @param wrongAccess the wrongAccess to set
	 */
	public void setWrongAccess(List<Long> wrongAccess) {
		this.wrongAccess = wrongAccess;
	}
	public void addWrongAccess() {
		wrongAccess.add(System.currentTimeMillis() / 1000);
	}
	
	public Boolean maxLoginsIncorrectos(long value, long secs) {
		long now = System.currentTimeMillis() / 1000;
		long control = now - secs;
		for(Iterator<Long> iter = wrongAccess.iterator(); iter.hasNext();){
			Long time = iter.next();
			if(time < control){
				iter.remove();
			}
		}
		return wrongAccess.size() >= value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WrongLogin [" + ip + "]";
	}
}
