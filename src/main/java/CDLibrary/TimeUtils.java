package CDLibrary;

public class TimeUtils {

    public static String format(int time) {
        int hours = (time / 60) / 60;
        int minutes = (time / 60) % 60;
        //int minutes = (time / 60) - (hours * 60);
        int seconds = time % 60;

        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
        //hours + ":" + minutes + ":" + seconds;

    }

}
