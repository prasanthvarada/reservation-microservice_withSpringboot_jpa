package com.example.springboot.reservation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface ReservationRepository extends CrudRepository<Reservation,Long>  {

/*	List<Reservation> findAll();

	Reservation findOne(Long id);*/
	
		
}
