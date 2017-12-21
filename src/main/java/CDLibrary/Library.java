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

    List<CD> CDs = new ArrayList<>();

    public void addCD(CD cd) {
        CDs.add(cd);
    }

    /*public void removeCD(CD cd) {
        CDs.remove(cd);
    }*/

    public void removeCD(int index) {
        CDs.remove(index - 1);
    }

    public List<CD> findByCDTitle(String titleFragment) {
        /*List<CD> result = new ArrayList<>();
        for (CD cd : CDs){
            if (cd.getTitle().toLowerCase().contains(titleFragment.toLowerCase())){
                result.add(cd);
            }
        }
        return result;*/
        String lowerCasetitleFragment = titleFragment.toLowerCase();
        return CDs.stream()
                /*.map(cd -> cd.getTitle())
                .map(title -> title.toLowerCase())*/
                .filter(cd -> cd.getTitle().toLowerCase().contains(lowerCasetitleFragment))
                .collect(Collectors.toList());
    }

    public List<Track> findTracksByTrackTitle(String trackTitleFragment) {
        /*List<Track> result = new ArrayList<>();
        for (CD cd : CDs) {
            for (Track track : cd.getTracks()) {
                if (track.getTitle().toLowerCase().contains(trackTitleFragment.toLowerCase())) {
                    result.add(track);
                }
            }
        }
        return result;*/
        String lowerCaseTrackTitleFragment = trackTitleFragment.toLowerCase();
        return CDs.stream()
                .flatMap(cd -> cd.findTracksByTitle(lowerCaseTrackTitleFragment).stream())
                .collect(Collectors.toList());
                /*.map(cd -> cd.findTracksByTitle(lowerCaseTrackTitleFragment))
                .collect(Collectors.toList());*/
    }

    public List<CD> findCDsByTrackTitle(String trackTitleFragment) {
        /*List<CD> result = new ArrayList<>();
        for (CD cd : CDs) {
            for (Track track : cd.getTracks()) {
                if (track.getTitle().toLowerCase().contains(trackTitleFragment.toLowerCase())) {
                    result.add(cd);
                }
            }
        }
        return result;*/
        String lowerCaseTrackTitleFragment = trackTitleFragment.toLowerCase();
        //szybsze rozwiązanie:
        return CDs.stream()
                .filter(
                        cd -> cd.getTracks().stream()
                                .anyMatch(track -> track.getTitle().contains(lowerCaseTrackTitleFragment))
                )
                .collect(Collectors.toList());
        //.anyMatch(track -> track.getTitle().contains(lowerCaseTrackTitleFragment))
                /*.filter(cd -> !cd.findTracksByTitle(lowerCaseTrackTitleFragment).isEmpty())
                .collect(Collectors.toList());*/
    }


    public List<Track> findTracksByGenre(Genre genre) {
        return CDs.stream()
                .flatMap(cd -> cd.findTracksByGenre(genre).stream())
                .collect(Collectors.toList());
    }

    public List<CD> findCDsByGenre(Genre genre) {
        return CDs.stream()
                .filter(
                        cd -> cd.getTracks().stream()
                                .anyMatch(track -> track.getGenre() == genre)
                )
                .collect(Collectors.toList());
    }

    public List<CD> findByReleaseYear(int releaseYear) {
        return CDs.stream()
                .filter(cd -> cd.getReleaseYear() == releaseYear)
                .collect(Collectors.toList());
    }

    /*
    public void saveToFile() {

    }

    public void loadFromFile() {

    }*/
}
