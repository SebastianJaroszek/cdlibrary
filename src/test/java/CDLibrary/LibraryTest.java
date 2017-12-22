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

        assertTrue(library.getCDs().get(0) == newCD);
    }

    @Test
    void removeCD() {
        List<CD> CDs = new ArrayList<>();
        CD newCD = new CDBuilder()
                .build();
        CDs.add(newCD);

        Library library = new Library(CDs);

        library.removeCD(1);

        assertTrue(!library.getCDs().contains(newCD));
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

    @Test
    void findTracksByTrackTitleTest(){
        List<CD> CDs = new ArrayList<>();
        Track track1expected = new TrackBuilder().withTitle("opas dfgh").build();
        Track track2expected = new TrackBuilder().withTitle("opas asdf").build();
        CD cd1 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("qwer tyui").build())
                .withTrack(track1expected)
                .withTrack(new TrackBuilder().withTitle("jklz xcvb").build())
                .build();
        CD cd2 = new CDBuilder()
                .withTrack(new TrackBuilder().withTitle("nmqw").build())
                .withTrack(track2expected)
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

        List<Track> expected = new ArrayList<>();
        expected.add(track1expected);
        expected.add(track2expected);

        List<Track> foundTracks = library.findTracksByTrackTitle("OPAS");

        assertEquals(foundTracks, expected);
    }

    @Test
    void findTracksByGenreTest(){
        List<CD> CDs = new ArrayList<>();
        Track track1expected = new TrackBuilder().withGenre(Genre.CLASSIC).build();
        Track track2expected = new TrackBuilder().withGenre(Genre.CLASSIC).build();
        Track track3expected = new TrackBuilder().withGenre(Genre.CLASSIC).build();
        CD cd1 = new CDBuilder()
                .withTrack(new TrackBuilder().withGenre(Genre.JAZZ).build())
                .withTrack(track1expected)
                .withTrack(new TrackBuilder().withGenre(Genre.POP).build())
                .build();
        CD cd2 = new CDBuilder()
                .withTrack(new TrackBuilder().withGenre(Genre.RAP).build())
                .withTrack(track2expected)
                .withTrack(track3expected)
                .build();
        CD cd3 = new CDBuilder()
                .withTrack(new TrackBuilder().withGenre(Genre.REGGAE).build())
                .withTrack(new TrackBuilder().withGenre(Genre.HEAVY_METAL).build())
                .withTrack(new TrackBuilder().withGenre(Genre.ROCK).build())
                .build();
        CDs.add(cd1);
        CDs.add(cd2);
        CDs.add(cd3);

        Library library = new Library(CDs);

        List<Track> expected = new ArrayList<>();
        expected.add(track1expected);
        expected.add(track2expected);
        expected.add(track3expected);

        List<Track> foundTracks = library.findTracksByGenre(Genre.CLASSIC);

        assertEquals(foundTracks, expected);
    }

    @Test
    void testSaveToFile() {
        CD cd1 = new CDBuilder()
                .withTitle("titleCD1")
                .withArtist("artistCD1")
                .withReleaseYear(2017)
                .withTrack(new TrackBuilder()
                        .withTitle("titleTRACK1")
                        .withTextAuth("text authorTRACK1")
                        .withLength(2342)
                        .withCompositor("compositorTRACK1")
                        .withGenre(Genre.JAZZ)
                        .build())
                .withTrack(new TrackBuilder()
                        .withTitle("titleTRACK2")
                        .withTextAuth("text authorTRACK2")
                        .withLength(532)
                        .withCompositor("compositorTRACK2")
                        .withGenre(Genre.POP)
                        .build())
                .build();

        CD cd2 = new CDBuilder()
                .withTitle("titleCD2")
                .withArtist("artistCD2")
                .withReleaseYear(2018)
                .withTrack(new TrackBuilder()
                        .withTitle("titleTRACK1cd2")
                        .withTextAuth("text authorTRACK1cd2")
                        .withLength(2342)
                        .withCompositor("compositorTRACK1cd2")
                        .withGenre(Genre.JAZZ)
                        .build())
                .withTrack(new TrackBuilder()
                        .withTitle("titleTRACK2cd2")
                        .withTextAuth("text authorTRACK2cd2")
                        .withLength(532)
                        .withCompositor("compositorTRACK2cd2")
                        .withGenre(Genre.CLASSIC)
                        .build())
                .build();

        List<CD> CDs = new ArrayList<>();

        Library library = new Library();
        library.addCD(cd1);
        library.addCD(cd2);

        library.saveToFile();


    }

    @Test
    void testLoadFromFile(){
        Library library = new Library();
        library.loadFromFile();
    }

}