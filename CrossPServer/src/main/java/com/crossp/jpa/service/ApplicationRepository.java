package com.crossp.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.crossp.jpa.domain.Application;
import com.crossp.jpa.domain.User;


@Service
public interface ApplicationRepository extends CrudRepository<Application, Long> {

	public List<Application> findByUser(User user);
	
	@Query(value = "select a.* from application a, application_application b where a.id=b.application_id and a.id = ?", nativeQuery=true)
	public List<Application> findByApplicationId(int id);
}
