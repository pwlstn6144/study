package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.command.BCommand;
import com.study.spring.command.BContentCommand;
import com.study.spring.command.BDeleteCommand;
import com.study.spring.command.BListCommand;
import com.study.spring.command.BModifyCommand;
import com.study.spring.command.BReplyCommand;
import com.study.spring.command.BReplyViewCommand;
import com.study.spring.util.Constant;

@Controller
public class BController {
	
	@Autowired
	private ApplicationContext context;
	
	BCommand command = null;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
//		command = new BListCommand();
		command = (BListCommand)context.getBean("listHandler"); //형 변환 중요
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view");
		model.addAttribute("request", request);
//		command = new BContentCommand();
		command = (BContentCommand)context.getBean("contentHandler");
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify_view",method=RequestMethod.GET)
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("modify_view()");
		
		model.addAttribute("request", request);
//		command = new BContentCommand();
		command = (BContentCommand)context.getBean("contentHandler");
		command.execute(model);
		
		return "modify_view";
	}
	
	@RequestMapping(value="/modify.do",method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model)
	{
		System.out.println("modify");
		
		model.addAttribute("request", request);
//		command = new BModifyCommand();
		command = (BModifyCommand)context.getBean("modifyHandler");
		command.execute(model);
		
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
//		command = new BDeleteCommand();
		command = (BDeleteCommand)context.getBean("deleteHandler");
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
//		command = new BReplyViewCommand();
		command = (BReplyViewCommand)context.getBean("replyViewHandler");
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply.do")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
//		command = new BReplyCommand();
		command = (BReplyCommand)context.getBean("replyHandler");
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String Write_view(Model model) {
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String Write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
//		command = new BWriteCommand();
		command = (BCommand)context.getBean("writeHandler");
		command.execute(model);

		return "redirect:list";
	}
}
