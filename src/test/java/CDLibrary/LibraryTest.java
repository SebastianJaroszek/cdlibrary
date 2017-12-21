package CDLibrary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addCD() {
        List<CD> CDs = new ArrayList<>();
        /*CDs.add(new CDBuilder()
                .build());
        CDs.add(new CDBuilder()
                .build());
        CDs.add(new CDBuilder()
                .build());
        CDs.add(new CDBuilder()
                .build());*/

        Library library = new Library(CDs);

        CD newCD = new CDBuilder().build();
        library.addCD(newCD);

        assertTrue(library.CDs.get(0) == newCD);
    }

    @Test
    void removeCD() {
        List<CD> CDs = new ArrayList<>();
        CD newCD = new CDBuilder()
                .build();
        CDs.add(newCD);

        Library library = new Library(CDs);

        library.removeCD(newCD);

        assertTrue(!library.CDs.contains(newCD));
    }

}