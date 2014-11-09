package com.crossp.jpa.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.crossp.jpa.domain.Application;


@Service
public interface ApplicationRepository extends CrudRepository<Application, Long> {

}
