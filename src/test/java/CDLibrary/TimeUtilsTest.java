package CDLibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeUtilsTest {

    /*@Test
    void formatTest(){
        int time = 3970;
        String result = TimeUtils.format(time);
        System.out.println(result);
    }*/

    @Test
    public void timeUtilsTest() {
        Assertions.assertEquals("00:50", TimeUtils.format(50));
        Assertions.assertEquals("01:10", TimeUtils.format(70));
        Assertions.assertEquals("02:05", TimeUtils.format(125));
        Assertions.assertEquals("01:00:01", TimeUtils.format(3601));
        Assertions.assertEquals("01:06:10", TimeUtils.format(3970));
    }

}
