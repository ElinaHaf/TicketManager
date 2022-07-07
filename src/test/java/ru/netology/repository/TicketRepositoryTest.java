package ru.netology.repository;

import ru.netology.domein.Ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);

    @Test
    public void shouldSaveTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);

        repo.removeById(ticket1.getId());

        Ticket[] expected = {ticket2};
        Ticket[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveAllTickets() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);

        repo.removeById(ticket1.getId());
        repo.removeById(ticket2.getId());

        Ticket[] expected = {};
        Ticket[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);

        repo.removeById(2);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
