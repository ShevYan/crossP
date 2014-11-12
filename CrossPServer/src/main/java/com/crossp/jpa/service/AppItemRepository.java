package com.crossp.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.crossp.jpa.domain.App;
import com.crossp.jpa.domain.User;


@Service
public interface AppItemRepository extends CrudRepository<App, Long> {

	public List<App> findByUser(User user);
	
	@Query(value = "select * from application c where c.id in "
			+ "(select b.applications_id from application a, application_application b where a.id=b.application_id and a.id = ?)", nativeQuery=true)
	public List<App> findByApplicationId(int id);
	
	@Query(value = "select * from application c where c.id not in "
			+ "(select b.applications_id from application a, application_application b where a.id=b.application_id and a.id = ?);", nativeQuery=true)
	public List<App> findUnJoinByApplicationId(int id);

}
