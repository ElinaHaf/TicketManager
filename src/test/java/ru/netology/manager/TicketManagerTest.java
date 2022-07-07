package ru.netology.manager;

import ru.netology.domein.Ticket;
import ru.netology.repository.TicketRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 3199, "SVO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 4199, "VKO", "KZN", 95);
    Ticket ticket5 = new Ticket(5, 5199, "VKO", "KZN", 95);

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void shouldAddTickets() {

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText() {

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchBy("VKO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySimilarSortTicket() {

        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket2, ticket4};
        Ticket[] actual = manager.searchBy("VKO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNonExistentText() {

        manager.add(ticket2);
        manager.add(ticket4);
        manager.add(ticket3);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("МТР", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSortTickets() {

        manager.add(ticket3);
        manager.add(ticket1);
        manager.add(ticket4);
        manager.add(ticket2);
        manager.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = manager.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
