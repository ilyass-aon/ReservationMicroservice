package com.billetterie.reservationmicroservice.exception;

public class TicketAlreadyReservedException extends RuntimeException {
    public TicketAlreadyReservedException(String message) {
        super(message);
    }
}
