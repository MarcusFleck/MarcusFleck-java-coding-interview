package coding.interview.app.services;

import coding.interview.app.entities.Flight;
import coding.interview.app.repositories.FlightRepository;
import coding.interview.app.requests.UpdateFlightRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    public Optional<Flight> update(Long id, UpdateFlightRequest updateFlightRequest) {
        return flightRepository.findById(id)
                .map(flight -> new Flight(flight.getId(), updateFlightRequest.code(), updateFlightRequest.origin(), updateFlightRequest.destination(), updateFlightRequest.status()))
                .map(flightRepository::save);
    }

    public Flight save(Flight flight) {
        return flight;
    }
}
