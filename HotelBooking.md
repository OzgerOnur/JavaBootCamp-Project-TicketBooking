# Hotel Reservation API

You should implement and API which contains HotelController, RoomController, SearchController, BookingController, VisitorController

### Hotel Controller

You should implement CRUD operations.  
Decide on your own how the methods should look like.  

### Room Controller

You should implement CRUD operations.  
Rooms are related with the hotels and there different types such as `STANDART`,`ECONOMY` and `SUIT`.  
Decide on your own how the methods should look like.  

### Visitor Controller

You should implement CRUD operations.  
Decide on your own how the methods should look like.  

### Search Controller

The user should be able to search the list of hotels with available rooms in the desired time range.The user should be able to search according to the province and district where he/she wants to stay.  
The user should be able to list the available rooms of the hotel that are available at the time the user chooses.  

### Booking Controller

User must be able to book a room of a hotel for a certain time period.  
If the room is not available within the requested time interval, an error should be returned to the user.  
If the user makes `campaignDay` different reservations at different times and wants to make a new reservation after the date of the last reservation, she will be able to do it free of charge.  

### Application.yaml

* Active Profile: `prod`
  * campaignDay: 10
* Active Profile: `stage`
  * campaignDay: 5

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

* This project can be thought of as a simple version of [hotels.com](https://tr.hotels.com/).  
