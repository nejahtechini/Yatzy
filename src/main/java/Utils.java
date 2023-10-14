import java.util.List;

import static java.util.Arrays.asList;

public class Utils {

    static int getCount(List<Integer> list, int value) {
        int count = (int) list.stream().filter(item -> item == value)
            .count();
        return count;
    }

    public static boolean isSmallStraight(List<Integer> list) {
        return list.equals(asList(1, 2, 3, 4, 5));
    }

    public static boolean isLargeStraight(List<Integer> list) {
        return list.equals(asList(2, 3, 4, 5, 6));
    }
}
