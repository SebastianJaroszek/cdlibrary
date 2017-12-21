package CDLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Library {

    //dodawanie płyty,
    //usuwanie płyty,
    //wyszukiwanie na podstawie kryteriów:
    //- szukaj po tytule płyty,
    //- szukaj po tytule utworu
    //- szukaj po gatunkach
    //- szukaj po roku wydania
    //zapis danych na dysk - pliki tekstowe
    //odczyt z dysku - pliki tekstowe

    List<CD> CDs;

    public void addCD(CD cd) {
        CDs.add(cd);
    }

    public void removeCD(CD cd) {
        CDs.remove(cd);
    }
}
