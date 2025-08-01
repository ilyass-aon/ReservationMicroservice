package com.billetterie.reservationmicroservice.repository;

import com.billetterie.reservationmicroservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByEventIdAndTicketNumber(Long eventId, Integer ticketNumber);
}
