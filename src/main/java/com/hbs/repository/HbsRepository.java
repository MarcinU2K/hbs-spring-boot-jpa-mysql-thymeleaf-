package com.hbs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hbs.domain.Room;

@Repository
@Transactional
public interface HbsRepository extends CrudRepository<Room, Long> {

	List<Room> findByAvailable(boolean b);

	Room findById(Long id);

}
