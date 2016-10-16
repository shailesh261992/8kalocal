package com.project.messdeck.service;

import com.project.messdeck.aspects.ValidateWithOval;

public interface CRUDService<T> {
	@ValidateWithOval
	public T create(T obj);

	public T readSummary(Long id);

	@ValidateWithOval
	public T update(T obj);

	public boolean delete(Long id);

}
