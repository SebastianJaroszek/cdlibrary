package CDLibrary;

import java.util.Scanner;

public class ScannerUtils {

    private Scanner scanner;

    public ScannerUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Wymusza na użytkowniku podanie poprawnych danych
     *
     * @param min najmniejsza dozwolona liczba całkowita
     * @param max największa dozwolona liczba całkowita
     * @return liczba
     */
    public int readInt(int min, int max) {
        while (true) {
            try {
                int menuPosition = Integer.parseInt(scanner.nextLine());
                if (menuPosition >= min && menuPosition <= max) {
                    return menuPosition;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Musisz podać liczbę od " + min + " do " + max + ".");
        }
    }

    public int readInt(int max) {
        return readInt(1, max);
    }
}
