package com.almeda.jpa01onetooneuni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.almeda.jpa01onetooneuni.entity.Instructor;
import com.almeda.jpa01onetooneuni.service.InstructorService;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@GetMapping("/listar")
	public List<Instructor> listarInstructores(){
		return instructorService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Instructor consultarInstructor(@PathVariable Integer id) {
		if(instructorService.findById(id).isPresent()) {
			return instructorService.findById(id).get();
		}
		return new Instructor();
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Instructor guardarInstructor(@RequestBody Instructor instructor) {
		return instructorService.save(instructor);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Instructor actualizarInstructor(@RequestBody Instructor instructor, 
			@PathVariable Integer id) {
		if(instructorService.findById(id).isPresent()) {
			Instructor instructorFromDB = instructorService.findById(id).get();
			
			instructorFromDB.setEmail(instructor.getEmail());
			instructorFromDB.setFirstName(instructor.getFirstName());
			instructorFromDB.setLastName(instructor.getLastName());
			instructorFromDB.setInstructorDetail(instructor.getInstructorDetail());
			
			return instructorService.save(instructorFromDB);
		}else {
			return new Instructor();
		}		
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		instructorService.deleteById(id);
	}
}
