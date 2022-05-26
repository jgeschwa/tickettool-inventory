package com.tickettool.inventory.api.controller;

import com.tickettool.inventory.model.Ticket;
import com.tickettool.inventory.service.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value ="/ticket", consumes = "application/json", produces = "application/json")
@RequiredArgsConstructor
@Tag(name = "Ticket Controller")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable UUID uuid) {
        return new ResponseEntity<>(ticketService.getById(uuid), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @GetMapping("/resetdb")
    public void resetDb() {
        ticketService.resetDb();
    }

}
