package com.revproj.junit5_maven.dao;

import java.util.List;

import com.revproj.junit5_maven.model.AbstractEntity;

public interface Dao<E extends AbstractEntity> {

	void persist(E instance);

	E find(long id);

	void remove(E instance);

	E merge(E instance);

	List<E> findAll();

}
