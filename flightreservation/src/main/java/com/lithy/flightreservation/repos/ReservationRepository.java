package com.lithy.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithy.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
