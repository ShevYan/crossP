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

package com.crossp.web.controller.pull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crossp.beans.DeliveredSpace;
import com.crossp.jdbc.service.AppJDBCService;
import com.crossp.jpa.domain.App;
import com.crossp.jpa.domain.User;
import com.crossp.jpa.service.AppItemAreaRepository;
import com.crossp.jpa.service.AppItemRepository;
import com.crossp.jpa.service.AppMessageRepository;
import com.crossp.jpa.service.AppRepository;

@Controller
@RequestMapping(value = "/pull")
@SessionAttributes("user")
public class AppCpSpacePullController {

	private Logger logger = LoggerFactory.getLogger(getClass());  
	@Autowired
	private AppMessageRepository appMessageRepository;
	@Autowired
	private AppRepository appRepository;
	@Autowired
	private AppItemAreaRepository appItemAreaRepository;
	@Autowired
	private AppItemRepository appItemRepository;
	@Autowired
	private AppJDBCService appJDBCService;

	
	@RequestMapping(value = "/space")
	public @ResponseBody DeliveredSpace getSpace(@RequestHeader("token") String token) {
		DeliveredSpace space = new DeliveredSpace();
		logger.info("Pull template with token : {}", token);
		App app = appRepository.findByToken(java.util.UUID.fromString(token));
		//app.getAppSpaces().get(0).getAppTemplate().getItemAreas().get(0).getAppItem() ! = null;
		space.setAppId(app.getAppId());
		return space;
	}

}
