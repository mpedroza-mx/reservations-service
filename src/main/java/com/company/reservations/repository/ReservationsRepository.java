package com.company.reservations.repository;

import com.company.reservations.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<ReservationModel, Integer> {

}
