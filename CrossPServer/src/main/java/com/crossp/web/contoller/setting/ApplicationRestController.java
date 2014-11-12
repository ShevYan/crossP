/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.crossp.web.contoller.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossp.jdbc.service.ApplicationJDBCService;
import com.crossp.jpa.domain.Application;
import com.crossp.jpa.domain.User;
import com.crossp.jpa.service.ApplicationRepository;
import com.crossp.jpa.service.UserRepository;

@Controller
@RequestMapping(value="/setting/app")
public class ApplicationRestController {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	@Autowired
	private ApplicationJDBCService applicationJDBC;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/all")
	public @ResponseBody Iterable<Application> findAll() {
		return applicationRepository.findAll();
	}
	
	@RequestMapping(value="/user")
	public @ResponseBody Iterable<Application> findUserALLApps() {
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userRepository.findByUsername(principal.getUsername());
		return applicationRepository.findByUser(user);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody void add(@RequestBody Application app) {
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//@SessionAttributes instead of it, store it from login
		User user = userRepository.findByUsername(principal.getUsername());
		app.setUser(user);
		applicationRepository.save(app);
	}
	
	@RequestMapping(value="/cp/{id}")
	public @ResponseBody Iterable<Application> findALLCPApps(@PathVariable("id") int id) {
		return applicationRepository.findByApplicationId(id);
	}
	
	@RequestMapping(value="/cp/unjoin/{id}")
	public @ResponseBody Iterable<Application> findUnJoinCPApps(@PathVariable("id") int id) {
		return applicationRepository.findUnJoinByApplicationId(id);
	}
	@RequestMapping(value="/cp/{wid}/{rid}", method=RequestMethod.POST)
	public @ResponseBody void joinCP(@PathVariable("wid") int wid, @PathVariable("rid") int rid) {
		applicationJDBC.joinCP(wid, rid);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public @ResponseBody void removeApp(@PathVariable("id") Long id) {
		applicationRepository.delete(id);
	}
	
	@RequestMapping(value="/cp/{wid}/{rid}", method=RequestMethod.DELETE)
	public @ResponseBody void breakCP(@PathVariable("wid") int wid, @PathVariable("rid") int rid) {
		applicationJDBC.breakCP(wid, rid);
	}
		
}
