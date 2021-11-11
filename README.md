# Flight Ticket Booking

implemented AirportController, PlaneController, FlightExpeditionController, BookingController and PassengerController

### Airport Controller

You can do the below.

- url : /airports

	- get request : it brings all of airports

	- post request : it is saving airport of you gave 

- url : /airports/{id}

	- get request : it brings airport with number id
	
	- patch request : it updates airport with number id (only the information you provide is processed)
	
	- delete request : it deletes airport with number id (soft delete)


### Plane Controller

You can do the below.

- url : /planes

	- get request : it brings all of planes

	- post request : it is saving planes of you gave 

- url : /planes/{id}

	- get request : it brings plane number id
	
	- patch request : it updates plane with number id (only the information you provide is processed)
	
	- delete request : it deletes plane with number id (soft delete)


### Passenger Controller

You can do the below.

- url : /passengers

	- get request : it brings all of passengers

	- post request : it is saving passenger of you gave 

- url : /passengers/{id}

	- get request : it brings passenger with number id
	
	- patch request : it updates passenger with number id (only the information you provide is processed)
	
	- delete request : it deletes passenger with number id (soft delete)


### Flight Expedition Controller

You can do the below.

- url : /flightExpeditions

	- get request : it brings all of flights

	- post request : it is saving flight of you gave 

- url : /flightExpeditions/{id}

	- get request : it brings flight with number id
	
	- patch request : it updates flight with number id (only the information you provide is processed)
	
	- delete request : it deletes flight with number id (soft delete)


It creates a flight from a specific gate for a date and time from one airport to another airport for a plane.  
It is not possible to take off or land from the same gate on the same day and at the same time.  
Flights from an airport to another airport are listed.


### Booking Controller

You can do the below.

- url : /tickets

	- post request : it is saving flight of you gave 

- url : /tickets/{id}

	- get request : it brings ticket with number id
	
	- patch request : it updates ticket with number id (only the information you provide is processed)
	
	- delete request : it deletes ticket with number id (soft delete)

User able to select a flight and book it. In order to make a reservation, there must be a seat left on the plane for that flight.  
If the reservation is completed, that seat on the plane for that flight is held for the user.  


## The Project Have These

* Spring boot web api.
* SOLID principles followed.
* JPA.
* MapStruct.
* Project have included example data initialization. 
* Attention was paid to data accuracy 


## Will Be Added
* Unit tests.
* Pageable



## Note
- This project was made according to this [Required](RequiredForTheProject.md)
* This project is a simple version of [obilet.com](https://www.obilet.com/ucak-bileti).  
