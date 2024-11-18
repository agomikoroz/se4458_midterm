# API Project for an Airline Company
*****
- This is an api for an airline company. It allows users to read flights for a date and read flight with a request
- see /swagger-ui/index.html#/ for swagger documentation
- Link to the video presentation: https://drive.google.com/file/d/1kHlyQXTCyjvsTHgm1RGDSERsbc6moL8T/view?usp=sharing

# ENDPOINTS
*****
- /api/v1/mobile/test
  - returns simple hello text for testing
- /api/v1/mobile/queryFlights
  - takes a json object that contains from, to and date.
  - takes a request parameter named "page" for pagination
  - returns all flights with the given from, to and dates.
- /api/v1/mobile/buyTicket
  - takes a json object that contains from, to, username and date
  - returns a httpstatus.
- /api/v1/mobile/checkIn
  - takes a json object that contains an id of a ticket
  - returns a httpstatus.
- /api/v1/admin/test
  - returns simple hello text with the signed in user's name.
  - only accessible for admin users
- /api/v1/admin/insertFlight
  - takes a json object that contains from, to, capacity and available dates
  - returns a httpstatus
  - only accessible for admin users
- /api/v1/admin/reportFlights
  - takes a json object that contains from, to, capacity and dates
  - takes a request parameter named "page" for pagination
  - returns all flights with the given informations
  - only accessible for admin users

# DATA MODELS
*****
## Flight
- id: int
- from: String
- to: String
- seat: int

## FlightDates
- id: int
- flightID: int
- date: date
- bseat: int

## Passenger
- id: int
- username: String

## Ticket
- id: int
- passengerID: int
- flightID: int
- checkedin: int
