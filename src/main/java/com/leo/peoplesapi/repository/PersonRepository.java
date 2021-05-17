package com.leo.peoplesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.peoplesapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByid(Long id);

}
