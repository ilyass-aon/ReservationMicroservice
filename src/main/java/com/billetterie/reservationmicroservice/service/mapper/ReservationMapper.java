package com.billetterie.reservationmicroservice.service.mapper;

import com.billetterie.reservationmicroservice.controller.dto.response.ReservationResponseDTO;
import com.billetterie.reservationmicroservice.entity.Reservation;
import com.billetterie.reservationmicroservice.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public ReservationResponseDTO toDTO(Reservation reservation, Ticket ticket) {
        return ReservationResponseDTO.builder()
                .reservationId(reservation.getId())
                .userId(reservation.getUserId())
                .eventId(ticket.getEventId())
                .ticketNumber(ticket.getTicketNumber())
                .reservationDate(reservation.getReservationDate())
                .confirmed(reservation.getConfirmed())
                .build();
    }
}
