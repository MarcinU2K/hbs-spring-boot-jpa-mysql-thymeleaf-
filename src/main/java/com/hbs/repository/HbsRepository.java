package com.hbs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hbs.domain.Room;
import com.hbs.domain.RoomState;

@Repository
@Transactional
public interface HbsRepository extends CrudRepository<Room, Long> {

	Room findById(Long id);

	List<Room> findByRoomState(RoomState available);

}
