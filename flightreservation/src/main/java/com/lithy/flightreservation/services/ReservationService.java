package com.lithy.flightreservation.services;

import com.lithy.flightreservation.dto.ReservationRequest;
import com.lithy.flightreservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);
}
