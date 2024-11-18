package com.abdullahaslan.midterm.service;

import com.abdullahaslan.midterm.entity.Flight;
import com.abdullahaslan.midterm.entity.FlightDates;
import com.abdullahaslan.midterm.repository.FlightDatesRepository;
import com.abdullahaslan.midterm.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private final int DATA_PER_PAGE = 20;

    FlightRepository flightRepository;
    FlightDatesRepository flightDatesRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, FlightDatesRepository flightDatesRepository) {
        this.flightRepository = flightRepository;
        this.flightDatesRepository = flightDatesRepository;
    }

    public void insertFlight(Flight flight, List<Date> availableDates) {
        flight.setId(0);
        flight.setId(flightRepository.insert(flight));

        for (Date date: availableDates){
            FlightDates flightDates = new FlightDates(flight.getId(), date, 0);
            flightDatesRepository.insert(flightDates);
        }
    }

    public List<Flight> getFlights(String from, String to, int capacity, List<Date> dates, int page) {
        List<Flight> flights = new ArrayList<>();

        for(Date date: dates) {
            List<Flight> flightsForADate = flightRepository.getAll(from, to);
            if (flightsForADate.isEmpty()) continue;
            flights.addAll(flightsForADate);
        }

        if (flights.isEmpty()) return flights;

        int availablePageNum = flights.size() / DATA_PER_PAGE;

        if (page >= availablePageNum)
        {
            page = ((availablePageNum > 0) ? (availablePageNum - 1) : 0);
            return flights.subList(page*DATA_PER_PAGE, flights.size());
        }
        return flights.subList(page*DATA_PER_PAGE, (page+1)*DATA_PER_PAGE);
    }

    public List<Flight> getAvailableFlights(String from, String to, Date date, int page) {
        List<Flight> availableFlights = new ArrayList<>();
        List<Flight> flights = flightRepository.getAll(from, to);

        for (Flight f: flights) {
            FlightDates fd = flightDatesRepository.get(f.getId(), date);
            if (fd.getBseat() < f.getSeat()) availableFlights.add(f);
        }

        if (availableFlights.isEmpty()) return availableFlights;

        int availablePageNum = flights.size() / DATA_PER_PAGE;

        if (page >= availablePageNum)
        {
            page = ((availablePageNum > 0) ? (availablePageNum - 1) : 0);
            return availableFlights.subList(page*DATA_PER_PAGE, availableFlights.size());
        }
        return availableFlights.subList(page*DATA_PER_PAGE, (page+1)*DATA_PER_PAGE);
    }

    public boolean doesFlightExists(String from, String to, Date date) {
        List<Flight> flights = flightRepository.getAll(from, to);
        for(Flight f: flights) {
            FlightDates fd = flightDatesRepository.get(f.getId(), date);
            if (fd != null) return true;
        }
        return false;
    }
}
