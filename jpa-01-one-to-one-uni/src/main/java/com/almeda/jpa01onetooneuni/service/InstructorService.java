package com.almeda.jpa01onetooneuni.service;

import java.util.List;
import java.util.Optional;

import com.almeda.jpa01onetooneuni.entity.Instructor;

public interface InstructorService {

	public List<Instructor> findAll();
	public Optional<Instructor> findById(Integer id);
	public Instructor save(Instructor instructor);
	public void deleteById(Integer id);
	public boolean existsById(Integer id);
}
