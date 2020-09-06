package com.company.reservations.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.company.reservations.model.ReservationModel;
import com.company.reservations.repository.ReservationsRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ReservationsServiceImplTest {
  @MockBean
  private ReservationsRepository repository;

  private ReservationsService service;

  @BeforeEach
  protected void init(){
    service = new ReservationsServiceImpl(repository);
  }

  @Test
  protected void shouldReturnReservationsModelsList() throws Exception {
    List<ReservationModel> reservations = Stream.of(ReservationModel.builder()
        .id(1)
        .name("Test Reservation")
        .time( LocalDateTime.now()).build()
    ).collect(Collectors.toList());
    when(repository.findAll())
        .thenReturn(reservations);
    assertThat(!service.getReservations().isEmpty());
  }

}
