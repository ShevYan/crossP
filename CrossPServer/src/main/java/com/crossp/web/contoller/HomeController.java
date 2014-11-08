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

package com.crossp.web.contoller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.crossp.jpa.domain.Authority;
import com.crossp.jpa.domain.User;
import com.crossp.jpa.service.AuthorityRepository;
import com.crossp.jpa.service.UserRepository;

@Controller
public class HomeController {

	private Log logger = LogFactory.getLog(HomeController.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@RequestMapping("/")
	public String home() throws Exception {
		return "home";
	}
		
	@RequestMapping("/hello")
	public String hello() throws Exception {
		return "hello";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		Authority auth = new Authority();
		auth.setUsername(user.getUsername());
		auth.setAuthority("ROLE_USER");
		logger.info(user);
		userRepository.save(user);
		authorityRepository.save(auth);
		return "home";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String tryLogin() {
		return "access";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping(value="/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping(value="/forbidden")
	public String forbidden() {
		return "403";
	}
	
//	
//	@ExceptionHandler(Exception.class)  
//    public String runtimeExceptionHandler(Exception runtimeException) {  
//       return "exception";
//    }  
}
