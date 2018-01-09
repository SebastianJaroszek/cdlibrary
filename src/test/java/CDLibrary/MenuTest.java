package CDLibrary;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class MenuTest {

    @Test
    void testMenu() {
        ScannerUtils scannerUtils = new ScannerUtils(new Scanner(System.in));
        Menu menu = new Menu(scannerUtils);

        menu.add("Piesek", () -> System.out.println("hau hau!"));
        menu.add("Kotek", () -> System.out.println("miau miau!"));
        menu.add("Sumator", new Sumator());

        menu.showMenuItems();

        menu.runAction(3);
    }
}
