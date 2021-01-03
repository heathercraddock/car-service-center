package com.heathercraddock.carservicecenter.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.heathercraddock.carservicecenter.domain.Appointment;
import com.heathercraddock.carservicecenter.service.AppointmentService;

@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService service;
	
	@GetMapping("/")
	public String viewIndex(Model model) {
		model.addAttribute("a", new Appointment());
		return(findPaginated(1, "dateCreated", "desc", model));
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
		@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;
		
		Page<Appointment> page = service.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Appointment> listAppointments = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    
	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    
	    model.addAttribute("listAppointments", listAppointments);
		return "index";
	}
	@GetMapping("pageByAppointment")
	public String findAppointmentById(@RequestParam("id") int id, Model model) {
		int pageNo = 1;
		String sortField = "customerName";
		String sortDir = "asc";
		
		Page<Appointment> page = service.findAppointmentAsPage(id);
		List<Appointment> listAppointments = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    
	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    
	    model.addAttribute("listAppointments", listAppointments);
		
		return "index";
		
	}
	
	// http://localhost:8082/pageByDate/1?sortField=price&sortDir=desc&startDate=2020-12-31&endDate=2021-01-02
	@GetMapping("/pageByDate/{pageNo}")
	public String findPaginatedByDate(@PathVariable(value="pageNo") int pageNo, 
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, 
			@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate, Model model) {
		int pageSize = 5;
		Page<Appointment> page = service.findPaginatedbyDate(pageNo, pageSize, sortField, sortDir, startDate, endDate);
		List<Appointment> listAppointments = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    
	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    
	    model.addAttribute("startDate", startDate);
	    model.addAttribute("endDate", endDate);
	    
	    model.addAttribute("listAppointments", listAppointments);
		
		return "index";
		
	}
	
	@GetMapping("addnew")
	public String addAppointment(Model model) {
		model.addAttribute("appt", new Appointment());
		return "addnew";
	}
	
	
	@RequestMapping("/cancel/{id}")
	public String cancelAppointment(@PathVariable(name="id") int id) {
		service.cancelAppt(id);
		return "redirect:/";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditAppointmentPage(@PathVariable(name="id") int id) {
		ModelAndView mv = new ModelAndView("addnew");
		Appointment appt = service.getAppt(id);
		//appt.toString();
		mv.addObject("appt", appt);
		return mv;
	}
	
	@RequestMapping("/complete/{id}")
	public String completeAppointment(@PathVariable(name="id") int id) {
		service.completeAppt(id);
		return "redirect:/";
	}
	
	// TODO: ADD INPUT VALIDATION THAT DOESN'T CRASH THE API
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveAppt(@ModelAttribute("appt") Appointment appt) {
		service.saveAppointment(appt);
		return "redirect:/";
	}
	

}
