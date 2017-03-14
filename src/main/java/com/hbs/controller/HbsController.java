package com.hbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbs.domain.Room;
import com.hbs.service.HbsService;

@Controller
@RequestMapping("/hbs")
public class HbsController {

	@Autowired
	private HbsService hbsService;

	@RequestMapping("/makehotel")
	public String makeHotel(int rooms, int floors) {
		return hbsService.makeHotel(rooms, floors);
	}

	@RequestMapping("/")
	public String startPage() {
		return "index";
	}

	@RequestMapping(value = "/showBookingForm", method = RequestMethod.GET)
	public String showFormForAdd(Model model) {
		model.addAttribute("room", new Room());
		return "booking-form";
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public String addBooking(@ModelAttribute Room room) {
		return hbsService.addBooking(room);
	}

	@RequestMapping("/showall")
	public String showAllBooked(Model model) {
		return hbsService.showAllBooked(model);
	}

	@RequestMapping("/showavailable")
	public String showAvailableRooms(Model model) {
		return hbsService.showAvailableRooms(model);
	}
	
	@RequestMapping(value = "/showUpdateForm/{id}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Long id, Model model){
		return hbsService.showUpdateForm(id, model);
	}
	
	@RequestMapping(value = "/deleteBooking/{id}", method = RequestMethod.GET)
	public String deleteBooking(@PathVariable("id") Long id, Model model){
		return hbsService.deleteBooking(id, model);
	}
}
