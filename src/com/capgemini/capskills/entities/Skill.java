package com.capgemini.capskills.entities;

import com.capgemini.capskills.entities.base.BaseEntity;

public class Skill extends BaseEntity {

	//Attributes
	private String name;

	//Specific Constructor
	public Skill(String name) {
		super();
		this.name = name;
	}

	//Default Constructor
	public Skill(){}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Skill [name=" + this.name + ", getId()="+ getId() +"]";
	}

}
