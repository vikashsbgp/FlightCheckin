package com.vikash.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vikash.flightcheckin.dto.Reservation;
import com.vikash.flightcheckin.dto.ReservationUpdateRequest;
import com.vikash.flightcheckin.integration.ReservationRestClient;

@Controller
public class CheckInController {

	@Autowired
	private ReservationRestClient restClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}

	@RequestMapping("/completeCheckIn")
	public String completeCheckin(@RequestParam("reservationId") Long reservationId, @RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}

}
