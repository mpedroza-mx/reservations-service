package com.company.reservations.controller;

import com.company.reservations.dto.ReservationDto;
import com.company.reservations.service.ReservationsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "reservations")
@RequiredArgsConstructor
public class ReservationsController {

  private final ReservationsService service;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ReservationDto> getReservations(){
    List<ReservationDto> reservationDtos = service.getReservations();
    return reservationDtos;
  }
}
