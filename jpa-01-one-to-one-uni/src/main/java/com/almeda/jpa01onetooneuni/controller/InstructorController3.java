package com.almeda.jpa01onetooneuni.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.almeda.jpa01onetooneuni.entity.Instructor;
import com.almeda.jpa01onetooneuni.exceptionhandler.exceptions.InstructorIdNotFoundException;
import com.almeda.jpa01onetooneuni.service.InstructorService;

@RestController
@RequestMapping("/api/v3/instructor")
public class InstructorController3 {

	//@Autowired
	private InstructorService instructorService;
	
	public InstructorController3(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Instructor>> listarInstructores(){		
		return new ResponseEntity<List<Instructor>>(instructorService.findAll(), HttpStatus.OK);
	}
	
	// Forma 1
	/*
	@GetMapping("/{id}")
	public Instructor consultarInstructor(@PathVariable Integer id){
		return instructorService.findById(id).orElseThrow(() -> new InstructorIdNotFoundException());
	}*/
	
	//Forma 2
	@GetMapping("/{id}")
	public ResponseEntity<Instructor> consultarInstructor(@PathVariable Integer id){
		return ResponseEntity.ok().body(instructorService.findById(id).orElseThrow(()-> new InstructorIdNotFoundException()));
	}
	
	@PostMapping
	public ResponseEntity<Instructor> guardarInstructor(@RequestBody Instructor instructor) {
		Instructor instructorSaved = instructorService.save(instructor);
		
		URI uriInstructor = ServletUriComponentsBuilder
								.fromCurrentRequest()
								.path("/{id}")
						        .buildAndExpand(instructorSaved.getId())
						        .toUri();
		HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setLocation(uriInstructor);
		//return new ResponseEntity<Instructor>(instructorSaved, HttpStatus.CREATED);	    
		//return ResponseEntity.created(uriInstructor).build();	    
	    //return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(instructorSaved);
	    return ResponseEntity.created(uriInstructor).headers(httpHeaders).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Instructor> actualizarInstructor(@RequestBody Instructor instructor, 
			@PathVariable Integer id)throws InstructorIdNotFoundException {
		if(instructorService.findById(id).isPresent()) {			
			Instructor instructorFromDB = instructorService.findById(id)
												.map(x->{
													x.setEmail(instructor.getEmail());
													x.setFirstName(instructor.getFirstName());
													x.setLastName(instructor.getLastName());
													x.setInstructorDetail(instructor.getInstructorDetail());
													return x;})
												.get();
			
			return new ResponseEntity<Instructor>(instructorFromDB, HttpStatus.CREATED);			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws InstructorIdNotFoundException{
		if(instructorService.existsById(id)) {
			instructorService.deleteById(id);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
