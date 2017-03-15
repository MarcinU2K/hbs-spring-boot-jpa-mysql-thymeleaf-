package com.hbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hbs.domain.Hotel;
import com.hbs.domain.Room;
import com.hbs.domain.RoomState;
import com.hbs.repository.HbsRepository;

@Service
public class HbsServiceImpl implements HbsService {

	@Autowired
	private HbsRepository hbsRepository;

	@Override
	public String addBooking(Room room) {
		Room currentRoomStatus = hbsRepository.findById(room.getId());
		if(currentRoomStatus.getRoomState().equals(RoomState.AVAILABLE)){
		room.setRoomState(RoomState.OCCUPIED);
		hbsRepository.save(room);
		return "index";
		} else {
			return "unavailable";
		}		
	}

	@Override
	public String showAllOccupied(Model model) {
		List<Room> allBookings = hbsRepository.findByRoomState(RoomState.OCCUPIED);
		model.addAttribute("bookings", allBookings);
		return "show-all-bookings";
	}

	@Override
	public String showAvailableRooms(Model model) {
		List<Room> allRoomsAvailable = hbsRepository.findByRoomState(RoomState.AVAILABLE);
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
		if(room.getRoomState().equals(RoomState.OCCUPIED)){
			room.setRoomState(RoomState.AVAILABLE);
			room.setGuestName(null);
			room.setGuestSurname(null);
			hbsRepository.save(room);
			return "delete";
		}else{
			return "not-occupied-exception";
		}
	}

	@Override
	public String makeHotel(Hotel hotel) {
		try {
			for (int i = 0; i <= hotel.getFloor() - 1; i++) {
				for (int j = 1; j <= hotel.getRoom(); j++) {
					Room room = new Room(i, null, null, RoomState.AVAILABLE);
					hbsRepository.save(room);
				}
			}
		} catch (Exception e) {
			return e.toString();
		}
		return "index";
	}

	@Override
	public String showAll(Model model) {
		Iterable<Room> allRooms = hbsRepository.findAll();
		model.addAttribute("bookings", allRooms);
		return "show-all-bookings";
	}
}
