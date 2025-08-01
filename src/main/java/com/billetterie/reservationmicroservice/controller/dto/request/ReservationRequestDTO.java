package com.billetterie.reservationmicroservice.controller.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequestDTO {
    private String userId;
    private Long eventId;
    private Integer ticketNumber;
}
