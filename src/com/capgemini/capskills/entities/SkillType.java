package com.capgemini.capskills.entities;

import com.capgemini.capskills.entities.base.BaseEntity;

public class SkillType extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


@Override
public String toString() {
	return this.name;
}}