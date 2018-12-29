package com.lithy.flightcheckin.integration;

import com.lithy.flightreservation.dto.ReservationUpdateRequest;
import com.lithy.flightreservation.entities.Reservation;

public interface ReservationRestClient {

	public Reservation findReservation(long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
}
