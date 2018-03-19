/**
 * 
 */
package com.atSistemas.antifraude.motor.service.domain;

/**
 * @author janavarro.fuentes
 *
 */
public class Threshold {

	private Type type;
	private long value;
	/**
	 * @param type to set
	 * @param value to set
	 */
	public Threshold(Type type, long value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	public long getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(long value) {
		this.value = value;
	}
	
	public enum Type {
		MAX_LOGINS_INCORRECTOS("MAX_LOGINS_INCORRECTOS"),TIME_LOGINS_INCORRECTOS("TIME_LOGINS_INCORRECTOS"),
		TIME_OPERACIONES_BAJAS("TIME_OPERACIONES_BAJAS"),CANTIDAD_OPERACION_BAJA("CANTIDAD_OPERACION_BAJA");
		private final String value;

		Type(final String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Thresholds [type=" + type + ", value=" + value + "]";
	}
}
