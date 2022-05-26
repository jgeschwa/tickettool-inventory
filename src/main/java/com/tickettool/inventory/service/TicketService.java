package com.tickettool.inventory.service;

import com.tickettool.inventory.api.exception.TicketNotFoundException;
import com.tickettool.inventory.model.Ticket;
import com.tickettool.inventory.repository.TicketRepository;
import com.tickettool.inventory.util.ModelData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
@Transactional
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public void save(Ticket ticket) {
        ticketRepository.saveAndFlush(ticket);
    }

    public Ticket getById(UUID uuid) throws TicketNotFoundException {
        return ticketRepository.findById(uuid).orElseThrow(
                () -> new TicketNotFoundException("Ticket with id " + uuid + " was not found"));
    }

    public List<Ticket> getAllTickets() throws TicketNotFoundException {
        List<Ticket> tickets = ticketRepository.findAll();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("No ticket was found");
        }
        return tickets;
    }

    public void resetDb() {
        log.info("Resetting DB and creating default tickets");
        ticketRepository.deleteAll();
        ticketRepository.saveAll(ModelData.getTickets());
    }
}
