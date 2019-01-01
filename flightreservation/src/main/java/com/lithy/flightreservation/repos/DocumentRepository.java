package com.lithy.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithy.flightreservation.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
