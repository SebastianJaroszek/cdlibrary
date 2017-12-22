package CDLibrary;

import org.junit.jupiter.api.Test;

public class MenuTest {

    @Test
    void testMenu() {
        Menu menu = new Menu();

        menu.add("Piesek", () -> System.out.println("hau hau!"));
        menu.add("Kotek", () -> System.out.println("miau miau!"));
        menu.add("Sumator", new Sumator());

        menu.showMessages();

        menu.runAction(3);
    }
}
