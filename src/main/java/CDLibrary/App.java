package CDLibrary;

import java.util.InputMismatchException;
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

    private void mainMenu() {
        System.out.println("Witamy w programie");
        boolean again = true;
        while (again) {
            showMainMenu();
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
            }
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
