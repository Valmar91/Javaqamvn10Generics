import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("TMN", "MSK", 100, 18, 21);
    Ticket ticket2 = new Ticket("MSK", "TMN", 400, 16, 21);
    Ticket ticket3 = new Ticket("MSK", "TMN", 200, 17, 21);
    Ticket ticket4 = new Ticket("MSK", "TMN", 500, 17, 20);
    Ticket ticket5 = new Ticket("EKB", "MSK", 300, 18, 21);
    Ticket ticket6 = new Ticket("MSK", "TMN", 400, 15, 21);
    Ticket ticket7 = new Ticket("SPB", "MSK", 100, 18, 20);
    Ticket ticket8 = new Ticket("MSK", "TMN", 300, 12, 14);

    @Test
    public void TestSearch1() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3, ticket8, ticket2, ticket6, ticket4};
        Ticket[] actual = manager.search("MSK", "TMN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearch2() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("TMN", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearch3() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("TMN", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortBy1() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket8, ticket4, ticket3, ticket2, ticket6};
        Ticket[] actual = manager.searchAndSortBy("MSK", "TMN", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortBy2() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("TMN", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortBy3() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchAndSortBy("TMN", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
