package com.leo.peoplesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leo.peoplesapi.entity.Person;
import com.leo.peoplesapi.entity.Phone;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByid(Long id);

	

}
