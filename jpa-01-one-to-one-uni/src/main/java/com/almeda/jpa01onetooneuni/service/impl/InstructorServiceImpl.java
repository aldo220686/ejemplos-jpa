package com.almeda.jpa01onetooneuni.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almeda.jpa01onetooneuni.dao.InstructorDao;
import com.almeda.jpa01onetooneuni.entity.Instructor;
import com.almeda.jpa01onetooneuni.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	private InstructorDao instructorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Instructor> findAll() {
		return (List<Instructor>) instructorDao.findAll();
	}
	
	/* Forma 1 sin devolver optional haciendo uso del metodo orElse()
	@Override
	@Transactional(readOnly = true)
	public Instructor findById(Integer id) {
		return instructorDao.findById(id).orElse(null);
	}*/
	
	/* 
	 * Forma 2 devolviendo un optional sin hacer uso del orElse()
	 * el metodo de la interfaz tambien debe cambiar a optional
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<Instructor> findById(Integer id) {
		return instructorDao.findById(id);
	}
	
	@Override
	@Transactional
	public Instructor save(Instructor instructor) {
		return instructorDao.save(instructor);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		instructorDao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsById(Integer id) {
		return instructorDao.existsById(id);
	}

}
