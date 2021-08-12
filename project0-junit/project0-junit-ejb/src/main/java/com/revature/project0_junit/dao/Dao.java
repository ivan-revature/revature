package com.revature.project0_junit.dao;

import java.util.List;

import com.revature.project0_junit.model.AbstractEntity;

public interface Dao<E extends AbstractEntity> {

	void persist(E instance);

	E find(long id);

	void remove(E instance);

	E merge(E instance);

	List<E> findAll();

}
