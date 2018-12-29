package com.lithy.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lithy.flightreservation.dto.ReservationRequest;
import com.lithy.flightreservation.entities.Flight;
import com.lithy.flightreservation.entities.Passenger;
import com.lithy.flightreservation.entities.Reservation;
import com.lithy.flightreservation.repos.FlightRepository;
import com.lithy.flightreservation.repos.PassengerRepository;
import com.lithy.flightreservation.repos.ReservationRepository;
import com.lithy.flightreservation.util.EmailUtil;
import com.lithy.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.lithy.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("inside bookFlight()");

		// make payment
		// request.getCardNumber();

		long flightId = request.getFlightId();

		LOGGER.info("Fetching Flight for flight id + " + flightId);
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());

		LOGGER.info("saving the passenger");
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		LOGGER.info("saving the reservation");
		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";

		LOGGER.info("generating the itinerary");
		pdfGenerator.generateItinerary(reservation, filePath);

//		LOGGER.info("sending the itinerary mail");
//		emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}

}
