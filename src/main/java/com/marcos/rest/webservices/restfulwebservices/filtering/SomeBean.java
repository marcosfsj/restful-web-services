package com.marcos.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"prop2", "prop3"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String prop1;
	private String prop2;
	
	// @JsonIgnore
	private String prop3;
	
	public SomeBean(String prop1, String prop2, String prop3) {
		this.prop1 = prop1;
		this.prop2 = prop2;
		this.prop3 = prop3;
	}

	public String getProp1() {
		return prop1;
	}
	
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	
	public String getProp2() {
		return prop2;
	}
	
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
	
	public String getProp3() {
		return prop3;
	}
	
	public void setProp3(String prop3) {
		this.prop3 = prop3;
	}

}
