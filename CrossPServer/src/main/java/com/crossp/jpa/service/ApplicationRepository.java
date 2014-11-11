package com.crossp.jpa.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.crossp.jpa.domain.Application;
import com.crossp.jpa.domain.User;


@Service
public interface ApplicationRepository extends CrudRepository<Application, Long> {

	public List<Application> findByUser(User user);
}
