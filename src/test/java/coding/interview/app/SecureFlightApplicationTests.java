package coding.interview.app;

import coding.interview.app.entities.Flight;
import coding.interview.app.repositories.PassengerRepository;
import coding.interview.app.services.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SecureFlightApplicationTests {

	@Autowired
	FlightService flightService;
	@Autowired
	PassengerRepository passengerRepository;


	@Test
	void testInsertPassenger() {
		var passenger = passengerRepository.findById(1L);

		var flight = new Flight(7L,"TRX", "GRU", "POA", "confirmed", List.of(passenger.get()));
		var result = flightService.save(flight);

		Assertions.assertNotNull(result);


		flightService.findById(7L).ifPresent(flight1 -> {
			System.out.println(flight1);
		});
	}

}
