package com.lithy.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithy.flightreservation.dto.ReservationUpdateRequest;
import com.lithy.flightreservation.entities.Reservation;
import com.lithy.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);


	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") long id) {
		LOGGER.info("inside findReservation()");

		// pathvariable to bind the method parameter to what comes from the url
		
		Reservation reservation = reservationRepository.findById(id).get();
		return reservation;
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("inside updateReservation()");

		//requestbody tells spring that this object will be filled with data that comes from request
		
		Reservation reservation = reservationRepository.findById(request.getId()).get();

		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		LOGGER.info("saving the reservation");
		return reservationRepository.save(reservation);
	}

}
