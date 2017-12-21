package CDLibrary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addCD() {
        List<CD> CDs = new ArrayList<>();
        /*CDs.add(new CDBuilder()
                .build());
        CDs.add(new CDBuilder()
                .build());
        CDs.add(new CDBuilder()
                .build());
        CDs.add(new CDBuilder()
                .build());*/

        Library library = new Library(CDs);

        CD newCD = new CDBuilder().build();
        library.addCD(newCD);

        assertTrue(library.CDs.get(0) == newCD);
    }

    @Test
    void removeCD() {
        List<CD> CDs = new ArrayList<>();
        CD newCD = new CDBuilder()
                .build();
        CDs.add(newCD);

        Library library = new Library(CDs);

        library.removeCD(newCD);

        assertTrue(!library.CDs.contains(newCD));
    }

    @Test
    void searchWithCDTitleTest() {
        List<CD> CDs = new ArrayList<>();
        CD cd1 = new CDBuilder()
                .withTitle("SEQUEL")
                .build();
        CD cd2 = new CDBuilder()
                .withTitle("Podróż zwana życiem")
                .build();
        CD cd3 = new CDBuilder()
                .withTitle("NEW SEQUEL")
                .build();
        CD cd4 = new CDBuilder()
                .withTitle("Życie po śmierci")
                .build();
        CDs.add(cd1);
        CDs.add(cd2);
        CDs.add(cd3);
        CDs.add(cd4);

        Library library = new Library(CDs);

        List<CD> expected = new ArrayList<>();
        expected.add(cd1);
        expected.add(cd3);

        List<CD> foundCDs = library.searchWithCDTitle("sequel");

        assertEquals(foundCDs, expected);
    }

    @Test
    void searchWithCDTitleTest2() {
        List<CD> CDs = new ArrayList<>();
        CD cd1 = new CDBuilder()
                .withTitle("SEQUEL")
                .build();
        CD cd2 = new CDBuilder()
                .withTitle("Podróż zwana życiem")
                .build();
        CD cd3 = new CDBuilder()
                .withTitle("NEW SEQUEL")
                .build();
        CD cd4 = new CDBuilder()
                .withTitle("Życie po śmierci")
                .build();
        CDs.add(cd1);
        CDs.add(cd2);
        CDs.add(cd3);
        CDs.add(cd4);

        Library library = new Library(CDs);

        List<CD> expected = new ArrayList<>();
        expected.add(cd2);
        expected.add(cd4);

        List<CD> foundCDs = library.searchWithCDTitle("ŻyCiE");

        assertEquals(foundCDs, expected);
    }

}