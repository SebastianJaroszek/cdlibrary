package CDLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<CD> searchWithCDTitle(String titleFragment){
        /*List<CD> result = new ArrayList<>();
        for (CD cd : CDs){
            if (cd.getTitle().toLowerCase().contains(titleFragment.toLowerCase())){
                result.add(cd);
            }
        }
        return result;*/
        return CDs.stream()
                /*.map(cd -> cd.getTitle())
                .map(title -> title.toLowerCase())*/
                .filter(cd -> cd.getTitle().toLowerCase().contains(titleFragment.toLowerCase()))
                .collect(Collectors.toList());
    }
}
