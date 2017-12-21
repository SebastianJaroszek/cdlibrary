package CDLibrary;

import java.util.List;

public class CDBuilder {

    private String title;
    private String artist;
    private List<Track> tracks;
    private int releaseYear;

    public CDBuilder(){
    }

    public CDBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public CDBuilder withArtist(String artist){
        this.artist = artist;
        return this;
    }

    public CDBuilder withTracks(List<Track> tracks){
        this.tracks = tracks;
        return this;
    }

    public CDBuilder withReleaseYear(int releaseYear){
        this.releaseYear = releaseYear;
        return this;
    }

    public CD build(){
        return new CD(title, artist, tracks, releaseYear);
    }
}
