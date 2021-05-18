package com.leo.peoplesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leo.peoplesapi.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

	@Query("Select m from Phone m where m.person.id = :id")
	List<Phone> FindByPersonId(@Param("id")Long person_id);


}
