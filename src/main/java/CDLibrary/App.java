package CDLibrary;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    private Library library;
    private Scanner in;

    public App() {
        library = new Library();
        in = new Scanner(System.in);
    }

    public void start() {
        library.loadFromFile();
        mainMenu();
        library.saveToFile();
    }

        /*1. dodaj nową płytę
        2. usuń płytę
        3. wyświetl wszystkie płyty
        4. wyszukaj płyty po tytule płyty
        5. wyszukaj utwory po tytule utworu
        6. wyszukaj płyty po tytule utworu
        7. wyszukaj płyty po gatunku
        8. wyszukaj utwory po gatunku
        9. wyszukaj płyty po roku wydania
        10. wyjdź z programu*/

    private Menu createMainMenu() {
        Menu menu = new Menu();

        menu.add("dodaj nową płytę", () -> addNewCD());
        menu.add("usuń płytę", () -> deleteCD());
        menu.add("wyświetl wszystkie płyty", () -> showAllCDs());
        menu.add("wyszukaj płyty po tytule płyty", () -> findCDsByCDTitle());
        menu.add("wyszukaj utwory po tytule utworu", () -> findTracksByTrackTitle());
        /*menu.add("wyszukaj płyty po tytule utworu", () -> findCDsByTrackTitle());
        menu.add("wyszukaj płyty po gatunku", () -> findCDsByGenre());
        menu.add("wyszukaj utwory po gatunku", () -> findTracksByGenre());
        menu.add("wyszukaj płyty po roku wydania", () -> findCDsByReleaseYear());
        menu.add("wyjdź z programu", () -> exitFromProgram());*/


        return menu;
    }

    /*private void exitFromProgram() {

    }

    private void findCDsByReleaseYear() {

    }

    private void findTracksByGenre() {

    }

    private void findCDsByGenre() {

    }

    private void findCDsByTrackTitle() {

    }*/

    private void findTracksByTrackTitle() {

    }

    private void findCDsByCDTitle() {

    }

    private void showAllCDs() {
        List<CD> allCDs = library.getCDs();
        for (int i = 0; i < allCDs.size(); i++) {
            System.out.println((i + 1) + ". " + allCDs.get(i));
        }
        System.out.println("Podaj numer płyty do wyświetlenia");
        int index = readInt(library.getCDs().size()) - 1;
        System.out.println(library.getCDs().get(index).toFullString());
        //allCDs.stream().forEach(cd -> System.out.println(cd.getTitle()));
    }

    private void deleteCD() {

    }

    private void addNewCD() {

    }

    private void mainMenu() {
        System.out.println("Witamy w programie");
        Menu mainMenu = createMainMenu();
        boolean again = true;
        while (again) {
            mainMenu.showMessages();
            int option = readInt(mainMenu.size());
            mainMenu.runAction(option);
            /*showMainMenu();
            int option = readInt(10);
            switch (option) {
                case 1:
                    //addNewCD();
                    break;
                case 2:
                    //deleteCD();
                    break;
                case 3:
                    //showAllCDs();
                    break;
                case 4:
                    //findCDsByCDTitle();
                    break;
                case 5:
                    //findTracksByTrackTitle();
                    break;
                case 10:
                    again = false;
                    //return;
            }*/
        }
    }

    private int readInt(int max) {
        while (true) {
            try {
                int menuPosition = Integer.parseInt(in.nextLine());
                if (menuPosition >= 1 && menuPosition <= max) {
                    return menuPosition;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Musisz podać liczbę od 1 do " + max + ".");
        }
    }

    private void showMainMenu() {
        System.out.println("1. dodaj nową płytę");
        System.out.println("2. usuń płytę");
        System.out.println("3. wyświetl wszystkie płyty");
        System.out.println("4. wyszukaj płyty po tytule płyty");
        System.out.println("5. wyszukaj utwory po tytule utworu");
        System.out.println("6. wyszukaj płyty po tytule utworu");
        System.out.println("7. wyszukaj płyty po gatunku");
        System.out.println("8. wyszukaj utwory po gatunku");
        System.out.println("9. wyszukaj płyty po roku wydania");
        System.out.println("10. wyjdź z programu");
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
        System.out.println("komunikat");
    }
}
