package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repo.TicketRepo;

import java.util.Arrays;


@NoArgsConstructor
@Data
public class TicketManager {
    private TicketRepo repo;

    public TicketManager(TicketRepo repo) {
        this.repo = repo;
    }

    public void add(Ticket product) {
        repo.addItem(product);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (iataDeparture(ticket, from)) {
                if (iataArrival(ticket, to)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                    Arrays.sort(result);
                }
            }
        }
        return result;
    }

    private boolean iataDeparture(Ticket ticket, String search) {
        if (ticket.getIataDeparture().contains(search)) {
            return true;
        }
        return false;
    }

    private boolean iataArrival(Ticket ticket, String search) {
        if (ticket.getIataArrival().contains(search)) {
            return true;
        }
        return false;
    }
}