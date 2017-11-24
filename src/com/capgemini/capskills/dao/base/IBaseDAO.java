package com.capgemini.capskills.dao.base;

import java.util.List;

import com.capgemini.capskills.entities.base.BaseEntity;

public interface IBaseDAO <T extends BaseEntity> {

	public T insert(T item);
	public void delete(T item);
	public void update(T item);
	public T select(T item);
	public List<T> select();

	public String getCreateTable();
}

