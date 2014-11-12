package com.crossp.jpa.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.crossp.jpa.domain.AppSpace;


@Service
public interface AppSpaceRepository extends CrudRepository<AppSpace, Long> {
	

}
