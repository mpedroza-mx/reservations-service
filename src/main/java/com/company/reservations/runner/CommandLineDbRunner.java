package com.company.reservations.runner;

import com.company.reservations.model.ReservationModel;
import com.company.reservations.repository.ReservationsRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CommandLineDbRunner implements CommandLineRunner {

  private final ReservationsRepository repository;

  @Override
  public void run(String... args) throws Exception {
    int counter = 0;
    if (log.isInfoEnabled()){
      log.info("Populating Database");
    }
    while (counter <= 5) {

      repository.save(ReservationModel.builder()
          .name("Reservation No. "+counter)
          .time(LocalDateTime.now().plusDays(counter)).build()
      );
      counter++;
    }
    if (log.isInfoEnabled()){
      log.info("Number of reservation created: {}",counter);
    }

  }
}
