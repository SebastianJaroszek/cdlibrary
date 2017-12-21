package CDLibrary;

import java.util.ArrayList;
import java.util.List;

public class CDBuilder {

    private String title;
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    private int releaseYear;

    public CDBuilder() {
    }

    public CDBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CDBuilder withArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public CDBuilder withTracks(List<Track> tracks) {
        /*if (tracks == null) {
            this.tracks = new ArrayList<>();
            //withTracks(new ArrayList<>());
        }*/
        this.tracks.addAll(tracks);
        //this.tracks = tracks;
        return this;
    }

    public CDBuilder withTrack(Track track) {
        /*if (tracks == null) {
            this.tracks = new ArrayList<>();
            //withTracks(new ArrayList<>());
        }*/
        this.tracks.add(track);
        return this;
    }

    public CDBuilder withReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public CD build() {
        return new CD(title, artist, tracks, releaseYear);
    }
}
