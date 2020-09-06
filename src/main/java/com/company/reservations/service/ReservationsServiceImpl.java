package com.company.reservations.service;

import com.company.reservations.dto.ReservationDto;
import com.company.reservations.model.ReservationModel;
import com.company.reservations.repository.ReservationsRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationsServiceImpl implements ReservationsService{

  private final ReservationsRepository repository;

  @Override
  public List<ReservationDto> getReservations() {
    List<ReservationDto> reservationDtos = repository.findAll()
        .stream()
        .map(this::fromReservationModelToDto)
        .collect(Collectors.toList());
    return reservationDtos;

  }

  private ReservationDto fromReservationModelToDto(ReservationModel model){
    ReservationDto dto = ReservationDto.builder()
        .id(model.getId())
        .name(model.getName())
        .time(model.getTime()).build();

    return dto;
  }
}
