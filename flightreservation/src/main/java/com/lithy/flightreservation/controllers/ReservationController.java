package com.lithy.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lithy.flightreservation.dto.ReservationRequest;
import com.lithy.flightreservation.entities.Flight;
import com.lithy.flightreservation.entities.Reservation;
import com.lithy.flightreservation.repos.FlightRepository;
import com.lithy.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){
		LOGGER.info("inside showCompleteReservation()");

		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		
		LOGGER.info("Flight is "+ flight);

		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("inside completeReservation()");

		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully with id " + reservation.getId());
		return "reservationConfirmation";
	}
}
