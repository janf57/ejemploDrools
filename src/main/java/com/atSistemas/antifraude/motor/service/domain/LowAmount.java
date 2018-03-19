package com.atSistemas.antifraude.motor.service.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LowAmount {

	private String login;

	private List<Long> lowAmounts = new ArrayList<>();
	/**
	 * @param login to set
	 * @param lowAmounts to set
	 */
	public LowAmount(String login, List<Long> lowAmounts) {
		super();
		this.login = login;
		this.lowAmounts = lowAmounts;
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
	 * @return the lowAmounts
	 */
	public List<Long> getLowAmounts() {
		return lowAmounts;
	}

	/**
	 * @param lowAmounts the lowAmounts to set
	 */
	public void setLowAmounts(List<Long> lowAmounts) {
		this.lowAmounts = lowAmounts;
	}
	public void addLowAmount() {
		lowAmounts.add(System.currentTimeMillis() / 1000);
	}
	
	public Boolean maxLowAmounts(long value, long secs) {
		long now = System.currentTimeMillis() / 1000;
		long control = now - secs;
		for(Iterator<Long> iter = lowAmounts.iterator(); iter.hasNext();){
			Long time = iter.next();
			if(time < control){
				iter.remove();
			}
		}
		return lowAmounts.size() >= value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LowAmount [" + login + "]";
	}
}
