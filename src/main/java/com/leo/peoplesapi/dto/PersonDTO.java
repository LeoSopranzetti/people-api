package com.leo.peoplesapi.dto;

import java.time.LocalDate;
import java.util.List;

import com.leo.peoplesapi.entity.Person;
import com.leo.peoplesapi.entity.Phone;

public class PersonDTO {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String cpf;
	
	private LocalDate birthDate;
	
	private List<Phone> phones;

	
	public PersonDTO(Person person) {
		this.id = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.cpf = person.getCpf();
		this.birthDate = person.getBirthDate();
		this.phones = person.getPhones();
	}
	
	public PersonDTO(){	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Person converter(PersonDTO personDTO) {
		return new Person(id, firstName, lastName, cpf, birthDate, phones);
	}
	
	
}
