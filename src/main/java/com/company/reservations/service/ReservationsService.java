package com.company.reservations.service;

import com.company.reservations.dto.ReservationDto;
import java.util.List;


public interface ReservationsService {

  List<ReservationDto> getReservations();
}
