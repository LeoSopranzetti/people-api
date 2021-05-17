package com.leo.peoplesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.peoplesapi.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
