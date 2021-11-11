# Flight Ticket Booking

You should implement and API which contains AirportController, PlaneController, FlightExpeditionController, BookingController and PassengerController

### Airport Controller

You should implement CRUD operations.  
Decide on your own how the methods should look like.  
Airport must have gate capacity.

### Plane Controller

You should implement CRUD operations.  
Decide on your own how the methods should look like.  
Plane must have passenger seat capacity.  

### Passenger Controller

You should implement CRUD operations.  
Decide on your own how the methods should look like.  

### Flight Expedition Controller

It should be possible to create a flight from a specific gate for a date and time from one airport to another airport for a plane.  
It is not possible to take off or land from the same gate on the same day and at the same time.  
Flights from an airport to another airport must be listed. On the listed flights, all seats on the aircraft must not be occupied.

### Booking Controller

User should be able to select a flight and book it. In order to make a reservation, there must be a seat left on the plane for that flight.  
If the reservation is completed, that seat on the plane for that flight must be held for the user.  

## Remarks and Notation

* Spring boot web api should be used.
* SOLID principles must be followed.
* Unit tests should be written.
* JPA should be used.
* Project should include example data initialization.  
* You can use microservice architecture but not required.
* MapStruct should be used.  
* Attention should be paid to data consistency

## Note

* This project can be thought of as a simple version of [obilet.com](https://www.obilet.com/ucak-bileti).  
