package CDLibrary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CDTest {

    @Test
    public void totalTimeTest() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(new TrackBuilder()
                .withLength(340)
                .build());
        tracks.add(new TrackBuilder()
                .withLength(540)
                .build());
        tracks.add(new TrackBuilder()
                .withLength(120)
                .build());
        tracks.add(new TrackBuilder()
                .withLength(386)
                .build());

        CD cd = new CDBuilder()
                .withTracks(tracks)
                .build();

        assertEquals(cd.getTotalTime(), 340 + 540 + 120 + 386);
    }

    @Test
    public void getGenresTest() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(new TrackBuilder()
                .withGenre(Genre.RAP)
                .build());
        tracks.add(new TrackBuilder()
                .withGenre(Genre.JAZZ)
                .build());
        tracks.add(new TrackBuilder()
                .withGenre(Genre.RAP)
                .build());
        tracks.add(new TrackBuilder()
                .withGenre(Genre.POP)
                .build());

        CD cd = new CDBuilder()
                .withTracks(tracks)
                .build();

        Set<Genre> expected = new HashSet<>();
        expected.add(Genre.JAZZ);
        expected.add(Genre.RAP);
        expected.add(Genre.POP);

        assertTrue(cd.getGenres().size() == 3);
        assertEquals(cd.getGenres(), expected);
    }

    @Test
    public void addTrackTest() {
        List<Track> tracks = new ArrayList<>();
        CD cd = new CDBuilder()
                .withTracks(tracks)
                .build();
        Track track = new TrackBuilder().build();

        cd.addTrack(track);

        assertTrue(cd.getTracks().get(0) == track);
    }

}
