package com.lithy.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithy.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
