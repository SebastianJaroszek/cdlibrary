package CDLibrary;

public class TrackBuilder {
    private String title;
    private int length;
    private String artist;
    private String textAuth;
    private Genre genre;

    public TrackBuilder() {
    }

    public TrackBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TrackBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    public TrackBuilder withCompositor(String compositor) {
        this.artist = compositor;
        return this;
    }

    public TrackBuilder withTextAuth(String textAuth) {
        this.textAuth = textAuth;
        return this;
    }

    public TrackBuilder withGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Track build(){
        return new Track(title, length, artist, textAuth, genre);
    }

}
