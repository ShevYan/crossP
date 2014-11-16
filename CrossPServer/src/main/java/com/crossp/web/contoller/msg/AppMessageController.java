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

package com.crossp.web.contoller.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossp.jpa.domain.AppMessage;
import com.crossp.jpa.service.AppMessageRepository;

@Controller
@RequestMapping(value = "/msg")
public class AppMessageController {

	@Autowired
	private AppMessageRepository appMessageRepository;

	@RequestMapping(value = "/all")
	public @ResponseBody Iterable<AppMessage> findAll() {
		return appMessageRepository.findAll();
	}
	
	@RequestMapping(value = "/send", method=RequestMethod.POST)
	public @ResponseBody void save(@RequestBody AppMessage appMessage) {
		appMessageRepository.save(appMessage);
	}
	

	@RequestMapping(value = "/{areaId}/{itemId}", method=RequestMethod.POST)
	public @ResponseBody Iterable<AppMessage> send(@PathVariable("areaId") Long areaId,
			@PathVariable("itemId") Long itemId) {
		return appMessageRepository.findByPid(itemId);
	}
	
	@RequestMapping(value = "/read/{uid}", method=RequestMethod.POST)
	public @ResponseBody void read(@PathVariable("uid") Long uid) {
	}
	

	@RequestMapping(value = "/send/{uid}/all")
	public @ResponseBody Iterable<AppMessage> findAllUserSend(@PathVariable("uid") Long uid) {
		return appMessageRepository.findByPid(uid);
	}

	@RequestMapping(value = "/rec/{uid}/all")
	public @ResponseBody Iterable<AppMessage> findAllUserReceive(@PathVariable("uid") Long uid) {
		return appMessageRepository.findByCid(uid);
	}

}
