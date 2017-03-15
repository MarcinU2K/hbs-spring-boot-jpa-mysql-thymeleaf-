package com.hbs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Valid
    @NotNull
	private int floor;
	
	private String guestName;
	
	private String guestSurname;
	
	@Valid
    @NotNull
	private RoomState roomState;

	public Room() {
	}
	
	public Room(Long id, String guestName, String guestSurname, RoomState roomState) {
		super();
		this.id = id;
		this.guestName = guestName;
		this.guestSurname = guestSurname;
		this.roomState = roomState;
	}

	public Room(int floor, String guestName, String guestSurname, RoomState roomState) {
		super();
		this.floor = floor;
		this.guestName = guestName;
		this.guestSurname = guestSurname;
		this.roomState = roomState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestSurname() {
		return guestSurname;
	}

	public void setGuestSurname(String guestSurname) {
		this.guestSurname = guestSurname;
	}

	public RoomState getRoomState() {
		return roomState;
	}

	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}

}
