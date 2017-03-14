package com.hbs.service;

import org.springframework.ui.Model;

import com.hbs.domain.Room;

public interface HbsService {

	String addBooking(Room room);

	String showAllBooked(Model model);

	String showAvailableRooms(Model model);

	String showUpdateForm(Long id, Model model);

	String makeHotel(int rooms, int floors);

	String deleteBooking(Long id, Model model);
}