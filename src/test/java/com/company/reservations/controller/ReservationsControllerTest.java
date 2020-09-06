package com.company.reservations.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.company.reservations.dto.ReservationDto;
import com.company.reservations.service.ReservationsService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ReservationsController.class)
public class ReservationsControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ReservationsService service;


  @Test
  public void shouldReturnReservationsDtosList() throws Exception {
    List<ReservationDto> reservations = Stream.of(ReservationDto.builder()
        .id(1)
        .name("Test Reservation")
        .time( LocalDateTime.now()).build()
    ).collect(Collectors.toList());
    when(service.getReservations())
        .thenReturn(reservations);
    mockMvc.perform(get("/reservations").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }
}
