package com.hbs.service;

import org.springframework.ui.Model;

import com.hbs.domain.Hotel;
import com.hbs.domain.Room;

public interface HbsService {

	String addBooking(Room room);

	String showAllOccupied(Model model);

	String showAvailableRooms(Model model);

	String showUpdateForm(Long id, Model model);

	String makeHotel(Hotel hotel);

	String deleteBooking(Long id, Model model);

	String showAll(Model model);
}