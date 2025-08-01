package com.billetterie.reservationmicroservice.service;

import com.billetterie.reservationmicroservice.controller.dto.response.ReservationResponseDTO;
import com.billetterie.reservationmicroservice.controller.dto.request.ReservationRequestDTO;


import java.util.List;

public interface ReservationService {
    ReservationResponseDTO createReservation(ReservationRequestDTO dto);
    List<ReservationResponseDTO> getReservationsByUser(String userId);
}
