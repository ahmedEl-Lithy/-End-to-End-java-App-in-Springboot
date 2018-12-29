package com.lithy.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lithy.flightreservation.dto.ReservationUpdateRequest;
import com.lithy.flightreservation.entities.Reservation;

@Component
public class ReservationRestClientImpl implements ReservationRestClient{

	private static final String RESERVSATION_REST_URL = "http://localhost:8081/flightreservation/reservations/";

	@Override
	public Reservation findReservation(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVSATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVSATION_REST_URL, request, Reservation.class);
		return reservation;
	}

}
