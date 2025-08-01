package com.billetterie.reservationmicroservice.service.impl;

import com.billetterie.reservationmicroservice.controller.dto.request.ReservationRequestDTO;
import com.billetterie.reservationmicroservice.controller.dto.response.ReservationResponseDTO;
import com.billetterie.reservationmicroservice.entity.Reservation;
import com.billetterie.reservationmicroservice.entity.Ticket;
import com.billetterie.reservationmicroservice.exception.TicketAlreadyReservedException;
import com.billetterie.reservationmicroservice.repository.ReservationRepository;
import com.billetterie.reservationmicroservice.repository.TicketRepository;
import com.billetterie.reservationmicroservice.service.ReservationService;
import com.billetterie.reservationmicroservice.service.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final TicketRepository ticketRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationMapper mapper;

    @Override
    public ReservationResponseDTO createReservation(ReservationRequestDTO dto) {
        Ticket ticket = ticketRepository.findByEventIdAndTicketNumber(dto.getEventId(), dto.getTicketNumber())
                .orElseGet(() -> {
                    Ticket newTicket = Ticket.builder()
                            .eventId(dto.getEventId())
                            .ticketNumber(dto.getTicketNumber())
                            .reserved(false)
                            .build();
                    return ticketRepository.save(newTicket);
                });

        if (ticket.getReserved()) {
            throw new TicketAlreadyReservedException("Billet déjà réservé !");
        }

        ticket.setReserved(true);
        ticketRepository.save(ticket);

        Reservation reservation = Reservation.builder()
                .userId(dto.getUserId())
                .ticketId(ticket.getId())
                .reservationDate(LocalDateTime.now())
                .confirmed(true)
                .build();

        Reservation saved = reservationRepository.save(reservation);

        return mapper.toDTO(saved, ticket);
    }

    @Override
    public List<ReservationResponseDTO> getReservationsByUser(String userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        return reservations.stream().map(res -> {
            Ticket ticket = ticketRepository.findById(res.getTicketId()).orElseThrow();
            return mapper.toDTO(res, ticket);
        }).collect(Collectors.toList());
    }
}
