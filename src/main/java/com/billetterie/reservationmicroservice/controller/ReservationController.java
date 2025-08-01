package com.billetterie.reservationmicroservice.controller;

import com.billetterie.reservationmicroservice.controller.dto.request.ReservationRequestDTO;
import com.billetterie.reservationmicroservice.controller.dto.response.ReservationResponseDTO;
import com.billetterie.reservationmicroservice.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> reserve(@RequestBody ReservationRequestDTO dto) {
        return ResponseEntity.ok(reservationService.createReservation(dto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ReservationResponseDTO>> getUserReservations(@PathVariable String userId) {
        return ResponseEntity.ok(reservationService.getReservationsByUser(userId));
    }
}
