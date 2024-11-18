package com.abdullahaslan.midterm.controller;

import com.abdullahaslan.midterm.RequestTypes.InsertFlightRequest;
import com.abdullahaslan.midterm.RequestTypes.ReportFlightsRequest;
import com.abdullahaslan.midterm.entity.Flight;
import com.abdullahaslan.midterm.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRESTController {

    @Autowired
    FlightService flightService;

    @GetMapping("/test")
    public String sayHello(Authentication auth) {
        if (auth == null) return "Hello, you shouldn't be here";
        return "Hello, " + auth.getName();
    }

    /*
    test data
    {
        "from": "City_1",
        "to": "City_2",
        "capacity": 11,
        "availableDates": ["2023-11-18", "2023-11-19", "2023-11-20"]
    }
     */

    @PostMapping("/insertFlight")
    public HttpStatus insertFlight(@RequestBody InsertFlightRequest request)
    {
        if(request.getFrom().isEmpty() || request.getCapacity() == 0 ||
                request.getTo().isEmpty() || request.getAvailableDates().isEmpty())
            return HttpStatus.BAD_REQUEST;

        try {
            Flight flight = new Flight(request.getFrom(), request.getTo(), request.getCapacity());
            flightService.insertFlight(flight, request.getAvailableDates());
        } catch (Exception e) {
            System.err.println(e.toString());
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    /*
    test data
    {
        "from": "City_1",
        "to": "City_2",
        "capacity": 11,
        "dates": ["2023-11-18", "2023-11-19", "2023-11-20"]
    }
     */
    @GetMapping("/reportFlights")
    public List<Flight> reportFlights(@RequestBody ReportFlightsRequest request, @RequestParam int page)
    {
        if (page < 0) return null;
        return flightService.getFlights(request.getFrom(), request.getTo(), request.getCapacity(), request.getDates(), page);
    }

}
