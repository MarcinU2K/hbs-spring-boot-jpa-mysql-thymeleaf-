package com.hbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hbs.domain.Room;
import com.hbs.repository.HbsRepository;

@Service
public class HbsServiceImpl implements HbsService {

	@Autowired
	private HbsRepository hbsRepository;

	@Override
	public String addBooking(Room room) {
		Room currentRoomStatus = hbsRepository.findById(room.getId());
		if(currentRoomStatus.isAvailable() != false){
		room.setAvailable(false);
		hbsRepository.save(room);
		return "index";
		} else {
			return "unavailable";
		}		
	}

	@Override
	public String showAllBooked(Model model) {
		List<Room> allBookings = hbsRepository.findByAvailable(false);
		model.addAttribute("bookings", allBookings);
		return "show-all-bookings";
	}

	@Override
	public String showAvailableRooms(Model model) {
		List<Room> allRoomsAvailable = hbsRepository.findByAvailable(true);
		model.addAttribute("bookings", allRoomsAvailable);
		return "show-all-bookings";
	}

	@Override
	public String showUpdateForm(Long id, Model model) {
		Room room = hbsRepository.findById(id);
		model.addAttribute("room", room);
		return "update-form";
	}
	
	@Override
	public String deleteBooking(Long id, Model model) {
		Room room = hbsRepository.findById(id);
		room.setAvailable(true);
		room.setGuestName(null);
		room.setGuestSurname(null);
		hbsRepository.save(room);
		return "delete";
	}

	@Override
	public String makeHotel(int rooms, int floors) {
		try {
			for (int i = 0; i <= floors - 1; i++) {
				for (int j = 1; j <= rooms / floors; j++) {
					Room room = new Room(i, null, null, true);
					hbsRepository.save(room);
				}
			}
		} catch (Exception e) {
			return e.toString();
		}
		return "index";
	}
}
