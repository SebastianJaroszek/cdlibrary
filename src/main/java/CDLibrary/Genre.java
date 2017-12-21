package CDLibrary;

public enum Genre {
    POP("pop"),
    RAP("rap"),
    JAZZ("jazz"),
    ROCK("rock"),
    CLASSIC("classic"),
    REGGAE("reggae"),
    HEAVY_METAL("heavy metal");

    private String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
