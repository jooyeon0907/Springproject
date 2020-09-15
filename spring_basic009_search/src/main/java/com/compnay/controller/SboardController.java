package com.compnay.controller;

import java.io.File;
import java.net.InetAddress;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.dto.SboardDto;
import com.compnay.service.SboardService;

@Controller
@RequestMapping("/board/*")
public class SboardController {

	private static final Logger logger = LoggerFactory.getLogger(SboardController.class);
	@Autowired
	private SboardService service;
	
//	@RequestMapping( value="/index", method=RequestMethod.GET)
//	public String index() {return "../../index";}
	//리스트 get,post -> 글리스트가져오기

/*	
	@RequestMapping( value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list_get(Model model) throws Exception {
		logger.info(":::::::::::::::::::::::리스트보기");
		return "/board/list";
	}
	
	//글입력폼 get -> 글쓰기 폼 위치
	@RequestMapping(value="/board_write", method= RequestMethod.GET)
	public String write_form() {
		logger.info(":::::::::::::::::::입력폼");
		return "/board/board_write";
	}
	
	
	//글입력 post 
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String write () throws Exception {
		logger.info("::::::::::::::::: 글입력 기능");
		return "/board/list";
	}
	
	
	//상세보기 get
	@RequestMapping(value ="/board_detail", method= RequestMethod.GET)
	public String detail() throws Exception {
		logger.info("::::::::::::::::글 상세보기");
		return "/board/board_detail";
	}
	
	
	//수정하기 폼 get
	@RequestMapping( value ="/board_modify" , method=RequestMethod.GET)
	public String edit_form() throws Exception {
		logger.info(":::::::::::::::::::::: 수정하기폼");
		return "/board/board_modify";
	}
	
	
	//수정하기  기능 post
	@RequestMapping( value ="/board_modify" , method=RequestMethod.POST)
	public String edit() throws Exception {
		logger.info(":::::::::::::::::::::: 수정하기기능");
		return "/board/list";
	}
	
	
	
	
	//삭제하기폼 get
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public String delete_form() throws Exception {
		logger.info("::::::::::::::::글 삭제하기 폼");
		return "/board/board_delete";
	}
	
	
	//삭제하기 기능 post
	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
	public String delete() throws Exception {
		logger.info("::::::::::::::::글 삭제하기 기능");
		return "/board/list";
	}
	*/
	

	//리스트 get,post -> 글리스트가져오기
	@RequestMapping( value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public void list_get(Model model) throws Exception {
		logger.info(":::::::::::::::::::::::리스트보기");
		model.addAttribute("list", service.selectSboardAll());
	}
	
	//글입력폼 get -> 글쓰기 폼 위치
	@RequestMapping(value="/board_write", method= RequestMethod.GET)
	public void write_form() {
		logger.info(":::::::::::::::::::글쓰기 폼");
	}
	
	
	//글입력 post 
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String write (MultipartFile file, HttpServletRequest request,SboardDto dto, RedirectAttributes rttr) throws Exception {
		logger.info("::::::::::::::::: 글입력 기능");	
		String result = "ok";
		if(service.insertSboard(file, dto, request) != 1 ) {result ="not ok";}
		rttr.addFlashAttribute("isnert", result);
		
		return "redirect:/board/list";
	}
	
	
	//상세보기 get
	@RequestMapping(value ="/board_detail", method= RequestMethod.GET)
	public void detail( @RequestParam("bno") int bno, Model model) throws Exception {
		logger.info("::::::::::::::::글 상세보기");
		SboardDto dto = new SboardDto();
		dto.setBno(bno);
		service.updateSboardBhit(dto); //조회수 올리기 
		model.addAttribute("sboardDto", service.selectSboard(dto));
	}
	
	
	//수정하기 폼 get
	@RequestMapping( value ="/board_modify" , method=RequestMethod.GET)
	public void edit_form(SboardDto dto, Model model) throws Exception {
		logger.info(":::::::::::::::::::::: 수정하기폼");
		model.addAttribute(service.selectSboard(dto));
	}
	
//	@RequestMapping( value ="/board_modify" , method=RequestMethod.GET)
//	public String edit_form(@RequestParam("bno") int bno, Model model, RedirectAttributes rttr) throws Exception {
//		logger.info(":::::::::::::::::::::: 수정하기폼");
//		SboardDto dto = new SboardDto();
//		dto.setBno(bno);
//		model.addAttribute(service.selectSboard(dto));
//		return "redirect:/board/board_modify";
//	}
	
	
	//수정하기  기능 post
	@RequestMapping( value ="/board_modify" , method=RequestMethod.POST)
	public String edit(SboardDto dto, RedirectAttributes rtt, @RequestParam("bno") int bno) throws Exception {
		logger.info(":::::::::::::::::::::: 수정하기기능");
		String result = "ok";
		if(service.updateSboard(dto) != 1 ) {result = "not ok";}
		rtt.addFlashAttribute("update",result);
		return "redirect:/board/board_modify?bno="+bno;
	}
	
	
	
	
	//삭제하기폼 get
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public void delete_form(@RequestParam("bno") int bno, Model model) throws Exception {
		logger.info("::::::::::::::::글 삭제하기 폼");
		SboardDto dto = new SboardDto();
		dto.setBno(bno);
		model.addAttribute(service.selectSboard(dto));
	}
	
	
	//삭제하기 기능 post  //@RequestParam("bno") int bno, @RequestParam("bpass") int bpass
	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno, SboardDto dto,
						 RedirectAttributes rttr) throws Exception {
		logger.info("::::::::::::::::글 삭제하기 기능");
		dto.setBno(bno);
		String result = "ok";
		if(service.deleteSboard(dto) != 1 ) {result = "not ok";}
		rttr.addFlashAttribute("delete",result);
		return "redirect:/board/list";
	}
	

	
	
	
	
	
	
}
