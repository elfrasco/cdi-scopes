package org.jboss.as.quickstarts.cdi.scopes.service;

import java.io.Serializable;

public class Paragraph implements Serializable {

	private static final long serialVersionUID = -9118888762453133647L;

	public String value = "";
	
	public void add(String str) {
		value += " " + str;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
