package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repo.TicketRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    TicketRepo repo = new TicketRepo();
    TicketManager manager = new TicketManager(repo);

    Ticket offer1 = new Ticket(1, "MQF", "SWO", 122, 14500);
    Ticket offer2 = new Ticket(2, "MQF", "SWO", 121, 14300);
    Ticket offer3 = new Ticket(3, "SWO", "TEL", 325, 44500);
    Ticket offer4 = new Ticket(4, "SWO", "TGD", 220, 32000);
    Ticket offer5 = new Ticket(5, "TGD", "TEL", 230, 16000);
    Ticket offer6 = new Ticket(6, "TGD", "TEL", 210, 17000);

    @BeforeEach
    public void added() {
        manager.add(offer1);
        manager.add(offer2);
        manager.add(offer3);
        manager.add(offer4);
        manager.add(offer5);
        manager.add(offer6);
    }

    @Test
    public void shouldSearchTicketOne() {
        assertArrayEquals(manager.searchBy("SWO", "TEL"), new Ticket[]{offer3});
    }


    @Test
    public void shouldSearchTicketNone() {
        assertArrayEquals(manager.searchBy("MQF", "TEL"), new Ticket[]{});

    }

    @Test
    public void shouldSearchTicketDuplicatedFlights1() {
        assertArrayEquals(manager.searchBy("MQF", "SWO"), new Ticket[]{offer2, offer1});
    }

    @Test
    public void shouldSearchTicketDuplicatedFlights2() {
        assertArrayEquals(manager.searchBy("TGD", "TEL"), new Ticket[]{offer6, offer5});
    }

    @Test
    public void shouldSearchTicketTransitLeastTime() {
        assertArrayEquals(manager.searchBy("MQF", "SWO"), new Ticket[]{offer2, offer1});
    }

}

