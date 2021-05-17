package com.leo.peoplesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.peoplesapi.dto.PersonDTO;
import com.leo.peoplesapi.entity.Person;
import com.leo.peoplesapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@Autowired
	public PersonService personService;
	
	@PostMapping
	public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDTO) {
		Person person = personService.salvar(personDTO);
	return ResponseEntity.ok().body(new PersonDTO(person));
	}
}
