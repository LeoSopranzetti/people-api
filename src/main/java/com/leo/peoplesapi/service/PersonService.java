package com.leo.peoplesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
