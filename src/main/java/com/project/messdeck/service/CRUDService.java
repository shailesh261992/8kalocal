package com.project.messdeck.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.exceptions.InvalidOpreationException;

public interface CRUDService<T> {
	@ValidateWithOval
	public T create(T obj);

	public T readSummary(Long id);

	@ValidateWithOval
	public T update(T obj);

	public boolean delete(Long id);

	public default T getResorce(JpaRepository<T, Long> repo, Long id) {

		Optional<T> findOne = (Optional<T>) Optional.ofNullable(repo.findOne(id));
		if (findOne.isPresent()) {
			return findOne.get();
		} else {
			throw new InvalidOpreationException("Resource with id " + id + " Not exists. Operation Failed");
		}

	}

}
