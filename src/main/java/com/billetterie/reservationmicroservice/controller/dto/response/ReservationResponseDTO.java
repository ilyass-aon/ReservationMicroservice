package com.billetterie.reservationmicroservice.controller.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponseDTO {
    private Long reservationId;
    private String userId;
    private Long eventId;
    private Integer ticketNumber;
    private LocalDateTime reservationDate;
    private Boolean confirmed;
}
