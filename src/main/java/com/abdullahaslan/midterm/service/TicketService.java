package com.abdullahaslan.midterm.service;

import com.abdullahaslan.midterm.entity.Flight;
import com.abdullahaslan.midterm.entity.FlightDates;
import com.abdullahaslan.midterm.entity.Passenger;
import com.abdullahaslan.midterm.entity.Ticket;
import com.abdullahaslan.midterm.repository.FlightDatesRepository;
import com.abdullahaslan.midterm.repository.FlightRepository;
import com.abdullahaslan.midterm.repository.PassengerRepository;
import com.abdullahaslan.midterm.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TicketService {

    TicketRepository ticketRepository;
    PassengerRepository passengerRepository;
    FlightRepository flightRepository;
    FlightDatesRepository flightDatesRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, PassengerRepository passengerRepository,
                         FlightRepository flightRepository, FlightDatesRepository flightDatesRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
        this.flightDatesRepository = flightDatesRepository;
    }

    public void buyTicket(String username, String from, String to, Date date) {
        Passenger passenger = passengerRepository.get(username);
        if (passenger == null) return;

        Flight flight = null;
        List<Flight> flights = flightRepository.getAll(from, to);
        for(Flight f: flights) {
            FlightDates fd = flightDatesRepository.get(f.getId(), date);
            if (fd != null){
                flight = f;
                break;
            }
        }
        if (flight == null) return;

        Ticket ticket = new Ticket(passenger.getId(), flight.getId(), false);
        ticketRepository.updateOrInsert(ticket);
    }

    public void markTicketAsCheckedIn(int id) throws Exception{
        Ticket ticket = ticketRepository.get(id);
        if (ticket == null) throw new Exception("Ticket doesn't exists. id="+id);
        if (ticket.isCheckedin()) throw new Exception("Ticket already checked in. id="+id);
        ticket.setCheckedin(true);
        ticketRepository.updateOrInsert(ticket);
    }
}
