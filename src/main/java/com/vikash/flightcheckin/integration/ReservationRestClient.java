package com.vikash.flightcheckin.integration;

import com.vikash.flightcheckin.dto.Reservation;
import com.vikash.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request); 
	
}
