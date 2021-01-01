package com.heathercraddock.carservicecenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.heathercraddock.carservicecenter.domain.Appointment;
import com.heathercraddock.carservicecenter.service.AppointmentService;

@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService service;
	
	@GetMapping("/")
	public String viewIndex(Model model) {
		List<Appointment> allAppts = service.listAllAppointments();
		model.addAttribute("allAppts", allAppts);
		System.out.println("Displaying all appointments.");
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
		appt.toString();
		mv.addObject("appt", appt);
		return mv;
	}
	
	@RequestMapping("/complete/{id}")
	public String completeAppointment(@PathVariable(name="id") int id) {
		service.completeAppt(id);
		return "redirect:/";
	}
	
	/*
	 * 
	 * public ModelAndView showEditStudentPage(@PathVariable(name="id") int id) {
		ModelAndView mv = new ModelAndView("new");
		Student student = service.getStudent(id);
		mv.addObject("student", student);
		return mv;
	}
	 */
	
	// TODO: ADD INPUT VALIDATION THAT DOESN'T CRASH THE API
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveAppt(@ModelAttribute("appt") Appointment appt) {
		service.saveAppointment(appt);
		return "redirect:/";
	}
	
	/*
	 * @RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.save(student);
		return "redirect:/";
	}
	 * 
	 */

}
