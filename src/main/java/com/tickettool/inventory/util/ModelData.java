package com.tickettool.inventory.util;

import com.tickettool.inventory.model.Priority;
import com.tickettool.inventory.model.Ticket;

import java.util.List;
import java.util.UUID;

public abstract class ModelData {

    public static List<Ticket> getTickets() {
       return List.of(
                Ticket.builder()
                        .title("Test ticket 1")
                        .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                        .description("Example description 1")
                        .priority(Priority.MEDIUM)
                        .build(),
                Ticket.builder()
                        .title("Test ticket 2")
                        .id(UUID.fromString("00000000-0000-0000-0000-000000000002"))
                        .description("Example description 2")
                        .priority(Priority.CRITICAL)
                        .build()
        );
    }
}
