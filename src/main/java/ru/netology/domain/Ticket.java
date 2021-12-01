package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private String iataDeparture;
    private String iataArrival;
    private int transitTime;
    private int price;

    @Override
    public int compareTo(Ticket o) {
        return transitTime - o.transitTime;
    }
}







