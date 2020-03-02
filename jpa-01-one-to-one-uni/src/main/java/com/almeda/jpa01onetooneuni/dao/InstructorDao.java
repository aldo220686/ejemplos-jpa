package com.almeda.jpa01onetooneuni.dao;

import org.springframework.data.repository.CrudRepository;

import com.almeda.jpa01onetooneuni.entity.Instructor;

public interface InstructorDao extends CrudRepository<Instructor, Integer>{

}
