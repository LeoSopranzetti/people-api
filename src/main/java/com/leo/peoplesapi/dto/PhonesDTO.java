package com.leo.peoplesapi.dto;

import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.leo.peoplesapi.entity.Person;
import com.leo.peoplesapi.entity.Phone;
import com.leo.peoplesapi.enums.PhoneType;
import com.leo.peoplesapi.repository.PersonRepository;

public class PhonesDTO {

	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	private String number;
	
	private Person person;

	public PhonesDTO(Phone phone) {
		this.id = phone.getId();
		this.type = phone.getType();
		this.number = phone.getNumber();
		this.person = phone.getPerson();
	}

	public PhonesDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Phone converter(Person person2, PersonRepository personRepository) {
		Person person = personRepository.findByid(person2.getId());
		return new Phone(id, type, number, person);
	}
	
	
}
