package ru.netology.repo;

import ru.netology.domain.Ticket;

public class TicketRepo {
    private Ticket[] items = new Ticket[0];


    public void addItem(Ticket item) {
        int i = items.length + 1;
        Ticket[] tmp = new Ticket[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }
}