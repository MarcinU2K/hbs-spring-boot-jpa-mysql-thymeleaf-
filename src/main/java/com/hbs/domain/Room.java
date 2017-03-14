package com.hbs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int floor;
	
	private String guestName;
	
	private String guestSurname;
	
	private boolean available;

	public Room() {
	}

	public Room(Long id, String guestName, String guestSurname, boolean available) {
		this.id = id;
		this.guestName = guestName;
		this.guestSurname = guestSurname;
		this.available = available;
	}
	
	public Room(int floor, String guestName, String guestSurname, boolean available) {
		super();
		this.floor = floor;
		this.guestName = guestName;
		this.guestSurname = guestSurname;
		this.available = available;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
