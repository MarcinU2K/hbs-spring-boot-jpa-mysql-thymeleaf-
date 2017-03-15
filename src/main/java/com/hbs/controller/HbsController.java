package com.hbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbs.domain.Hotel;
import com.hbs.domain.Room;
import com.hbs.service.HbsService;

@Controller
@RequestMapping("/hbs")
public class HbsController {

	@Autowired
	private HbsService hbsService;

	@RequestMapping("/")
	public String startPage(){
		return "index";
	}

	@RequestMapping(value = "/showBookingForm", method = RequestMethod.GET)
	public String showFormForAdd(Model model) {
		model.addAttribute("room", new Room());
		return "booking-form";
	}
	
	@RequestMapping(value = "/showHotelSetupForm", method = RequestMethod.GET)
	public String showFormForHotelSetup(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "hotel-setup-form";
	}
	
	@RequestMapping(value = "/makehotel", method = RequestMethod.POST)
	public String makeHotel(@ModelAttribute Hotel hotel) {
		return hbsService.makeHotel(hotel);
	}

	@RequestMapping(value = "/showUpdateForm/{id}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Long id, Model model){
		return hbsService.showUpdateForm(id, model);
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public String addBooking(@ModelAttribute Room room) {
		return hbsService.addBooking(room);
	}

	@RequestMapping(value = "/deleteBooking/{id}", method = RequestMethod.GET)
	public String deleteBooking(@PathVariable("id") Long id, Model model){
		return hbsService.deleteBooking(id, model);
	}

	@RequestMapping("/showall")
	public String showAll(Model model) {
		return hbsService.showAll(model);
	}

	@RequestMapping("/showalloccupied")
	public String showAllOccupied(Model model) {
		return hbsService.showAllOccupied(model);
	}
	

	@RequestMapping("/showavailable")
	public String showAvailableRooms(Model model) {
		return hbsService.showAvailableRooms(model);
	}
}
