package com.example.springboot.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/v1")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	// ------------ Retrieve all reservations ------------
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public @ResponseBody List getAllReservations() {
	//public ResponseEntity<List> getAllReservations() {
		
		return reservationService.getAllReservations();
		//List list = reservationService.getAllReservations();
		//return new ResponseEntity<List>(list, HttpStatus.OK);
	}
	
	// ------------ Retrieve a reservation ------------
	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.GET)
	public Reservation getReservation(@PathVariable String id) {
		return reservationService.getReservation(Long.parseLong(id));
	}
	
	// ------------ Create a reservation ------------
	@RequestMapping(value = "/reservations", method = RequestMethod.POST)
	public void addReservation(@RequestBody Reservation reservation) {
		reservationService.addReservation(reservation);
		
	}
	
	// ------------ Update a reservation ------------
	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.PUT)
	public void updateReservation(@RequestBody Reservation reservation,@PathVariable String id) {
		reservationService.updateReservation(Long.parseLong(id), reservation);
	}
	
	// ------------ Delete a reservation ------------
	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.DELETE)
	public void deleteReservation(@PathVariable String id) {
		reservationService.deleteReservation(Long.parseLong(id));
	}
}