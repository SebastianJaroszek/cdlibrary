package CDLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

import static CDLibrary.TimeUtils.format;

@Data
@AllArgsConstructor
public class Track {
    private String title;
    private int length;
    private String compositor;
    private String textAuth;
    private Genre genre;

    @Override
    public String toString() {
        return title + ", czas trwania: "
                + format(length) + ", wykonawca: "
                + compositor + ", autor tekstu: "
                + textAuth + ", gatunek: "
                + genre.getDescription();
    }
}
