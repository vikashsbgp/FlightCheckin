<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Details</title>
</head>
<body>
<h2>Flight Details:</h2>

Airlines: 		${reservation.flight.operating_airlines}<br/>
Flight Number:  ${reservation.flight.flight_number}<br/>
From: 			${reservation.flight.departure_city}<br/>
To: 			${reservation.flight.arrival_city}<br/>
Date: 			${reservation.flight.date_of_departure}<br/>
Time: 			${reservation.flight.estimated_departure_time}<br/>


<h2>Passenger Details:</h2>

First Name: ${reservation.passenger.firstName}<br/>
Last Name: ${reservation.passenger.lastName}<br/>
Middle Name: ${reservation.passenger.middleName}<br/>
Email: ${reservation.passenger.email}<br/>
Phone: ${reservation.passenger.phone}<br/>

<form action="completeCheckIn" method="post">
	Enter the number of bags you want to check in: <input type="text" name="numberOfBags" />
	<input type="hidden" value="${reservation.id}" name="reservationId" />
	<input type="submit" value="Check In" />
</form>
</body>
</html>