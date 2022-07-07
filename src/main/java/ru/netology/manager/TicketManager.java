package ru.netology.manager;

import ru.netology.repository.TicketRepository;
import ru.netology.domein.Ticket;

import java.util.Arrays;

public class TicketManager {

    protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;

    }

    public void add(Ticket ticket) {
        repo.save(ticket);

    }

    public Ticket[] getFindAll() {
        Ticket[] all = repo.getFindAll();
        Arrays.sort(all);
        return all;
    }

    public Ticket[] searchBy(String text1, String text2) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repo.getFindAll()) {
            if (matches(ticket, text1, text2)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;

            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String search1, String search2) {
        if (ticket.getFrom().contains(search1) && ticket.getTo().contains(search2)) {
            return true;
        } else {
            return false;
        }

    }
}
