package CDLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

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
        return "\n"
                + title + ", czas trwania: "
                + length + ", wykonawca: "
                + compositor + ", autor tekstu: "
                + textAuth + ", gatunek: "
                + genre.getDescription();
    }
}
