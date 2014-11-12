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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossp.jdbc.service.AppJDBCService;
import com.crossp.jpa.domain.AppSpace;
import com.crossp.jpa.service.AppRepository;
import com.crossp.jpa.service.AppSpaceRepository;

@Controller
@RequestMapping(value="/setting/app/space")
public class AppSpaceRestController {
	
	@Autowired
	private AppRepository appRepository;
	@Autowired
	private AppJDBCService appJDBCService;
	@Autowired
	private AppSpaceRepository appSpaceRepository;
			
	@RequestMapping(value="/{id}")
	public @ResponseBody Iterable<AppSpace> fetchAppSpaces(@PathVariable("id") int id) {
		return appSpaceRepository.findAll();
	}
		
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody void add(@RequestBody AppSpace appSpace) {
		appSpaceRepository.save(appSpace);
	}
}