package CDLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
//@NoArgsConstructor
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

    private List<CD> CDs = new ArrayList<>();

    private final String FILENAME = "library.txt";

    public Library(){

    }

    public List<CD> getCDs(){
        return CDs;
    }


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

    public void saveToFile() {
        try {
            File file = new File(FILENAME);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(CDs.size()); //liczba płyt w bibliotece
            for (CD cd : CDs) {
                saveCDToFile(printWriter, cd);
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem z zapisem pliku " + FILENAME);
        }
    }

    private void saveCDToFile(PrintWriter printWriter, CD cd) {
        printWriter.println(cd.getTitle());
        printWriter.println(cd.getArtist());
        printWriter.println(cd.getTracks().size());
        for (Track track : cd.getTracks()) {
            saveTrackToFile(printWriter, track);
        }
        printWriter.println(cd.getReleaseYear());
    }

    private void saveTrackToFile(PrintWriter printWriter, Track track) {
        printWriter.println(track.getTitle());
        printWriter.println(track.getLength());
        printWriter.println(track.getGenre());
        printWriter.println(track.getCompositor());
        printWriter.println(track.getTextAuth());
    }

    public void loadFromFile() {
        try {
            File file = new File(FILENAME);
            Scanner in = new Scanner(file);
            CDs.clear();
            Integer numberOfCDs = Integer.valueOf(in.nextLine());
            for (int i = 0; i < numberOfCDs; i++) {
                loadCDFromFile(in);
                //CD cd = loadCDFromFile(in);
                //CDs.add(cd);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem z odczytem pliku " + FILENAME);
        }
    }

    private void loadCDFromFile(Scanner in) {
        String title = in.nextLine();
        String artist = in.nextLine();
        Integer numberOfTracks = Integer.valueOf(in.nextLine());
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < numberOfTracks; i++) {
            Track track = loadTrackFromFile(in);
            tracks.add(track);
        }
        Integer releaseYear = Integer.valueOf(in.nextLine());
        CD cd = new CDBuilder()
                .withTitle(title)
                .withArtist(artist)
                .withTracks(tracks)
                .withReleaseYear(releaseYear)
                .build();
        CDs.add(cd);
    }

    private Track loadTrackFromFile(Scanner in) {
        String title = in.nextLine();
        Integer length = Integer.valueOf(in.nextLine());
        Genre genre = Genre.valueOf(in.nextLine());
        String compositor = in.nextLine();
        String textAuthor = in.nextLine();
        Track track = new TrackBuilder()
                .withTitle(title)
                .withLength(length)
                .withGenre(genre)
                .withCompositor(compositor)
                .withTextAuth(textAuthor)
                .build();
        return track;
    }


}
