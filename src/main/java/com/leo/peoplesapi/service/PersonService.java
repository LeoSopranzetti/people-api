package com.leo.peoplesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leo.peoplesapi.dto.PersonDTO;
import com.leo.peoplesapi.dto.PhonesDTO;
import com.leo.peoplesapi.entity.Person;
import com.leo.peoplesapi.entity.Phone;
import com.leo.peoplesapi.repository.PersonRepository;
import com.leo.peoplesapi.repository.PhoneRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;

	public Person salvar(PersonDTO personDTO) {
		Person person = personDTO.converter(personDTO);
		personRepository.save(person);
		
		PhonesDTO phonesDTO = new PhonesDTO();
		List<Phone> list = person.getPhones();
		for (Phone phone : list) {
			phonesDTO.setNumber(phone.getNumber());
			phonesDTO.setPerson(person);
			phonesDTO.setType(phone.getType());
			Phone phoneSaved = phonesDTO.converter(person, personRepository);
			phoneRepository.save(phoneSaved);
			phone.setId(phoneSaved.getId());
		}
		
		personRepository.save(person);
		
		return person;
		
	}

	public List<Person> getAll() {
		List<Person> list = personRepository.findAll();
		return list;
	}

	public Optional<Person> findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person;
	}

	public ResponseEntity<?> delete(Long person_id) {
			Optional<Person>person = personRepository.findById(person_id);
			if(person.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			List<Phone> phones = phoneRepository.FindByPersonId(person_id);
			phoneRepository.deleteAll(phones);
			personRepository.deleteById(person_id);
		return ResponseEntity.ok().build();
		
	}

	public ResponseEntity<Person> update(Long id, PersonDTO personDTO) {
			Optional<Person> personOpt = personRepository.findById(id);
			if(personOpt.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			Person person = personDTO.update(id, personRepository);
			return ResponseEntity.ok().body(person);
	}
}
