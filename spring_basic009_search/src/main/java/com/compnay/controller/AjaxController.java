package com.compnay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.dto.SboardDto;
import com.compnay.service.SboardService;

@Controller
@RequestMapping("/boardajax/*")
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	@Autowired
	private SboardService service;
	
	@RequestMapping( value="/searchBoard", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<SboardDto> board_list(@RequestParam("search") String search) throws Exception {
		logger.info(":::::::::::::::::::::::AJAX BOARD-GET-리스트");
		
		SboardDto dto = new SboardDto();
		dto.setBtitle(search);
		return service.searchSboard(dto);
	}
	
	
	
	
}
