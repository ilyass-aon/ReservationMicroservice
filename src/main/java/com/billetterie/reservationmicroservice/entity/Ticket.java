package com.billetterie.reservationmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickets", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"eventId", "ticketNumber"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Integer ticketNumber;

    private Boolean reserved;
}
