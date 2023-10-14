import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.sort;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        Integer sum = list.stream()
            .reduce(0, (a, b) -> a + b);
        return sum;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        if (d1 == d2 && d2 == d3 && d3 == d4 && d4 == d5)
            return 50;
        else return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        int count = Utils.getCount(list,1);

        return count;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        int count = Utils.getCount(list,2);

        return count * 2;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        int count = Utils.getCount(list,3);

        return count * 3;
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        int count = Utils.getCount(list,4);

        return count * 4;
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        int count = Utils.getCount(list,5);;

        return count * 5;
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        int count = Utils.getCount(list,6);

        return count * 6;
    }

    public static int one_pair(int d1, int d2, int d3, int d4, int d5) {

        List<Integer> list = asList(d1, d2, d3, d4, d5);
        sort(list, Collections.reverseOrder());
        int i = 0;
        while (i < 6) {
            int finalI = i;
            int countItem = (int) list.stream().filter(item -> item == list.get(finalI)).count();
            if (countItem >= 2) {
                return list.get(finalI) * 2;
            }
            i++;
        }

        return 0;
    }

    public static int two_pairs(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        Collections.sort(list);;
        int i = 0;
        int score = 0;
        int result = 0;
        int precedentItem = 0;
        while (i < list.size() && score <= 2) {
            int finalI = i;
            int countItem = (int) list.stream().filter(item -> item == list.get(finalI)).count();
            if (countItem >= 2 && list.get(finalI) > precedentItem) {
                score++;
                result = result + list.get(finalI) * 2;

            }
            precedentItem = list.get(finalI);
            i++;
        }

        if (score == 2)
            return result;
        else
            return 0;
    }

    public static int four_kind(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);

        int i = 0;
        while (i < list.size()) {
            int finalI = i;
            int countItem = (int) list.stream().filter(item -> item == list.get(finalI)).count();
            if (countItem >= 4) {
                return list.get(finalI) * 4;
            }
            i++;
        }
        return 0;
    }

    public static int three_kind(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);

        int i = 0;
        while (i < list.size()) {
            int finalI = i;
            int countItem = (int) list.stream().filter(item -> item == list.get(finalI)).count();
            if (countItem >= 3) {
                return list.get(finalI) * 3;
            }
            i++;
        }

        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        Collections.sort(list);

        if (Utils.isSmallStraight(list))
            return 15;
        else
            return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        Collections.sort(list);

        if (Utils.isLargeStraight(list))
            return 20;
        else
            return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> list = asList(d1, d2, d3, d4, d5);
        Collections.sort(list);
        int countFirstItem = (int) list.stream().filter(item -> item == list.get(0)).count();
        int countLastItem = (int) list.stream().filter(item -> item == list.get(4)).count();
        if (!(list.get(0) == list.get(4)) && countFirstItem + countLastItem == 5) {
            return countFirstItem * list.get(0) + countLastItem * list.get(4);
        } else {
            return 0;
        }

    }
}



