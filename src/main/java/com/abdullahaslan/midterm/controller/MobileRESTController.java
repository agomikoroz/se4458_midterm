package com.abdullahaslan.midterm.controller;

import com.abdullahaslan.midterm.RequestTypes.BuyTicketRequest;
import com.abdullahaslan.midterm.RequestTypes.CheckInRequest;
import com.abdullahaslan.midterm.RequestTypes.QueryFlightsRequest;
import com.abdullahaslan.midterm.entity.Flight;
import com.abdullahaslan.midterm.service.FlightService;
import com.abdullahaslan.midterm.service.TicketService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mobile")
public class MobileRESTController {

    private TicketService ticketService;
    private FlightService flightService;

    @Autowired
    public MobileRESTController(TicketService ticketService, FlightService flightService) {
        this.ticketService = ticketService;
        this.flightService = flightService;
    }

    @GetMapping("/test")
    public String sayHello() {
        return "Hello, anonymous user!";
    }

    /*
    test data
    {
        "from": "City_14",
        "to": "City_156",
        "date": "2023-10-04"
    }
     */
     @GetMapping("/queryFlights")
     public List<Flight> queryFlights(@RequestBody QueryFlightsRequest request, @RequestParam int page) {
        if (page < 0) return null;
        return flightService.getAvailableFlights(request.getFrom(), request.getTo(), request.getDate(), page);
     }

    /**
     * data for test
     * {
     *     "from": "City_14",
     *     "to": "City_156",
     *     "date": "2023-06-27",
     *     "username": "Passenger_177"
     * }
     */

     @PostMapping("/buyTicket")
     public HttpStatus buyTicket(@RequestBody BuyTicketRequest request)
     {
         if(request.getFrom().isEmpty() ||request.getTo().isEmpty()
                 || request.getUsername().isEmpty() || request.getDate() == null)
             return HttpStatus.BAD_REQUEST;

         if (! flightService.doesFlightExists(request.getFrom(), request.getTo(), request.getDate()))
             return HttpStatus.BAD_REQUEST;

         ticketService.buyTicket(request.getUsername(), request.getFrom(), request.getTo(),request.getDate());

         return HttpStatus.OK;
     }

     /*
     data for testing
        {
            "id": 50
        }
      */
     @PostMapping("/checkIn")
     public HttpStatus checkIn(@RequestBody CheckInRequest request) {
         if (request.getId() <= 0) return HttpStatus.BAD_REQUEST;
         try {
             ticketService.markTicketAsCheckedIn(request.getId());
         }catch (Exception e) {
             return HttpStatus.BAD_REQUEST;
         }
         return HttpStatus.OK;
     }
}
