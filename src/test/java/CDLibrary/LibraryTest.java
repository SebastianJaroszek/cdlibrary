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

        library.removeCD(1);

        assertTrue(!library.CDs.contains(newCD));
    }

    @Test
    void findByCDTitleTest() {
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

        List<CD> foundCDs = library.findByCDTitle("sequel");

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

        List<CD> foundCDs = library.findByCDTitle("ŻyCiE");

        assertEquals(foundCDs, expected);
    }

    @Test
    void findCDsByTrackTitleTest() {
        List<CD> CDs = new ArrayList<>();
        CD cd1 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("qwer tyui").build())
                .withTrack(new TrackBuilder().withTitle("opas dfgh").build())
                .withTrack(new TrackBuilder().withTitle("jklz xcvb").build())
                .build();
        CD cd2 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("nmqw").build())
                .withTrack(new TrackBuilder().withTitle("opas asdf").build())
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .build();
        CD cd3 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .build();
        CDs.add(cd1);
        CDs.add(cd2);
        CDs.add(cd3);

        Library library = new Library(CDs);

        List<CD> expected = new ArrayList<>();
        expected.add(cd1);
        expected.add(cd2);

        List<CD> foundCDs = library.findCDsByTrackTitle("OPAS");

        assertEquals(foundCDs, expected);
    }

    /*@Test
    void findTracksByTrackTitleTest(){
        List<CD> CDs = new ArrayList<>();
        CD cd1 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("qwer tyui").build())
                .withTrack(new TrackBuilder().withTitle("opas dfgh").build())
                .withTrack(new TrackBuilder().withTitle("jklz xcvb").build())
                .build();
        CD cd2 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("nmqw").build())
                .withTrack(new TrackBuilder().withTitle("opas asdf").build())
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .build();
        CD cd3 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .withTrack(new TrackBuilder().withTitle("asdf").build())
                .build();
        CDs.add(cd1);
        CDs.add(cd2);
        CDs.add(cd3);

        Library library = new Library(CDs);

        List<CD> expected = new ArrayList<>();
        expected.add(cd1);
        expected.add(cd2);

        List<CD> foundCDs = library.findTracksByTrackTitle("OPAS");

        assertEquals(foundCDs, expected);
    }*/

}